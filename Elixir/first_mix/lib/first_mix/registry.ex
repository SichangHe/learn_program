defmodule FirstMix.Registry do
  use GenServer

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
    {:ok, %{}}
  end

  @impl true
  def handle_call({:lookup, name}, _from, names) do
    {:reply, Map.fetch(names, name), names}
  end

  @impl true
  def handle_cast({:create, name}, names) do
    if Map.has_key?(names, name) do
      {:noreply, names}
    else
      {:ok, bucket} = FirstMix.Bucket.start_link([])
      {:noreply, Map.put(names, name, bucket)}
    end
  end
end
