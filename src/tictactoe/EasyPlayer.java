package tictactoe;

public class EasyPlayer extends Player{
    protected EasyPlayer(char token) {
        super(token);
    }

    @Override
    public Coordinates nextMove(TicTacToe game) {
        System.out.println("Making move level \"easy\"");
        return super.nextMove(game);
    }
}
