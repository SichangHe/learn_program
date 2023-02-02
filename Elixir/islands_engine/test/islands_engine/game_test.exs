defmodule IslandsEngineTest.Game do
  use ExUnit.Case
  alias IslandsEngine.Game

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

    assert {:error, :not_all_islands_positioned} = Game.set_islands(game, :player1)

    assert :ok = Game.position_island(game, :player1, :atoll, 3, 1)
    assert :ok = Game.position_island(game, :player1, :dot, 4, 1)
    assert :ok = Game.position_island(game, :player1, :l_shape, 6, 1)
    assert :ok = Game.position_island(game, :player1, :s_shape, 2, 5)

    assert {:ok, _board} = Game.set_islands(game, :player1)
    state = :sys.get_state(game)
    assert :islands_set = state.rules.player1
    assert :players_set = state.rules.state
  end
end
