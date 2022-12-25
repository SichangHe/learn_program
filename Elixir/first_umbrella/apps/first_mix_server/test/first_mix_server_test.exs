defmodule FirstMixServerTest do
  use ExUnit.Case
  doctest FirstMixServer

  test "greets the world" do
    assert FirstMixServer.hello() == :world
  end
end
