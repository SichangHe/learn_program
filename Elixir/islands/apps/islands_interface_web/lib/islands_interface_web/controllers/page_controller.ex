defmodule IslandsInterfaceWeb.PageController do
  alias IslandsEngine.GameSupervisor
  use IslandsInterfaceWeb, :controller

  def index(conn, _params) do
    render(conn, "index.html")
  end

  def test(conn, %{"name" => name}) do
    {:ok, _game} = GameSupervisor.start_game(name)
    conn |> put_flash(:info, "Starting game with name `#{name}`.") |> render("index.html")
  end
end
