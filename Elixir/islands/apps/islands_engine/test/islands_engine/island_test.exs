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

  test "Detect islands disjoint and forested" do
    {:ok, upper_left} = Coordinate.new(1, 1)
    {:ok, upper_second_left} = Coordinate.new(1, 2)
    {:ok, center} = Coordinate.new(5, 5)
    {:ok, square} = Island.new(:square, upper_left)
    {:ok, dot} = Island.new(:dot, upper_second_left)
    {:ok, ell} = Island.new(:l_shape, center)
    assert not Island.disjoint?(square, dot)
    assert Island.disjoint?(square, ell)
    assert Island.disjoint?(dot, ell)

    assert :miss = Island.guess(dot, upper_left)
    assert not Island.forested?(dot)
    assert {:hit, dot} = Island.guess(dot, upper_second_left)
    assert Island.forested?(dot)
  end
end
