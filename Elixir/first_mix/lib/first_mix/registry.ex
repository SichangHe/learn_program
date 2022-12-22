defmodule FirstMix.Registry do
  use GenServer
  require Logger

  defstruct names: %{}, refs: %{}

  @doc """
  Start the registry.
  """
  def start_link(opts) do
    GenServer.start_link(__MODULE__, :ok, opts)
  end

  @doc """
  Look up the PID for the bucket corresponding to `name`.
  """
  @spec lookup(pid(), String.t()) :: {:ok, pid()} | :error
  def lookup(server, name) do
    GenServer.call(server, {:lookup, name})
  end

  @doc """
  Create a bucket named `name` if it does not exist.
  """
  @spec create(pid(), String.t()) :: :ok
  def create(server, name) do
    GenServer.cast(server, {:create, name})
  end

  @impl true
  def init(:ok) do
    {:ok, %FirstMix.Registry{}}
  end

  @impl true
  def handle_call({:lookup, name}, _from, state) do
    {:reply, Map.fetch(state.names, name), state}
  end

  @impl true
  def handle_cast({:create, name}, state) do
    if Map.has_key?(state.names, name) do
      {:noreply, state}
    else
      {:ok, bucket} = FirstMix.Bucket.start_link([])
      ref = Process.monitor(bucket)

      {:noreply,
       %FirstMix.Registry{
         names: state.names |> Map.put(name, bucket),
         refs: state.refs |> Map.put(ref, name)
       }}
    end
  end

  @impl true
  def handle_info({:DOWN, ref, :process, _pid, _reason}, state) do
    {name, refs} = Map.pop(state.refs, ref)
    {:noreply, %FirstMix.Registry{names: state.names |> Map.delete(name), refs: refs}}
  end

  @impl true
  def handle_info(msg, state) do
    Logger.debug("Unexpected message in FirstMix.Registry: #{inspect(msg)}")
    {:noreply, state}
  end
end
