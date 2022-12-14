defmodule FirstMix.Bucket do
  use Agent

  @doc """
  Start a new bucket.
  """
  @spec start_link([{atom(), any()}]) :: Agent.on_start()
  def start_link(options), do: fn -> %{} end |> Agent.start_link(options)

  @doc """
  Get a value in `bucket` by `key`.
  """
  @spec get(Agent.on_start(), any()) :: any()
  def get(bucket, key), do: bucket |> Agent.get(& &1[key])

  @doc """
  Put `value` for `key` into `bucket`.
  """
  @spec put(Agent.on_start(), any(), any()) :: :ok
  def put(bucket, key, value), do: bucket |> Agent.update(&(&1 |> Map.put(key, value)))
end
