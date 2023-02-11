defmodule IslandsEngine.GameSupervisor do
  use DynamicSupervisor

  alias IslandsEngine.Game

  def start_link(_opt), do: DynamicSupervisor.start_link(__MODULE__, :ok, name: __MODULE__)

  @spec start_game(String.t()) :: {:ok, pid}
  def start_game(name), do: DynamicSupervisor.start_child(__MODULE__, {Game.Server, name})

  @spec stop_game(String.t()) :: :ok | {:error, :not_found}
  def stop_game(name), do: DynamicSupervisor.terminate_child(__MODULE__, pid_from_name(name))

  @impl true
  def init(:ok), do: DynamicSupervisor.init(strategy: :one_for_one)

  @spec pid_from_name(String.t()) :: pid | nil
  defp pid_from_name(name), do: name |> Game.via_tuple() |> GenServer.whereis()
end
