package tictactoe;

import static tictactoe.Outcome.*;
import static tictactoe.TicTacToe.*;

public class HardPlayer extends Player{

    private final boolean isMaximizing;

    protected HardPlayer(char token) {
        super(token);
        isMaximizing = token == X;
    }

    @Override
    public Coordinates nextMove(TicTacToe game) {
        System.out.println("Making move level \"hard\"");
        return findBestMove(game);
    }

    private Coordinates findBestMove(TicTacToe game) {
        Coordinates bestMove = null;
        char[][] board = game.getBoard();
        int bestScore = isMaximizing ? -1000 : 1000;
        for (Coordinates c: game.getBoardEmptyCells()) {
            board[c.getRow()][c.getCol()] = getToken();
            int score = minimax(board, !isMaximizing, game);
            board[c.getRow()][c.getCol()] = EMPTY_CELL;
            if (isMaximizing) {
                if (score > bestScore) {
                    bestScore = score;
                    bestMove = c;
                }
            } else {
                if (score < bestScore) {
                    bestScore = score;
                    bestMove = c;
                }
            }
        }
        return bestMove;
    }

    private int minimax(char[][] board, boolean isMaximizing, TicTacToe game) {
        Outcome result = game.checkBoardWinner();
        if (!result.equals(NOT_FINISHED)) {
            if (result.equals(X_WINNER)) {
                return 10;
            } else if (result.equals(O_WINNER)) {
                return -10;
            } else {
                return 0;
            }
        }
        int bestScore = isMaximizing ? -1000 : 1000;
        for (Coordinates c: game.getBoardEmptyCells()) {
            board[c.getRow()][c.getCol()] = isMaximizing ? X : O;
            int score = minimax(board, !isMaximizing, game);
            board[c.getRow()][c.getCol()] = EMPTY_CELL;
            bestScore = isMaximizing ? Math.max(score, bestScore) : Math.min(score, bestScore);
        }
        return bestScore;
    }

}
