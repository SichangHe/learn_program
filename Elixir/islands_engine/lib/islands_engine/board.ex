defmodule IslandsEngine.Board do
  alias IslandsEngine.{Coordinate, Island}

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

  @spec guess(t, Coordinate.t()) :: {:hit | :miss, atom, :win | :no_win, t}
  def guess(board, %Coordinate{} = coordinate),
    do: board |> check_all_islands(coordinate) |> guess_response(board)

  @spec check_all_islands(t, Coordinate.t()) :: {atom, Island.t()} | :miss
  defp check_all_islands(board, coord) do
    Enum.find_value(board, :miss, fn {key, island} ->
      case Island.guess(island, coord) do
        {:hit, island} -> {key, island}
        :miss -> false
      end
    end)
  end

  @spec guess_response({atom, Island.t()} | :miss, t) ::
          {:hit | :miss, atom, :win | :no_win, t}
  defp guess_response({key, island}, board),
    do: {:hit, forest_check(board, key), win_check(board), %{board | key => island}}

  defp guess_response(:miss, board), do: {:miss, :none, :no_win, board}

  @spec forest_check(t, atom) :: atom
  defp forest_check(board, key) do
    if forested?(board, key), do: key, else: :none
  end

  @spec forested?(t, atom) :: boolean
  defp forested?(board, key), do: board |> Map.fetch!(key) |> Island.forested?()

  @spec win_check(t) :: :win | :no_win
  defp win_check(board) do
    if all_forested?(board), do: :win, else: :no_win
  end

  @spec all_forested?(t) :: boolean
  defp all_forested?(board),
    do: Enum.all?(board, fn {_, island} -> Island.forested?(island) end)
end
