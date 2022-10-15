package org.example;

public class SmartPlayer extends BlockingPlayer{
    protected SmartPlayer(String name, char mark) {
        super(name, mark);
    }

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
