defmodule IslandsEngineTest.Coordinate do
  use ExUnit.Case
  alias IslandsEngine.Coordinate

  test "Type safety of the Coordinate struct" do
    assert {:ok, %Coordinate{row: 1, col: 1}} = Coordinate.new(1, 1)
    assert {:error, :invalid_coordinate} = Coordinate.new(0, 1)
    Coordinate.new("a", 1) |> catch_error()
    assert {:error, :invalid_coordinate} = Coordinate.new(11, 1)
    assert {:error, :invalid_coordinate} = Coordinate.new(1, -1)
    Coordinate.new(1, "a") |> catch_error()
    assert {:error, :invalid_coordinate} = Coordinate.new(1, 11)
    Coordinate.new(1.0, 1) |> catch_error()
  end
end
