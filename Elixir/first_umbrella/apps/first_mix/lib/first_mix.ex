defmodule FirstMix do
  @moduledoc """
  Documentation for `FirstMix`.
  """

  @doc """
  Hello world.

  ## Examples

      iex> FirstMix.hello()
      :world

  """
  use Application

  @impl true
  def start(_type, _args) do
    FirstMix.Supervisor.start_link(name: FirstMix.Supervisor)
  end

  def hello do
    :world
  end
end
