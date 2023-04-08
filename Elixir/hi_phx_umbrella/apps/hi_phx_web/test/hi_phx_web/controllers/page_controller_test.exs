defmodule HiPhxWeb.PageControllerTest do
  use HiPhxWeb.ConnCase

  test "GET /", %{conn: conn} do
    conn = get(conn, "/")
    assert html_response(conn, 200) =~ "Welcome to Phoenix!"
  end

  test "get /hi", %{conn: conn} do
    conn = get(conn, "/hi")
    assert html_response(conn, 200) =~ "Hi"
  end

  test "get /hi/:from", %{conn: conn} do
    conn = get(conn, "/hi/there")
    assert html_response(conn, 200) =~ "Hi there."
  end
end
