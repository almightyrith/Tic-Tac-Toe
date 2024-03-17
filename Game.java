/*
 * Name: Charith Lanka
 * Class: CSS 142
 * Professor: Dr. Gunnerson
 * Description: The Game class represents the logic and flow of the Tic Tac Toe game.
 * It contains methods for player turns, checking game conditions, updating scores, and logging moves.
 *
 * Features Used:
 *  - Functional Decomposition (#1)
 *  - Looping with Repetition Control Structures (#2)
 *  - Branching with Selection Control Structures (#4)
 *  - File IO (#5)
 *  - Using Multiple Classes (#7)
 *  - 1-D Arrays (#8)
 *  - Class Design using Constructors and Access Modifiers (#10)
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Game {
    private Board board;
    private char currentPlayerMark;
    private boolean gameEnded;
    private int[] playerScores = new int[2];

    /**
     * Constructor for the Game class.
     * Initializes a new game with a fresh board, starting player 'X', and the game state set to ongoing.
     */
    public Game() {
        board = new Board();
        currentPlayerMark = 'X';
        gameEnded = false;
    }

    /**
     * Allows a player to make a move on the game board. Validates the move,
     * updates the board, checks for a winner or draw, and switches players.
     *
     * @param row The row index of the move.
     * @param col The column index of the move.
     */
    public void play(int row, int col) {
        if (!gameEnded && board.placeMark(row, col, currentPlayerMark)) {
            logMove(row, col); // log thee move
    
            if (board.getWinner() == currentPlayerMark) {
                System.out.println("Player " + currentPlayerMark + " wins!");
                updateScore(currentPlayerMark); // Update the score for the winning player
                gameEnded = true;
            } else if (board.isBoardFull()) {
                System.out.println("It's a draw!");
                gameEnded = true;
            } else {
                currentPlayerMark = (currentPlayerMark == 'X') ? 'O' : 'X';
            }
        } else {
            System.out.println("Invalid move, try again.");
        }
    }
    
/**
     * Prints the current state of the game board.
     */
    public void printBoard() {
        board.printBoard();
    }
//check if game ended
    public boolean isGameEnded() {
        return gameEnded;
    }
//get current player X or O
    public char getCurrentPlayerMark() {
        return currentPlayerMark;
    }

    public void logMove(int row, int col) {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("gameLog.txt", true))) {
        writer.write("Player " + currentPlayerMark + " moved to (" + row + ", " + col + ")\n");
    } catch (IOException e) {
        System.out.println("An error occurred while logging the move.");
        e.printStackTrace();
    }
}
//update score for winner
    public void updateScore(char playerMark) {
        int playerIndex = (playerMark == 'X') ? 0 : 1;
        playerScores[playerIndex]++;
    }

    public void printScores() {
        System.out.println("Scores: Player X: " + playerScores[0] + ", Player O: " + playerScores[1]);
    }

    
    
}
