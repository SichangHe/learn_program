defmodule MapReduce do
  @spec sum_list(list, number) :: number
  def sum_list([], accumulator), do: accumulator

  def sum_list([head | tail], accumulator) do
    sum_list(tail, head + accumulator)
  end

  @spec double_each(list) :: list
  def double_each([]), do: []

  def double_each([head | tail]) do
    [head * 2 | double_each(tail)]
  end
end

l = [1, 2, 3]
l |> MapReduce.sum_list(0) |> IO.puts()
l |> MapReduce.double_each() |> inspect(charlists: :as_lists) |> IO.puts()

"Same but with reduce and map." |> IO.puts()
l |> Enum.reduce(0, fn x, accumulator -> x + accumulator end) |> IO.puts()
l |> Enum.map(fn x -> x * 2 end) |> inspect(charlists: :as_lists) |> IO.puts()

"Using capture syntax" |> IO.puts()
l |> Enum.reduce(0, &+/2) |> IO.puts()
l |> Enum.map(&(&1 * 2)) |> inspect(charlists: :as_lists) |> IO.puts()

"Using streams" |> IO.puts()
l |> Stream.map(&(&1 * &1)) |> Stream.filter(&(&1 |> rem(2) != 0)) |> Enum.sum() |> IO.puts()