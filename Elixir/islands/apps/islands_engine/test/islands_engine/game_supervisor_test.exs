defmodule IslandsEngine.GameSupervisorTest do
  use ExUnit.Case, async: true
  alias IslandsEngine.{Game, GameSupervisor}

  test "Restore state after game crash" do
    player1 = "Morandi"
    player2 = "Rothko"
    {:ok, game} = GameSupervisor.start_game(player1)
    assert :ok = Game.add_player(game, player2)

    Process.exit(game, :kill)
    :timer.sleep(50)
    via = Game.via_tuple(player1)
    state = :sys.get_state(via)
    assert player2 == state.player2.name
  end

  test "Remove backup state after stopping game" do
    player1 = "Agnes"
    {:ok, game} = GameSupervisor.start_game(player1)
    Game.add_player(game, "Tom")
    assert [{^player1, _}] = :ets.lookup(:game_state, player1)

    GameSupervisor.stop_game(player1)
    assert [] = :ets.lookup(:game_state, player1)
  end
end
