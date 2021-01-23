import React from "react";
import ReactDOM from "react-dom";
import "./index.css";

function Square(props) {
  let squareClassName = "square";
  if (props.winnerSquare) {
    squareClassName += " winnerSquare"
  }
  return (
    <button
      className={squareClassName}
      onClick={props.onClick}
    >
      {props.value}
    </button >
  );
}

class Board extends React.Component {

  isWinnerSquare(position) {
    const coordinates = this.props.coordinates;
    if (!coordinates) {
      return false;
    }
    for (let i = 0; i < coordinates.length; i++) {
      if (coordinates[i] === position) {
        return true;
      }
    }
    return false
  }

  createBoard = () => {
    let table = [];
    let position = 0;
    for (let i = 0; i < 3; i++) {
      let columns = []
      for (let j = 0; j < 3; j++) {
        columns.push(this.renderSquare(position, this.isWinnerSquare(position)));
        position++;
      }
      table.push(<div className="board-row">{columns}</div>);
    }
    return table;
  }

  renderSquare(i, winnerSquare) {
    return (
      <Square
        value={this.props.squares[i]}
        onClick={() => this.props.onClick(i)}
        winnerSquare={winnerSquare}
      />
    );
  }

  render() {
    return (
      <div>
        {this.createBoard()}
      </div>
    );
  }

}

class Game extends React.Component {
  constructor(props) {
    super(props)
    this.state = {
      history: [{
        squares: Array(9).fill(null),
        col: -1,
        row: -1,
      }],
      up: true,
      stepNumber: 0,
      xIsNext: true,
    };
  }

  handleToggle() {
    this.setState({
      up: !this.state.up,
    });
  }

  handleClick(i) {
    const history = this.state.history.slice(0, this.state.stepNumber + 1);
    const current = history[history.length - 1];
    const squares = current.squares.slice();
    const col = (i % 3) + 1;
    const row = Math.floor(i / 3) + 1;
    if (calculateWinner(squares) || squares[i]) {
      return;
    }
    squares[i] = this.state.xIsNext ? 'X' : 'O';
    this.setState({
      history: history.concat([{
        squares: squares,
        col: col,
        row: row,
      }]),
      stepNumber: history.length,
      xIsNext: !this.state.xIsNext,
    });
  }

  jumpTo(step) {
    this.setState({
      stepNumber: step,
      xIsNext: (step % 2) === 0,
    });
  }
  render() {
    const history = this.state.history;
    const current = history[this.state.stepNumber];
    const winner = calculateWinner(current.squares);
    let moving;
    moving = this.state.up ? history.slice() : history.slice().reverse();
    const moves = moving.map((step, move) => {
      if (!this.state.up) {
        move = moving.length - move;
        move--;
      }
      const desc = move ?
        'Go to move #' + move + " at (" + step.col + "," + step.row + ")" :
        'Go to game start';
      return (
        <li key={move}>
          <button onClick={() => this.jumpTo(move)}>{desc}</button>
        </li>
      );
    });

    let status;
    if (winner) {
      status = 'Winner: ' + winner.name;
    } else if (history.length === 10) {
      status = "Draw";
    } else {
      status = 'Next player: ' + (this.state.xIsNext ? 'X' : 'O');
    }

    return (
      <div className="game">
        <div className="game-board">
          <Board
            squares={current.squares}
            onClick={(i) => this.handleClick(i)}
            coordinates={winner ? winner.coordinates : null}
          />
        </div>
        <div className="game-info">
          <div>{status}</div>
          <label class="switch">
            <input type="checkbox" onChange={() => this.handleToggle()} />
            <span class="slider round"></span>
          </label>
          <ul>{moves}</ul>
        </div>
      </div>
    );
  }
}

function calculateWinner(squares) {
  const lines = [
    [0, 1, 2],
    [3, 4, 5],
    [6, 7, 8],
    [0, 3, 6],
    [1, 4, 7],
    [2, 5, 8],
    [0, 4, 8],
    [2, 4, 6],
  ];

  let winner = {
    name: "",
    coordinates: null
  };
  for (let i = 0; i < lines.length; i++) {
    const [a, b, c] = lines[i];
    if (squares[a] && squares[a] === squares[b] && squares[a] === squares[c]) {
      winner.coordinates = lines[i];
      winner.name = squares[a]
      return winner;
    }
  }
  return null;
}
// ========================================

ReactDOM.render(<Game />, document.getElementById("root"));
