package org.example;

/**
 * This class represents a player of the tic-tac-toe game.
 * It contains information about the player's name and mark,
 * opponent, and the board to play on.
 */
abstract class Player {

    protected String name;
    protected Board board;
    protected Player opponent;
    protected char mark;

    protected Player(String name, char mark) {
        this.name = name;
        this.mark = mark;
    }

    abstract protected void makeMove();

    /**
     * Play a turn and check if there is a winner.
     * After player makes their move, pass the turn to the other player
     */
    protected void play() {
        makeMove();
        board.display();
        board.checkWinner(mark);

        if (board.oWins() || board.xWins() || board.isFull()) {
            // display game over message
            String gameOverMessage = "THE GAME IS OVER: ";
            if (!(board.xWins() || board.oWins())) {
                gameOverMessage += "Tie!";
            } else if ((board.oWins() && mark == Constants.LETTER_O) || (board.xWins() && mark == Constants.LETTER_X)) {
                gameOverMessage += name + " is the winner!";
            } else {
                gameOverMessage += opponent.name + " is the winner!";
            }
            System.out.println(gameOverMessage);
            return;
        }
        // pass the turn to the other player
        opponent.play();
    }


    /**
     * Set the player's opponent
     * @param opponent the player's opponent
     */
    protected void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    /**
     * Set the board
     * @param theBoard the tic-tac-toe board
     */
    protected void setBoard(Board theBoard) {
        this.board = theBoard;
    }
}

