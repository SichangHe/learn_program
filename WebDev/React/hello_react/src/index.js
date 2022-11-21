import React from "react";
import ReactDOM from "react-dom/client";
import "./index.css";
import calculateWinner from "./check.js";

const Square = (props) => (
    <button className="square" onClick={props.onClick}>
        {props.value}
    </button>
);

class Board extends React.Component {
    renderSquare(i) {
        return (
            <Square
                value={this.props.squares[i]}
                onClick={() => this.props.onClick(i)}
            />
        );
    }

    render() {
        return (
            <div>
                <div className="board-row">
                    {this.renderSquare(0)}
                    {this.renderSquare(1)}
                    {this.renderSquare(2)}
                </div>
                <div className="board-row">
                    {this.renderSquare(3)}
                    {this.renderSquare(4)}
                    {this.renderSquare(5)}
                </div>
                <div className="board-row">
                    {this.renderSquare(6)}
                    {this.renderSquare(7)}
                    {this.renderSquare(8)}
                </div>
            </div>
        );
    }
}

class Game extends React.Component {
    constructor(props) {
        super(props);
        const oneState = {
            squares: Array(9).fill(""),
            xIsNext: true,
            winner: "",
        };
        this.state = {
            history: [oneState],
            time: 0,
        };
    }

    boardClicked(i) {
        const state = { ...this.state };
        if (state.time !== state.history.length - 1) {
            return; // time traveling
        }
        const currentState = { ...state.history[state.time] };
        if (currentState.squares[i] || currentState.winner) {
            return;
        }
        currentState.squares = [...currentState.squares];
        currentState.squares[i] = currentState.xIsNext ? "X" : "O";
        currentState.winner = calculateWinner(currentState.squares);
        currentState.xIsNext = !currentState.xIsNext;
        state.history.push(currentState);
        state.time++;
        this.setState(state);
    }

    jumpTo(i) {
        this.setState({ ...this.state, time: i });
    }

    renderMoves() {
        return this.state.history.map((_, i) => (
            <li key={i}>
                <button onClick={() => this.jumpTo(i)}>
                    {i ? `move to #${i}` : "go to start"}
                </button>
            </li>
        ));
    }

    render() {
        const currentState = this.state.history[this.state.time];
        const status = currentState.winner
            ? `${currentState.winner} won!`
            : "Next player: " + (currentState.xIsNext ? "X" : "O");
        return (
            <div className="game">
                <div className="game-board">
                    <Board
                        squares={currentState.squares}
                        onClick={(i) => this.boardClicked(i)}
                    />
                </div>
                <div className="game-info">
                    <div>{status}</div>
                    <ol>{this.renderMoves()}</ol>
                </div>
            </div>
        );
    }
}

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(<Game />);
