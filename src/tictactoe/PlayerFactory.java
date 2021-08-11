package tictactoe;

import java.util.Scanner;

public class PlayerFactory {

    public static Player createPlayer(String type, char token, Scanner scanner) {
        switch (type) {
            case "USER":
                return new HumanPlayer(token, scanner);
            case "EASY":
                return new EasyPlayer(token);
            case "MEDIUM":
                return new MediumPlayer(token);
            case "HARD":
                return new HardPlayer(token);
            default:
                return null;
        }
    }

}
