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
    assert {:ok, %Coordinate{row: 1, col: 1}} = Coordinate.new(1, 1)
    assert {:error, :invalid_coordinate} = Coordinate.new(0, 1)
    Coordinate.new("a", 1) |> catch_error()
    assert {:error, :invalid_coordinate} = Coordinate.new(11, 1)
    assert {:error, :invalid_coordinate} = Coordinate.new(1, -1)
    Coordinate.new(1, "a") |> catch_error()
    assert {:error, :invalid_coordinate} = Coordinate.new(1, 11)
    Coordinate.new(1.0, 1) |> catch_error()
  end
end

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

defmodule IslandsEngineTest.Island do
  use ExUnit.Case
  alias IslandsEngine.{Coordinate, Island}

  test "Create islands" do
    {:ok, upper_left} = Coordinate.new(1, 1)
    {:ok, lower_left} = Coordinate.new(9, 1)
    assert {:ok, _} = Island.new(:square, upper_left)
    assert {:ok, _} = Island.new(:l_shape, upper_left)
    assert {:error, :invalid_island_type} = Island.new(:unknown, upper_left)
    assert {:error, :invalid_coordinate} = Island.new(:l_shape, lower_left)
  end

  test "Detect islands disjoint" do
    {:ok, upper_left} = Coordinate.new(1, 1)
    {:ok, upper_second_left} = Coordinate.new(1, 2)
    {:ok, center} = Coordinate.new(5, 5)
    {:ok, square} = Island.new(:square, upper_left)
    {:ok, dot} = Island.new(:dot, upper_second_left)
    {:ok, ell} = Island.new(:l_shape, center)
    assert not Island.disjoint?(square, dot)
    assert Island.disjoint?(square, ell)
    assert Island.disjoint?(dot, ell)
  end
end
