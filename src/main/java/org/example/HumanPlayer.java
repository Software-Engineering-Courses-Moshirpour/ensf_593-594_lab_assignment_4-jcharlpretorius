package org.example;

import java.util.Scanner;

public class HumanPlayer extends Player{


    protected HumanPlayer(String name, char mark) {
        super(name, mark);
    }


    /**
     * Make a move on the board.
     * Gets the location on the board that the player wants to place their mark
     * and checks if it is a valid move before placing their mark
     */
    @Override
    protected void makeMove() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            // get row placement
            System.out.print(name + ", what row should your next " + mark + " be placed in? ");
            int row = Integer.parseInt(scanner.nextLine());
            // get column placement
            System.out.print(name + ", what column should your next " + mark + " be placed in? ");
            int col = Integer.parseInt(scanner.nextLine());

            // check if user input is in allowable range
            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Invalid board position. Row and column values must be 0, 1, or 2");
                continue;
            }
            // check if location hasn't been played before
            if (board.getMark(row, col) != Constants.SPACE_CHAR) {
                char markAtPos = board.getMark(row, col);
                System.out.println("\nThere is already a '" + markAtPos + "' at that location." +
                        " Please choose a different location to play.");
                continue;
            }
            // place mark on board and exit the loop
            board.addMark(row, col, mark);
            break;
        }
    }
}
