package tictactoe;

public enum Outcome {
    DRAW("Draw"),
    X_WINNER("X wins"),
    O_WINNER("O wins"),
    NOT_FINISHED("Game not finished");

    private final String result;

    Outcome(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
