package tictactoe;

import java.util.Scanner;

public class HumanPlayer extends Player{

    private final Scanner scanner;

    public HumanPlayer(char token, Scanner scanner) {
        super(token);
        this.scanner = scanner;
    }

    @Override
    public Coordinates nextMove(TicTacToe game) {
        String input;
        String[] coordinates;
        while (true) {
            System.out.println("Enter the coordinates:");
            input = scanner.nextLine();
            if (input.matches("[0-9]\\s+[0-9]")) {
                coordinates = input.split("\\s+");
                int row = Integer.parseInt(coordinates[0]);
                int col = Integer.parseInt(coordinates[1]);

                if (row < 1 || row > 3 || col < 1 || col > 3) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (game.isCellOccupied(row - 1, col - 1)) {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    return new Coordinates(row - 1, col - 1);
                }

            } else {
                System.out.println("You should enter numbers!");
            }
        }
    }
}
