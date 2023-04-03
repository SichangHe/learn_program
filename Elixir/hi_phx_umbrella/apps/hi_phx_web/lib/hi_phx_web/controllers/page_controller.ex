defmodule HiPhxWeb.PageController do
  use HiPhxWeb, :controller

  def index(conn, _params) do
    render(conn, "index.html")
  end
end
