/*
 * Name: Charith Lanka
 * Class: CSS 142
 * Professor: Dr. Gunnerson
 * Description: This program implements a simple Tic Tac Toe game where two players
 * take turns making moves on a 3x3 board. The game continues until a player wins,
 * or the board is full, resulting in a draw.
 *
 * Features Used:
 *  - Using Multiple Classes (#7)
 *  - Looping with Repetition Control Structures (#2)
 *  - Branching with Selection Control Structures (#4)
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();

        while (!game.isGameEnded()) {
            System.out.println("Current board:");
            game.printBoard();
            System.out.println("Player " + game.getCurrentPlayerMark() + "'s turn. Enter row and column (0, 1, or 2):");
            int row = scanner.nextInt();
            int col = scanner.nextInt();
            game.play(row, col);
        }
        
        game.printScores();
        scanner.close();
    }
}
