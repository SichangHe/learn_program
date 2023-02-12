defmodule IslandsEngine.Guesses do
  alias IslandsEngine.{Coordinate, Guesses}
  @enforce_keys [:hits, :misses]
  defstruct [:hits, :misses]

  @type t :: %Guesses{hits: MapSet.t(Coordinate.t()), misses: MapSet.t(Coordinate.t())}

  @spec new() :: %Guesses{hits: MapSet.t(), misses: MapSet.t()}
  def new(), do: %Guesses{hits: MapSet.new(), misses: MapSet.new()}

  @spec add(t, :hit | :miss, Coordinate.t()) :: Guesses.t()
  def add(%Guesses{} = guesses, :hit, %Coordinate{} = coordinate),
    do: update_in(guesses.hits, &MapSet.put(&1, coordinate))

  def add(%Guesses{} = guesses, :miss, %Coordinate{} = coordinate),
    do: update_in(guesses.misses, &MapSet.put(&1, coordinate))
end
