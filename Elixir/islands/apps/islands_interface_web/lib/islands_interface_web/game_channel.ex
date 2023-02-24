defmodule IslandsInterfaceWeb.GameChannel do
  use IslandsInterfaceWeb, :channel
  alias IslandsEngine.{Game, GameSupervisor}

  def join("game:" <> player, _payload, socket) do
    IO.inspect(player)
    {:ok, socket}
  end
end
