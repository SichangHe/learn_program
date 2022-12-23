defmodule FirstMix.Supervisor do
  use Supervisor

  def start_link(opts) do
    Supervisor.start_link(__MODULE__, :ok, opts)
  end

  @impl true
  def init(:ok) do
    [
      {DynamicSupervisor, name: FirstMix.BucketSupervisor, strategy: :one_for_one},
      {FirstMix.Registry, name: FirstMix.Registry}
    ]
    |> Supervisor.init(strategy: :one_for_all)
  end
end
