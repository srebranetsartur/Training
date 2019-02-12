package start;

import helper.GameHelper;
import quizgame.Game;
import user.GameBoard;

public class GameStart {
    public static void main(String[] args) {
        GameBoard board = new GameBoard();
        Game game = Game.startGame();

        GameHelper helper = new GameHelper(game, board);
        helper.startGame();
    }
}
