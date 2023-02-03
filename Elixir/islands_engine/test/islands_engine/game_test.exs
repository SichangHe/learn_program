defmodule IslandsEngineTest.Game do
  use ExUnit.Case
  alias IslandsEngine.Game

  test "Walk through" do
    assert {:ok, game} = Game.start_link("Frank")
    assert :error = Game.guess_coordinate(game, :player1, 1, 1)
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

    assert :ok = Game.position_island(game, :player2, :square, 1, 1)
    assert :ok = Game.position_island(game, :player2, :atoll, 3, 1)
    assert :ok = Game.position_island(game, :player2, :dot, 4, 1)
    assert :ok = Game.position_island(game, :player2, :l_shape, 6, 1)
    assert :ok = Game.position_island(game, :player2, :s_shape, 2, 5)
    assert {:ok, _board} = Game.set_islands(game, :player2)

    state = :sys.get_state(game)
    assert :player1_turn = state.rules.state
    assert {:miss, :none, :no_win} = Game.guess_coordinate(game, :player1, 9, 8)
    assert {:hit, :none, :no_win} = Game.guess_coordinate(game, :player2, 1, 1)
    assert :error = Game.guess_coordinate(game, :player2, 2, 1)
    assert {:hit, :dot, :no_win} = Game.guess_coordinate(game, :player1, 4, 1)

    # Cheat by nuking player1's board.
    :sys.replace_state(game, fn state ->
      update_in(state.player1.board, fn _ ->
        %{
          dot: %IslandsEngine.Island{
            coordinates: MapSet.new([%IslandsEngine.Coordinate{row: 1, col: 1}]),
            hit_coordinates: MapSet.new([])
          }
        }
      end)
    end)

    assert {:hit, :dot, :win} = Game.guess_coordinate(game, :player2, 1, 1)
  end

  test "Via tuple" do
    name = "Lena"
    via = Game.via_tuple(name)
    assert {:ok, pid} = GenServer.start_link(Game.Server, name, name: via)
    assert %{} = :sys.get_state(via)
    assert {:error, {:already_started, ^pid}} = GenServer.start_link(Game.Server, name, name: via)
  end
end
