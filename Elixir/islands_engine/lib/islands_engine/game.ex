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

  @type t :: %State{player1: String.t(), player2: String.t(), rules: Rules.t()}
end

defmodule IslandsEngine.Game do
  use GenServer
  alias IslandsEngine.Game.{Player, State}

  # Server
  def init(name) do
    {:ok, %State{player1: %Player{name: name}}}
  end

  # Client
  @spec start_link(String.t()) :: GenServer.on_start()
  def start_link(name) when is_binary(name), do: GenServer.start_link(__MODULE__, name)
end
