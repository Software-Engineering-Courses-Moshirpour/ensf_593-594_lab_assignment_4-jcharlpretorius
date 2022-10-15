package org.example;

/**
 * This class represents a computer controlled random player of the tic-tac-toe game.
 * This player makes moves at random.
 * It contains information about the player's name and mark,
 * opponent, and the board to play on.
 */
public class RandomPlayer extends Player{

    protected RandomGenerator randomGenerator;
    protected RandomPlayer(String name, char mark) {
        super(name, mark);
        randomGenerator = new RandomGenerator();
    }

    /**
     * Make a random move on the board.
     */
    @Override
    protected void makeMove() {

        boolean isEmptyPos = false;
        while(!isEmptyPos) {
            // get random x and y positions
            int row = randomGenerator.discrete(0, 2);
            int col = randomGenerator.discrete(0, 2);

            // check if location hasn't been played before
            if (board.getMark(row, col) == Constants.SPACE_CHAR) {
                // place mark on board and exit the loop
                board.addMark(row, col, mark);
                isEmptyPos = true;
            }
        }
    }
}
