defmodule IslandsEngine.Coordinate do
  alias IslandsEngine.Coordinate

  @doc """
  A coordinate on the board.
  """
  @enforce_keys [:row, :col]
  defstruct [:row, :col]

  @board_range 1..10

  @spec new(1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10, 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10) ::
          %Coordinate{
            row: 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10,
            col: 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10
          }
  def new(row, col) when row in @board_range and col in @board_range,
    do: %Coordinate{row: row, col: col}
end
