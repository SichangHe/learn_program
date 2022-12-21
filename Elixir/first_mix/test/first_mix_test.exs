defmodule FirstMixTest do
  use ExUnit.Case
  doctest FirstMix

  test "greets the world" do
    assert FirstMix.hello() == :world
  end
end

defmodule FirstMix.BucketTest do
  use ExUnit.Case, async: true
  import FirstMix.Bucket

  setup do
    {:ok, bucket} = start_link([])
    %{bucket: bucket}
  end

  test "Store value by key", %{bucket: bucket} do
    assert get(bucket, "milk") == nil
    put(bucket, "milk", 3)
    assert get(bucket, "milk") == 3
  end

  test "Pop out key", %{bucket: bucket} do
    put(bucket, "milk", 3)
    assert pop(bucket, "milk") == 3
    assert get(bucket, "milk") == nil
  end
end

defmodule FirstMixTest.RegistryTest do
  use ExUnit.Case, async: true

  test "Make the `shopping` registry" do
    {:ok, registry} = GenServer.start_link(FirstMix.Registry, :ok)
    GenServer.cast(registry, {:create, "shopping"})
    {:ok, bk} = GenServer.call(registry, {:lookup, "shopping"})
    assert bk |> is_pid()
    assert GenServer.call(registry, {:lookup, "DNE"}) == :error
  end
end
