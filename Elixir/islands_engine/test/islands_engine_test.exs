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

defmodule IslandsEngineTest.Rules do
  use ExUnit.Case
  alias IslandsEngine.Rules

  test "Walk through." do
    rules = Rules.new()
    assert :initialized = rules.state
    {:ok, rules} = Rules.check(rules, :add_player)
    assert :players_set = rules.state
    {:ok, rules} = Rules.check(rules, {:position_islands, :player1})
    assert :players_set = rules.state
    {:ok, rules} = Rules.check(rules, {:position_islands, :player2})
    assert :players_set = rules.state
    {:ok, rules} = Rules.check(rules, {:set_islands, :player1})
    assert :players_set = rules.state
    assert :error = Rules.check(rules, {:position_islands, :player1})
    {:ok, rules} = Rules.check(rules, {:position_islands, :player2})
    assert :players_set = rules.state
    {:ok, rules} = Rules.check(rules, {:set_islands, :player2})
    assert :player1_turn = rules.state
    assert :error = Rules.check(rules, {:guess_coordinate, :player2})
    {:ok, rules} = Rules.check(rules, {:guess_coordinate, :player1})
    assert :player2_turn = rules.state
    assert :error = Rules.check(rules, {:guess_coordinate, :player1})
    {:ok, rules} = Rules.check(rules, {:guess_coordinate, :player2})
    assert :player1_turn = rules.state
    {:ok, rules} = Rules.check(rules, {:win_check, :no_win})
    assert :player1_turn = rules.state
    {:ok, rules} = Rules.check(rules, {:win_check, :win})
    assert :game_over = rules.state
  end
end
