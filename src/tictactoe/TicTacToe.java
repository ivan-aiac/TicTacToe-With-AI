package tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TicTacToe {

    public static final char X = 'X';
    public static final char O = 'O';
    public static final char EMPTY_CELL = ' ';

    private final char[][] board;
    private final Player player1;
    private final Player player2;
    private Player currentPlayer;
    private Outcome result;

    public TicTacToe(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        board = new char[3][3];
        Arrays.fill(board[0], EMPTY_CELL);
        Arrays.fill(board[1], EMPTY_CELL);
        Arrays.fill(board[2], EMPTY_CELL);
        result = Outcome.NOT_FINISHED;
        currentPlayer = player1;
    }

    public void play() {
        Coordinates coordinates = currentPlayer.nextMove(this);
        board[coordinates.getRow()][coordinates.getCol()] = currentPlayer.getToken();
        currentPlayer = currentPlayer.equals(player1) ? player2 : player1;
        result = checkBoardWinner();
    }

    public boolean isGameOver() {
        return !result.equals(Outcome.NOT_FINISHED);
    }

    public String getResult() {
        return result.getResult();
    }

    public char[][] getBoard(){
        return board;
    }

    public int[] getSumOfBoardLines() {
        return sumOfBoardLines();
    }

    public boolean isCellOccupied(int row, int col) {
        return board[row][col] != EMPTY_CELL;
    }

    public void printBoard() {
        StringBuilder sb = new StringBuilder();
        sb.append("---------\n");
        for (char[] row: board) {
            sb.append("| ");
            for (char c: row) {
                sb.append(c).append(" ");
            }
            sb.append("|\n");
        }
        sb.append("---------\n");
        System.out.println(sb);
    }

    public Outcome checkBoardWinner() {
        //Sum of board lines to determine winner
        int[] sumOfLines = sumOfBoardLines();

        //Determine Winner 237 = 3 * 'O', 264 = 3 * 'X'
        for (int n: sumOfLines) {
            if (n == 237) {
                return Outcome.O_WINNER;
            } else if(n == 264) {
                return Outcome.X_WINNER;
            }
        }

        // If there isn't a winner and there are empty spaces game is not finished otherwise it a Draw
        if (getBoardEmptyCells().size() > 0) {
            return Outcome.NOT_FINISHED;
        } else {
            return Outcome.DRAW;
        }
    }

    public int[] sumOfBoardLines() {
        int[] sumOfLines = new int[8];
        Arrays.fill(sumOfLines, 0);
        int i = 0;
        for (char[] row: board) {
            //Horizontal BoardLine UP, CENTER, DOWN
            sumOfLines[i] = row[0] + row[1] + row[2];
            //Vertical BoardLine LEFT, CENTER, RIGHT
            sumOfLines[3] += row[0];
            sumOfLines[4] += row[1];
            sumOfLines[5] += row[2];
            //Diagonal BoardLine MAIN and SIDE
            sumOfLines[6] += row[i];
            sumOfLines[7] += row[2 - i];
            i++;
        }
        return sumOfLines;
    }

    public List<Coordinates> getBoardEmptyCells() {
        List<Coordinates> emptyCells = new ArrayList<>(9);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == EMPTY_CELL){
                    emptyCells.add(new Coordinates(i, j));
                }
            }
        }
        return emptyCells;
    }

}
