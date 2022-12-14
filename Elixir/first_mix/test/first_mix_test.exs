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
