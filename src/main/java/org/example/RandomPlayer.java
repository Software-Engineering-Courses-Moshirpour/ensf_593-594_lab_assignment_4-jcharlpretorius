package org.example;

public class RandomPlayer extends Player{

    protected RandomGenerator randomGenerator;
    protected RandomPlayer(String name, char mark) {
        super(name, mark);
        randomGenerator = new RandomGenerator();
    }

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
