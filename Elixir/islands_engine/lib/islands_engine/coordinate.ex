defmodule IslandsEngine.Coordinate do
  alias IslandsEngine.Coordinate

  @doc """
  A coordinate on the board.
  """
  @enforce_keys [:row, :col]
  defstruct [:row, :col]

  @board_range 1..10
  @type t :: %Coordinate{row: integer, col: integer}
  @type s :: MapSet.t(t)

  @spec new(integer, integer) :: {:ok, t} | {:error, :invalid_coordinate}
  def new(row, col) when row in @board_range and col in @board_range,
    do: {:ok, %Coordinate{row: row, col: col}}

  def new(row, col) when row |> is_integer() and col |> is_integer(),
    do: {:error, :invalid_coordinate}
end
