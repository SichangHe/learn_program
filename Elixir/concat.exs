defmodule Concat do
  def default(x \\ "nothing") do
    x
  end

  def join(a, b \\ nil, sep \\ " ")

  def join(a, b, _) when is_nil(b) do
    a
  end

  def join(a, b, sep) do
    a <> sep <> b
  end
end

IO.puts(Concat.default("Hey"))
IO.puts(Concat.default())
IO.puts(Concat.join("Hey", "yo"))
IO.puts(Concat.join("Hey"))
