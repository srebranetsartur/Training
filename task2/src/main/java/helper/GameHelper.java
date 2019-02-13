package helper;

import quizgame.Game;
import quizgame.WrongRangeException;
import user.GameBoard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameHelper {
    private Game game;
    private GameBoard board;
    private boolean isGameEnd;

    public GameHelper(Game game, GameBoard board) {
        this.game = game;
        this.board = board;
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        initGameRange(sc);

        board.printMessage(GameBoard.Message.START_GAME);
        board.printMessage("Started range: " + rangeToString(game.getRange()));

        try {
            while (!isGameEnd) {
                System.out.println(GameBoard.Message.ENTER_QUIZ);
                int number = enterNumber(sc);

                if (isNumberEqualsToQuizNumber(number)) {
                    isGameEnd = true;
                    printStatistic();
                } else if (isNumberInRange(number)) {
                    numberInRangeMessage(number);
                } else {
                    board.printMessage(GameBoard.Message.NOT_IN_RANGE);
                }
            }
        } catch (WrongRangeException e) {
            board.printMessage(GameBoard.Message.BOUND_ERROR);
            board.printMessage(rangeToString(game.getRange()));
        }
    }

    private void initGameRange(Scanner sc) {
        int rangeInputs[] = new int[2];

        while(true) {
            try {
                    board.printMessage(GameBoard.Message.INPUT_RANGE);

                    rangeInputs[0] = enterNumber(sc);
                    board.printMessage(GameBoard.Message.OK_NEXT);
                    rangeInputs[1] = enterNumber(sc);

                game = Game.startGame(rangeInputs[0], rangeInputs[1]);
                break;
            } catch (InputMismatchException e) {
                board.printMessage(GameBoard.Message.NOT_A_NUMBER);
            } catch (WrongRangeException e) {
                board.printMessage(GameBoard.Message.BOUND_ERROR);
                rangeToString(game.getRange());
            }
        }
    }

    private int enterNumber(Scanner scanner) {
        while(!scanner.hasNextInt()) {
            board.printMessage("Error value: " + scanner.next());
            board.printMessage(GameBoard.Message.NOT_A_NUMBER);
        }
        return scanner.nextInt();
    }

    private void printStatistic() {
        board.printMessage(GameBoard.Message.CONGRATULATION);
        board.printMessage("Quiz number was: " + game.getQuizNumber());
        board.printMessage("Default range was: " + rangeToString(game.getPrimaryRange()));
        board.printMessage("Attempts: " + game.getNumberOfAttempts());
    }

    private void numberInRangeMessage(int number) {
        board.printMessage(GameBoard.Message.ALREADY_IN);
        game.increaseNumberOfAttempts();
        createSuggestiveRange(number);
        board.printMessage("Find in this range: " + rangeToString(game.getRange()));
    }

    private boolean isNumberInRange(int number) {
        return game.isQuizInRange(number);
    }

    private boolean isNumberEqualsToQuizNumber(int number) {
        return game.isNumberEqualsToQuiz(number);
    }

    private void createSuggestiveRange(int number) {
        if(number < game.getQuizNumber()) {
            changeRange(number, game.getRange().getUpperBound());
        } else {
            changeRange(game.getRange().getLowerBound(), number);
        }
    }

    private void changeRange(int newLowerBound, int newUpperBound) {
        game.resizeRange(newLowerBound, newUpperBound);
    }

    private String rangeToString(Game.Range range) {
        return GameBoard.PREFIX + range.getLowerBound() +
                GameBoard.OVERLAPS +
                range.getUpperBound() +
                GameBoard.SUFFIX;
    }
}
