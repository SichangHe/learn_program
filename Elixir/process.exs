pid = fn -> 1 + 2 end |> spawn()
"Checking process with pid #{inspect(pid)}." |> IO.puts()
Process.alive?(pid) |> IO.puts()

self_pid = self()
"Checking self with pid #{inspect(self_pid)}." |> IO.puts()
Process.alive?(self_pid) |> IO.puts()

"Sending self a message and receiving it." |> IO.puts()
self_pid |> send({:hey, "yo"})

receive do
  {:hey, msg} -> msg
  # not reached
  {:hi, msg} -> "hi #{msg}"
end
|> IO.puts()

"Receiving a message and timeout after 1000ms." |> IO.puts()

receive do
  {:hey, msg} -> msg
after
  1_000 -> "Timed out."
end
|> IO.puts()
