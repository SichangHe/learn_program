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
  import FirstMix.Registry

  setup do
    registry = start_supervised!(FirstMix.Registry)
    %{registry: registry}
  end

  test "Make the `shopping` bucket", %{registry: registry} do
    assert lookup(registry, "shopping") == :error
    create(registry, "shopping")
    assert {:ok, bk} = lookup(registry, "shopping")
    assert bk |> is_pid()
    FirstMix.Bucket.put(bk, "milk", 1)
    assert FirstMix.Bucket.get(bk, "milk") == 1
  end
end
