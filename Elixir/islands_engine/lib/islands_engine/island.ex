defmodule IslandsEngine.Island do
  alias IslandsEngine.{Coordinate, Island}

  @enforce_keys [:coordinates, :hit_coordinates]
  defstruct [:coordinates, :hit_coordinates]

  @type island_type_error :: {:error, :invalid_island_type}
  @type t :: %Island{coordinates: Coordinate.s(), hit_coordinates: MapSet.t(Coordinate.t())}

  @spec new(atom, Coordinate.t()) :: {:ok, t} | {:error, atom}
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

  @spec add_coordinates([{integer, integer}], Coordinate.t()) ::
          Coordinate.s() | island_type_error
  defp add_coordinates(offsets, upper_left) do
    Enum.reduce_while(offsets, MapSet.new(), fn offset, acc ->
      add_coordinate(acc, offset, upper_left)
    end)
  end

  @spec add_coordinate(Coordinate.s(), {integer, integer}, Coordinate.t()) ::
          {:cont, Coordinate.s()} | {:halt, {:error, :invalid_coordinate}}
  defp add_coordinate(coordinates, {row_offset, col_offset}, %Coordinate{row: row, col: col}) do
    case Coordinate.new(row + row_offset, col + col_offset) do
      {:ok, coord} -> {:cont, MapSet.put(coordinates, coord)}
      {:error, :invalid_coordinate} -> {:halt, {:error, :invalid_coordinate}}
    end
  end

  @spec disjoint?(t, t) :: boolean
  def disjoint?(existing, new),
    do: MapSet.disjoint?(existing.coordinates, new.coordinates)

  @spec guess(t, Coordinate.t()) :: {:hit, t} | :miss
  def guess(island, coordinate) do
    if MapSet.member?(island.coordinates, coordinate) do
      {:hit, %Island{island | hit_coordinates: MapSet.put(island.hit_coordinates, coordinate)}}
    else
      :miss
    end
  end

  @spec forested?(t) :: boolean
  def forested?(island), do: MapSet.equal?(island.coordinates, island.hit_coordinates)
end
