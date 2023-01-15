defmodule IslandsEngine.Game.Player do
  alias IslandsEngine.{Board, Guesses}

  defstruct name: nil,
            board: Board.new(),
            guesses: Guesses.new()

  alias __MODULE__

  @type t :: %Player{name: String.t() | nil, board: Board.t(), guesses: Guesses.t()}
end

defmodule IslandsEngine.Game.State do
  alias IslandsEngine.{Game.Player, Rules}

  defstruct player1: %Player{},
            player2: %Player{},
            rules: Rules.new()

  alias __MODULE__

  @type t :: %State{player1: Player.t(), player2: Player.t(), rules: Rules.t()}
end

defmodule IslandsEngine.Game.Server do
  use GenServer
  alias IslandsEngine.Rules
  alias IslandsEngine.Game.{Player, State}

  @type call :: {:add_player, String.t()}
  @type reply_content :: :ok | :error

  @spec init(String.t()) :: {:ok, State.t()}
  def init(name), do: {:ok, %State{player1: %Player{name: name}}}

  @spec handle_call(call, any, State.t()) :: {:reply, reply_content, State.t()}
  def handle_call({:add_player, name}, _from, state) do
    with {:ok, rules} <- Rules.check(state.rules, :add_player) do
      state |> update_player2_name(name) |> update_rules(rules) |> reply_with(:ok)
    else
      :error -> reply_with(state, :error)
    end
  end

  @spec update_player2_name(State.t(), String.t()) :: State.t()
  defp update_player2_name(state, name), do: put_in(state.player2.name, name)

  @spec update_rules(State.t(), Rules.t()) :: State.t()
  defp update_rules(state, rules), do: %State{state | rules: rules}

  @spec reply_with(State.t(), reply_content) :: {:reply, reply_content, State.t()}
  defp reply_with(state, reply), do: {:reply, reply, state}
end

defmodule IslandsEngine.Game do
  alias __MODULE__.Server

  @spec start_link(String.t()) :: GenServer.on_start()
  def start_link(name) when is_binary(name), do: GenServer.start_link(Server, name)

  @spec add_player(pid, String.t()) :: :ok
  def add_player(game, name) when is_binary(name), do: GenServer.call(game, {:add_player, name})
end
