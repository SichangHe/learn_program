defmodule FirstMixTest do
  use ExUnit.Case
  doctest FirstMix

  test "greets the world" do
    assert FirstMix.hello() == :world
  end
end

defmodule FirstMix.BucketTest do
  use ExUnit.Case, async: true

  test "Store value by key" do
    {:ok, bucket} = FirstMix.Bucket.start_link([])
    assert FirstMix.Bucket.get(bucket, "milk") == nil
    FirstMix.Bucket.put(bucket, "milk", 3)
    assert FirstMix.Bucket.get(bucket, "milk") == 3
  end
end
