package org.example;

/**
 * This class represents the tic-tac-toe board.
 * It contains the logic for playing the game and methods for
 * modifying and displaying the state of the board.
 */
public class Board implements Constants {
    private char theBoard[][];
    private int markCount;

    /**
     * Constructs the board.
     */
    public Board() {
        markCount = 0;
        // initialize size of 2D char array representing the board
        theBoard = new char[3][];
        // fill arrays with space characters
        for (int i = 0; i < 3; i++) {
            theBoard[i] = new char[3];
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        }
    }

    /**
     * Gets the mark at the specified location on the board
     * @param row the row of the location
     * @param col the column the location
     * @return the mark at the location
     */
    public char getMark(int row, int col) {
        return theBoard[row][col];
    }

    /**
     * Checks if  the board is full
     * @return true if the board is full, false otherwise
     */
    public boolean isFull() {
        return markCount == 9;
    }

    /**
     * Checks if player X wins
     * @return true if player X has won
     */
    public boolean xWins() {
        if (checkWinner(LETTER_X) == 1)
            return true;
        else
            return false;
    }

    /**
     * Checks if player O wins
     * @return true if player O has won
     */
    public boolean oWins() {
        if (checkWinner(LETTER_O) == 1)
            return true;
        else
            return false;
    }

    /**
     * Displays the board to the console
     */
    public void display() {
        displayColumnHeaders();
        addHyphens();
        for (int row = 0; row < 3; row++) {
            addSpaces();
            // print the row labels for the board
            System.out.print("    row " + row + ' ');
            for (int col = 0; col < 3; col++)
                System.out.print("|  " + getMark(row, col) + "  ");
            System.out.println("|");
            addSpaces();
            addHyphens();
        }
    }

    /** Place a mark on the board at the specified location
     * @param row the vertical position on the board
     * @param col the horizontal position on the board
     * @param mark the mark to be placed
     */
    public void addMark(int row, int col, char mark) {
        // place the mark
        theBoard[row][col] = mark;
        // increment the mark count
        markCount++;
    }

    /**
     * Clear the board of any player marks
     */
    public void clear() {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                theBoard[i][j] = SPACE_CHAR;
        markCount = 0;
    }


    /**
     * Checks if there is a winner.
     * The win condition is if there are 3 marks in a single row, column, or diagonal
     * @param mark the player's mark to check
     * @return 1 if win condition is met, 0 if not
     */
    int checkWinner(char mark) {
        int row, col;
        int result = 0;

        // check the rows
        for (row = 0; result == 0 && row < 3; row++) {
            int row_result = 1;
            for (col = 0; row_result == 1 && col < 3; col++)
                if (theBoard[row][col] != mark)
                    row_result = 0;
            if (row_result != 0)
                result = 1;
        }

        // check the columns
        for (col = 0; result == 0 && col < 3; col++) {
            int col_result = 1;
            for (row = 0; col_result != 0 && row < 3; row++)
                if (theBoard[row][col] != mark)
                    col_result = 0;
            if (col_result != 0)
                result = 1;
        }

        // check the first diagonal
        if (result == 0) {
            int diag1Result = 1;
            for (row = 0; diag1Result != 0 && row < 3; row++)
                if (theBoard[row][row] != mark)
                    diag1Result = 0;
            if (diag1Result != 0)
                result = 1;
        }
        // check the other diagonal
        if (result == 0) {
            int diag2Result = 1;
            for (row = 0; diag2Result != 0 && row < 3; row++)
                if (theBoard[row][3 - 1 - row] != mark)
                    diag2Result = 0;
            if (diag2Result != 0)
                result = 1;
        }
        return result;
    }

    /**
     * Build the column headers of the board.
     */
    void displayColumnHeaders() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|col " + j);
        System.out.println();
    }

    /**
     * Build the horizontal lines of the board.
     */
    void addHyphens() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("+-----");
        System.out.println("+");
    }

    /**
     * Build the vertical lines of the board.
     */
    void addSpaces() {
        System.out.print("          ");
        for (int j = 0; j < 3; j++)
            System.out.print("|     ");
        System.out.println("|");
    }
}
