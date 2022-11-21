defmodule Zero do
  @spec zero?(integer) :: boolean
  def zero?(0), do: true
  def zero?(x) when is_integer(x), do: false
end

IO.puts Zero.zero?(0)
IO.puts Zero.zero?(1)
IO.puts Zero.zero?([1, 2])