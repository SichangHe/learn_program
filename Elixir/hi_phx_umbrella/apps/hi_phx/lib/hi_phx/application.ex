defmodule HiPhx.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  use Application

  @impl true
  def start(_type, _args) do
    children = [
      # Start the Ecto repository
      HiPhx.Repo,
      # Start the PubSub system
      {Phoenix.PubSub, name: HiPhx.PubSub}
      # Start a worker by calling: HiPhx.Worker.start_link(arg)
      # {HiPhx.Worker, arg}
    ]

    Supervisor.start_link(children, strategy: :one_for_one, name: HiPhx.Supervisor)
  end
end
