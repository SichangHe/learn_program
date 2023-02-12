defmodule IslandsEngine.Rules do
  defstruct state: :initialized,
            player1: :islands_not_set,
            player2: :islands_not_set

  alias IslandsEngine.Rules

  @type state :: :initialized | :players_set | :player1_turn | :player2_turn | :game_over
  @type player_state :: :islands_set | :islands_not_set
  @type action ::
          :add_player
          | {:position_islands | :set_islands | :guess_coordinate, :player1 | :player2}
          | {:win_check, :win | :no_win}
  @type t :: %Rules{state: state, player1: player_state, player2: player_state}

  @spec new() :: t
  def new(), do: %Rules{}

  @spec check(t, action) :: {:ok, t} | :error
  def check(%Rules{state: :initialized} = rules, :add_player),
    do: {:ok, %Rules{rules | state: :players_set}}

  def check(%Rules{state: :players_set} = rules, {:position_islands, player}) do
    case Map.fetch!(rules, player) do
      :islands_set -> :error
      :islands_not_set -> {:ok, rules}
    end
  end

  def check(%Rules{state: :players_set} = rules, {:set_islands, player}) do
    rules = Map.put(rules, player, :islands_set)

    {:ok,
     if both_players_islands_set?(rules) do
       %Rules{rules | state: :player1_turn}
     else
       rules
     end}
  end

  def check(%Rules{state: :player1_turn} = rules, {:guess_coordinate, :player1}),
    do: {:ok, %Rules{rules | state: :player2_turn}}

  def check(%Rules{state: :player2_turn} = rules, {:guess_coordinate, :player2}),
    do: {:ok, %Rules{rules | state: :player1_turn}}

  def check(%Rules{state: state} = rules, {:win_check, won?})
      when state in [:player1_turn, :player2_turn] do
    {:ok,
     case won? do
       :no_win -> rules
       :win -> %Rules{rules | state: :game_over}
     end}
  end

  def check(_, _), do: :error

  @spec both_players_islands_set?(t) :: boolean
  defp both_players_islands_set?(rules),
    do: rules.player1 == :islands_set && rules.player2 == :islands_set
end
