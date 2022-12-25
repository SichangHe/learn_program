defmodule FirstMixServer.Application do
  # See https://hexdocs.pm/elixir/Application.html
  # for more information on OTP Applications
  @moduledoc false

  use Application

  @impl true
  def start(_type, _args) do
    port =
      case System.get_env("PORT") do
        nil -> 4040
        port -> port |> String.to_integer()
      end

    children = [
      {Task.Supervisor, name: FirstMixServer.TaskSupervisor},
      {Task, fn -> FirstMixServer.accept(port) end}
    ]

    # See https://hexdocs.pm/elixir/Supervisor.html
    # for other strategies and supported options
    opts = [strategy: :one_for_one, name: FirstMixServer.Supervisor]
    Supervisor.start_link(children, opts)
  end
end
