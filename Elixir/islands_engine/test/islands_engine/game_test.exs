defmodule IslandsEngineTest.Game do
  use ExUnit.Case
  alias IslandsEngine.Game

  assert {:ok, game} = Game.start_link("Frank")
  p2 = "Dweezil"
  assert :ok = Game.add_player(game, p2)
  assert ^p2 = :sys.get_state(game).player2.name
end
