package tictactoe;

import java.util.Scanner;

import static tictactoe.TicTacToe.*;

public class Main {

    private static final String TYPE_REGEX = "(EASY|MEDIUM|HARD|USER)";
    private static final String EXIT = "EXIT";
    private static final String START = "START";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] command;
        while (true) {
            System.out.println("Input command:");
            command = scanner.nextLine().toUpperCase().split("\\s+");
            if (EXIT.equals(command[0])) {
                break;
            }
            if (command.length != 3 || !START.equals(command[0]) || !command[1].matches(TYPE_REGEX) || !command[2].matches(TYPE_REGEX)) {
                System.out.println("Bad parameters!");
            } else {
                // Start the game
                TicTacToe ticTacToe = new TicTacToe(
                        PlayerFactory.createPlayer(command[1], X, scanner),
                        PlayerFactory.createPlayer(command[2], O, scanner)
                );

                ticTacToe.printBoard();

                while (!ticTacToe.isGameOver()) {
                    ticTacToe.play();
                    ticTacToe.printBoard();
                }

                System.out.println(ticTacToe.getResult());
            }
        }
        scanner.close();
    }
}