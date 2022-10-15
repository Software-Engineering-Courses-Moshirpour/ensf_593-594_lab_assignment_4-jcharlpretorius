package org.example;
/**
 * This class represents the game's referee.
 * It contains methods to set the players and the board to start the game.
 */
public class Referee {
    private Player xPlayer;
    private Player oPlayer;
    private Board board;

    /**
     * Sets each player's opponents and starts the game
     */
    public void runTheGame() {
        // set the opponents of the x and o players
        xPlayer.setOpponent(oPlayer);
        oPlayer.setOpponent(xPlayer);

        // Initiate the game: Display the board and player x makes the first move
        board.display();
        xPlayer.play();
    }

    /**
     * Set the board
     * @param board the tic-tac-toe board
     */
    public void setBoard(Board board) {
        this.board = board;
    }

    /**
     * Set the 'O' player
     * @param oPlayer the player whose mark is an 'O'
     */
    public void setoPlayer(Player oPlayer) {
        this.oPlayer = oPlayer;
    }

    /**
     * Set the 'X' player
     * @param xPlayer the player whose mark is an 'X'
     */
    public void setxPlayer(Player xPlayer) {
        this.xPlayer = xPlayer;
    }
}
