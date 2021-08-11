package tictactoe;

import java.util.Random;

public abstract class Player {

    private final char token;

    protected Player(char token) {
        this.token = token;
    }

    public char getToken() {
        return token;
    }

    public Coordinates nextMove(TicTacToe game) {
        Random random = new Random();
        while (true) {
            int row = random.nextInt(3);
            int col = random.nextInt(3);
            if (!game.isCellOccupied(row, col)){
                return new Coordinates(row, col);
            }
        }
    }
}
