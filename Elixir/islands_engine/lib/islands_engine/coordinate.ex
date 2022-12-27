defmodule IslandsEngine.Coordinate do
  alias IslandsEngine.Coordinate

  @doc """
  A coordinate on the board.
  """
  @enforce_keys [:row, :col]
  defstruct [:row, :col]

  @board_range 1..10

  @spec new(integer, integer) :: {:ok, Coordinate} | {:error, :invalid_coordinate}
  def new(row, col) when row in @board_range and col in @board_range do
    %Coordinate{row: row, col: col}
  end

  def new(row, col) when row |> is_integer() and col |> is_integer() do
    {:error, :invalid_coordinate}
  end
end
