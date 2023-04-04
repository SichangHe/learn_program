defmodule HiPhxWeb.PageController do
  use HiPhxWeb, :controller

  def index(conn, _params) do
    render(conn, "index.html")
  end

  def hi(conn, _params) do
    render(conn, :hi)
  end

  def show(conn, %{"from" => from}) do
    render(conn, :show, from: from)
  end
end
