package tictactoe;

public class Coordinates {

    private final int row;
    private final int col;

    public Coordinates(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public static Coordinates[] arrayOf(int[] rows, int[] cols) {
        if (rows.length != cols.length) {
            return null;
        }
        Coordinates[] coordinates = new Coordinates[rows.length];
        for (int i = 0; i < rows.length; i++) {
            coordinates[i] = new Coordinates(rows[i], cols[i]);
        }
        return coordinates;
    }
}
