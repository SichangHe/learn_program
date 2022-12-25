defmodule FirstMix.Bucket do
  use Agent, restart: :temporary

  @doc """
  Start a new bucket.
  """
  @spec start_link([{atom(), any()}]) :: {:ok, pid()}
  def start_link(options), do: fn -> %{} end |> Agent.start_link(options)

  @doc """
  Get a value in `bucket` by `key`.
  """
  @spec get(pid(), any()) :: any()
  def get(bucket, key), do: bucket |> Agent.get(& &1[key])

  @doc """
  Put `value` for `key` into `bucket`.
  """
  @spec put(pid(), any(), any()) :: :ok
  def put(bucket, key, value), do: bucket |> Agent.update(&(&1 |> Map.put(key, value)))

  @doc """
  Pop `key` and return its corresponding `value` from `bucket`.
  """
  @spec pop(pid(), any()) :: any()
  def pop(bucket, key), do: bucket |> Agent.get_and_update(&Map.pop(&1, key))
end
