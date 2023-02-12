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
