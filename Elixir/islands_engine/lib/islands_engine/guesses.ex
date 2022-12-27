defmodule IslandsEngine.Guesses do
  alias IslandsEngine.Guesses
  @enforce_keys [:hits, :misses]
  defstruct [:hits, :misses]

  @spec new() :: %Guesses{hits: MapSet.t(), misses: MapSet.t()}
  def new(), do: %Guesses{hits: MapSet.new(), misses: MapSet.new()}
end
