package tictactoe;

import static tictactoe.TicTacToe.*;

public class MediumPlayer extends Player{
    protected MediumPlayer(char token) {
        super(token);
    }

    @Override
    public Coordinates nextMove(TicTacToe game) {
        System.out.println("Making move level \"medium\"");
        char[] tokens = {getToken(), X == getToken() ? O : X};
        int[] sumOfLines = game.getSumOfBoardLines();
        // Check board with current player's token first to see if it can win otherwise check opponent's token to counter
        for (char token: tokens) {
            for (int i = 0; i < sumOfLines.length; i++) {
                // check if the line contains 2 of the same tokens + empty space
                if (sumOfLines[i] - EMPTY_CELL == token * 2) {
                    // Check the 3 coordinates of the line and make the move where its empty
                    for (Coordinates coordinates: BoardLine.values()[i].getLineCoordinates()) {
                        if (!game.isCellOccupied(coordinates.getRow(), coordinates.getCol())) {
                            return coordinates;
                        }
                    }
                }
            }
        }
        // Random move if cant win and cant counter the other player
        return super.nextMove(game);
    }
}
