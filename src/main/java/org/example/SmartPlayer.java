package org.example;

/**
 * This class represents a computer controlled smart player of the tic-tac-toe game.
 * This player tries to make moves to win the game if possible and to
 * block their opponent from winning.
 * It contains information about the player's name and mark,
 * opponent, and the board to play on.
 */
public class SmartPlayer extends BlockingPlayer{
    protected SmartPlayer(String name, char mark) {
        super(name, mark);
    }

    /**
     * Make a move on the board.
     * Tries to win the game immediately if possible, otherwise it tries to block
     * their opponent.
     */
    @Override
    protected void makeMove() {
        // check if there is a winning move
        int row, col;
        for (row = 0; row < 3; row++) {
            for (col = 0; col < 3; col++) {
                if (testForWinning(row, col)) {
                    board.addMark(row, col, mark);
                    return;
                }
            }
        }

        // check if there is a blocking move, make a random move if not
        super.makeMove();
    }

    /**
     * Checks if the specified spot on the board is a winning position for the player
     * @param row the row position to be checked
     * @param col the column position to be checked
     * @return true if it is a winning move, false otherwise
     */
    protected boolean testForWinning (int row, int col) {
        // check if spot is empty
        if (board.getMark(row, col) != Constants.SPACE_CHAR) {
            return false;
        } else {
            // temporarily add player's mark to board and check if they would win
            board.addMark(row, col, mark);
            boolean isWinSpot = false;
            if (board.checkWinner(mark) == 1) {
                isWinSpot = true;
            }
            // remove temporary mark from board
            board.addMark(row, col, Constants.SPACE_CHAR);
            return isWinSpot;
        }
    }
}
