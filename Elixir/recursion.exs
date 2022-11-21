defmodule Recursion do
  def print_times(_, 0), do: :ok

  def print_times(msg, n) when is_integer(n) and n > 0 do
    IO.puts(msg)
    print_times(msg, n - 1)
  end
end

Recursion.print_times("Lol", 3)
Recursion.print_times("Lol", 0)
Recursion.print_times("Lol", -1)
