/*
 * Name: Charith Lanka
 * Class: CSS 142
 * Professor: Dr. Gunnerson
 * Description: The Board class represents the game board for Tic Tac Toe. It contains methods
 * for placing marks, checking for a winner, checking for a draw, and printing the board.
 *
 * Features Used:
 *  - Functional Decomposition (#1)
 *  - 1-D Arrays (#8)
 *  - Multi-Dimensional Arrays (#9)
 *  - Class Design using Constructors and Access Modifiers (#10)
 */

public class Board {
    private char[][] board;
    private static final int SIZE = 3;

    //initialize game board
    public Board() {
        board = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = '-';
            }
        }
    }

    //place mark at specific position
    public boolean placeMark(int row, int col, char playerMark) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && board[row][col] == '-') {
            board[row][col] = playerMark;
            return true;
        }
        return false;
    }

    //check for winner on baord
    public char getWinner() {
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] != '-' && board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
                return board[i][0];
            }
        }
    
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] != '-' && board[0][j] == board[1][j] && board[1][j] == board[2][j]) {
                return board[0][j];
            }
        }
    
        if (board[0][0] != '-' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return board[0][0];
        }
        if (board[0][2] != '-' && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return board[0][2];
        }
    
        return '-';
    }

    //check if the board is full
    public boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.printf("%c ", board[i][j]);
            }
            System.out.println();
        }
    }
}
