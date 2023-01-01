defmodule IslandsEngine.Board do
  alias IslandsEngine.Island

  @type t :: %{atom => Island.t()}

  @spec new() :: t
  def new(), do: %{}

  @spec position_island(t, atom, Island.t()) :: t
  def position_island(board, key, island) do
    if disjoint_existing_islands(board, key, island) do
      Map.put(board, key, island)
    else
      {:error, :overlapping_island}
    end
  end

  @spec disjoint_existing_islands(t, atom, Island.t()) :: boolean
  defp disjoint_existing_islands(board, key, island),
    do: Enum.all?(board, fn {k, i} -> Island.disjoint?(island, i) or key == k end)

  @spec all_islands_positioned?(t) :: boolean
  def all_islands_positioned?(board),
    do: Enum.all?(Island.types(), &Map.has_key?(board, &1))
end
