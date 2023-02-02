defmodule IslandsEngineTest.Guesses do
  use ExUnit.Case
  alias IslandsEngine.{Coordinate, Guesses}

  test "Create and insert guesses" do
    guesses = Guesses.new()
    {:ok, coord1} = Coordinate.new(1, 1)
    guesses = Guesses.add(guesses, :hit, coord1)
    assert coord1 in guesses.hits
  end
end
