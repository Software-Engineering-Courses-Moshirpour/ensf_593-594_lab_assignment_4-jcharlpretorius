package org.example;

/**
 * This class represents a computer controlled blocking player of the tic-tac-toe game.
 * This player tries to make moves to block their opponent from winning.
 * It contains information about the player's name and mark,
 * opponent, and the board to play on.
 */
public class BlockingPlayer extends RandomPlayer{
    protected BlockingPlayer(String name, char mark) {
        super(name, mark);
    }

    /**
     * Make a move on the board.
     * Tries to block the opponent from winning and makes a random
     * move if it cannot.
     */
    @Override
    protected void makeMove() {
        // check if there is a move for blocking the other player
        int row, col;
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                if (testForBlocking(row, col)) {
                    board.addMark(row, col, mark);
                    return;
                }
            }
        }
        // call the parent method to choose a random position
        super.makeMove();
    }

    /**
     * Checks if the specified spot on the board would block the opponent from winning
     * @param row the row position to be checked
     * @param col the column position to be checked
     * @return true if it is a blocking spot, false otherwise
     */
    protected boolean testForBlocking(int row, int col) {
        // check if spot is empty
        if (board.getMark(row, col) != Constants.SPACE_CHAR) {
            return false;
        } else {
            // temporarily add opponent's mark to board and check if they would have won
            board.addMark(row, col, opponent.mark);
            boolean isBlockSpot = false;
            if (board.checkWinner(opponent.mark) == 1) {
                isBlockSpot = true;
            }
            // remove temporary mark from board
            board.addMark(row, col, Constants.SPACE_CHAR);
            return isBlockSpot;
        }
    }
}
