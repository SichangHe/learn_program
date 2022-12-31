defmodule IslandsEngine.Island do
  alias IslandsEngine.{Coordinate, Guesses, Island}

  @enforce_keys [:coordinates, :hit_coordinates]
  defstruct [:coordinates, :hit_coordinates]

  @type island_type_error :: {:error, :invalid_island_type}
  @type coords :: MapSet.t(Coordinate)

  @spec new(atom, Coordinate) :: {:ok, Island} | {:error, atom}
  def new(type, upper_left) do
    with [_ | _] = offsets <- offset(type),
         %MapSet{} = coords <- add_coordinates(offsets, upper_left) do
      {:ok, %Island{coordinates: coords, hit_coordinates: MapSet.new()}}
    else
      error -> error
    end
  end

  @spec offset(atom) :: [{integer, integer}] | island_type_error
  defp offset(:square), do: [{0, 0}, {0, 1}, {1, 0}, {1, 1}]
  defp offset(:atoll), do: [{0, 0}, {0, 1}, {1, 1}, {2, 0}, {2, 1}]
  defp offset(:dot), do: [{0, 0}]
  defp offset(:l_shape), do: [{0, 0}, {1, 0}, {2, 0}, {2, 1}]
  defp offset(:s_shape), do: [{0, 1}, {0, 2}, {1, 0}, {1, 1}]
  defp offset(_), do: {:error, :invalid_island_type}

  @spec add_coordinates([{integer, integer}], Coordinate) ::
          coords | island_type_error
  defp add_coordinates(offsets, upper_left) do
    Enum.reduce_while(offsets, MapSet.new(), fn offset, acc ->
      add_coordinate(acc, offset, upper_left)
    end)
  end

  @spec add_coordinate(coords, {integer, integer}, Coordinate) ::
          {:cont, coords} | {:halt, {:error, :invalid_coordinate}}
  defp add_coordinate(coordinates, {row_offset, col_offset}, %Coordinate{row: row, col: col}) do
    case Coordinate.new(row + row_offset, col + col_offset) do
      {:ok, coord} -> {:cont, MapSet.put(coordinates, coord)}
      {:error, :invalid_coordinate} -> {:halt, {:error, :invalid_coordinate}}
    end
  end
end
