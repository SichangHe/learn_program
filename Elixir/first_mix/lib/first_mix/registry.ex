defmodule FirstMix.Registry do
  use GenServer
  require Logger

  defstruct names: %{}, refs: %{}

  @doc """
  Start the registry with the given options, where `:name` is required.
  """
  @spec start_link(name: String.t(), atom: String.t()) :: GenServer.on_start()
  def start_link(opts) do
    server = Keyword.fetch!(opts, :name)
    GenServer.start_link(__MODULE__, server, opts)
  end

  @doc """
  Look up the PID for the bucket corresponding to `name`.
  """
  @spec lookup(pid(), String.t()) :: {:ok, pid()} | :error
  def lookup(server, name) do
    case :ets.lookup(server, name) do
      [{^name, pid}] -> {:ok, pid}
      [] -> :error
    end
  end

  @doc """
  Create a bucket named `name` if it does not exist.
  """
  @spec create(pid(), String.t()) :: :ok
  def create(server, name) do
    GenServer.call(server, {:create, name})
  end

  @impl true
  def init(table) do
    {:ok, %FirstMix.Registry{names: :ets.new(table, [:named_table, read_concurrency: true])}}
  end

  @impl true
  def handle_call({:create, name}, _from, state) do
    case lookup(state.names, name) do
      {:ok, bucket} ->
        {:reply, bucket, state}

      :error ->
        {:ok, bucket} = DynamicSupervisor.start_child(FirstMix.BucketSupervisor, FirstMix.Bucket)
        ref = Process.monitor(bucket)
        :ets.insert(state.names, {name, bucket})

        {:reply, bucket,
         %FirstMix.Registry{
           state
           | refs: state.refs |> Map.put(ref, name)
         }}
    end
  end

  @impl true
  def handle_info({:DOWN, ref, :process, _pid, _reason}, state) do
    {name, refs} = Map.pop(state.refs, ref)
    :ets.delete(state.names, name)
    {:noreply, %FirstMix.Registry{state | refs: refs}}
  end

  @impl true
  def handle_info(msg, state) do
    Logger.debug("Unexpected message in FirstMix.Registry: #{inspect(msg)}")
    {:noreply, state}
  end
end
