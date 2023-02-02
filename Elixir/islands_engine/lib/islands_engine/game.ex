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
  @type players :: :player1 | :player2
end

defmodule IslandsEngine.Game.Server do
  use GenServer
  alias IslandsEngine.{Board, Coordinate, Rules, Island}
  alias IslandsEngine.Game.{Player, State}

  @type call ::
          {:add_player, String.t()}
          | {:position_island, State.players(), atom, pos_integer, pos_integer}
          | {:set_island, State.players()}
  @type add_player_reply :: :ok | :error
  @type position_island_reply ::
          :ok | :error | {:error, :invalid_coordinate | :invalid_island_type}
  @type set_islands_reply :: {:ok, Board.t()} | :error | {:error, :not_all_islands_positioned}
  @type reply_content :: add_player_reply | position_island_reply | set_islands_reply

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

  def handle_call({:position_island, player, key, row, col}, _from, state) do
    with {:ok, rules} <- Rules.check(state.rules, {:position_islands, player}),
         {:ok, coord} <- Coordinate.new(row, col),
         {:ok, island} <- Island.new(key, coord),
         %{} = board <- Board.position_island(player_board(state, player), key, island) do
      state |> update_board(player, board) |> update_rules(rules) |> reply_with(:ok)
    else
      error
      when error in [:error, {:error, :invalid_coordinate}, {:error, :invalid_island_type}] ->
        reply_with(state, error)
    end
  end

  def handle_call({:set_islands, player}, _from, state) do
    board = player_board(state, player)

    with {:ok, rules} <- Rules.check(state.rules, {:set_islands, player}),
         true <- Board.all_islands_positioned?(board) do
      state |> update_rules(rules) |> reply_with({:ok, board})
    else
      :error -> reply_with(state, :error)
      false -> reply_with(state, {:error, :not_all_islands_positioned})
    end
  end

  @spec update_player2_name(State.t(), String.t()) :: State.t()
  defp update_player2_name(state, name), do: put_in(state.player2.name, name)

  @spec update_rules(State.t(), Rules.t()) :: State.t()
  defp update_rules(state, rules), do: %State{state | rules: rules}

  @spec reply_with(State.t(), reply_content) :: {:reply, reply_content, State.t()}
  defp reply_with(state, reply), do: {:reply, reply, state}

  @spec player_board(State.t(), :player1 | :player2) :: Board.t()
  defp player_board(state, player), do: Map.get(state, player).board

  @spec update_board(State.t(), :player1 | :player2, Board.t()) :: State.t()
  defp update_board(state, player, board), do: Map.update!(state, player, &%{&1 | board: board})
end

defmodule IslandsEngine.Game do
  alias __MODULE__.{Server, State}

  @players [:player1, :player2]

  @spec start_link(String.t()) :: GenServer.on_start()
  def start_link(name) when is_binary(name), do: GenServer.start_link(Server, name)

  @spec add_player(pid, String.t()) :: Server.add_player_reply()
  def add_player(game, name) when is_binary(name), do: GenServer.call(game, {:add_player, name})

  @spec position_island(pid, State.players(), atom, pos_integer, pos_integer) ::
          Server.position_island_reply()
  def position_island(game, player, key, row, col) when player in @players,
    do: GenServer.call(game, {:position_island, player, key, row, col})

  @spec set_islands(pid, State.players()) :: Server.set_islands_reply()
  def set_islands(game, player) when player in @players,
    do: GenServer.call(game, {:set_islands, player})
end
