package org.example;

public class BlockingPlayer extends RandomPlayer{
    protected BlockingPlayer(String name, char mark) {
        super(name, mark);
    }

    @Override
    protected void makeMove() {
        // check if there is a move for blocking the other player
        // traverse the board and call tfb on each spot
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
