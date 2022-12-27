defmodule IslandsEngineTest do
  use ExUnit.Case
  doctest IslandsEngine

  test "greets the world" do
    assert IslandsEngine.hello() == :world
  end
end

defmodule IslandsEngineTest.Coordinate do
  use ExUnit.Case
  alias IslandsEngine.Coordinate

  test "Type safety of the Coordinate struct" do
    assert %Coordinate{row: 1, col: 1} = Coordinate.new(1, 1)
    Coordinate.new(0, 1) |> catch_error()
    Coordinate.new("a", 1) |> catch_error()
    Coordinate.new(11, 1) |> catch_error()
    Coordinate.new(1, -1) |> catch_error()
    Coordinate.new(1, "a") |> catch_error()
    Coordinate.new(1, 11) |> catch_error()
    Coordinate.new(1.0, 1) |> catch_error()
  end
end

defmodule IslandsEngineTest.Guesses do
  use ExUnit.Case
  alias IslandsEngine.{Coordinate, Guesses}

  test "Create and insert guesses" do
    guesses = Guesses.new()
    coord1 = Coordinate.new(1, 1)
    guesses = update_in(guesses.hits, &MapSet.put(&1, coord1))
    assert coord1 in guesses.hits
  end
end
