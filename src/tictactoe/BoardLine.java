package tictactoe;

public enum BoardLine {
    HORIZONTAL_UP(Coordinates.arrayOf(new int[]{0, 0, 0}, new int[]{0, 1, 2})),
    HORIZONTAL_CENTER(Coordinates.arrayOf(new int[]{1, 1, 1}, new int[]{0, 1, 2})),
    HORIZONTAL_DOWN(Coordinates.arrayOf(new int[]{2, 2, 2}, new int[]{0, 1, 2})),
    VERTICAL_LEFT(Coordinates.arrayOf(new int[]{0, 1, 2}, new int[]{0, 0, 0})),
    VERTICAL_CENTER(Coordinates.arrayOf(new int[]{0, 1, 2}, new int[]{1, 1, 1})),
    VERTICAL_RIGHT(Coordinates.arrayOf(new int[]{0, 1, 2}, new int[]{2, 2, 2})),
    DIAGONAL_MAIN(Coordinates.arrayOf(new int[]{0, 1, 2}, new int[]{0, 1, 2})),
    DIAGONAL_SIDE(Coordinates.arrayOf(new int[]{0, 1, 2}, new int[]{2, 1, 0}));

    final Coordinates[] lineCoordinates;

    BoardLine(Coordinates[] lineCoordinates) {
        this.lineCoordinates = lineCoordinates;
    }

    public Coordinates[] getLineCoordinates() {
        return lineCoordinates;
    }
}
