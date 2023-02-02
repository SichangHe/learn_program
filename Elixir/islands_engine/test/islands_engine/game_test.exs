defmodule IslandsEngineTest.Game do
  use ExUnit.Case
  alias IslandsEngine.{Game, Rules}

  test "Walk through" do
    assert {:ok, game} = Game.start_link("Frank")
    p2 = "Dweezil"
    assert :ok = Game.add_player(game, p2)
    state = :sys.get_state(game)
    assert ^p2 = state.player2.name
    assert :players_set = state.rules.state
    assert :ok = Game.position_island(game, :player1, :square, 1, 1)
    assert {:error, :invalid_coordinate} = Game.position_island(game, :player1, :dot, 12, 1)
    assert {:error, :invalid_island_type} = Game.position_island(game, :player1, :wrong, 1, 1)
    assert {:error, :invalid_coordinate} = Game.position_island(game, :player1, :l_shape, 10, 10)
    :sys.replace_state(game, &%{&1 | rules: %Rules{state: :player1_turn}})
    assert :error = Game.position_island(game, :player1, :dot, 5, 5)
  end
end
