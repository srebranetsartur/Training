package helper;

import quizgame.Game;
import quizgame.WrongRangeException;
import user.GameBoard;

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

        try {
            while (!isGameEnd) {
                int number = enterNumber(sc);

                if (isNumberEqualsToQuizNumber(number)) {
                    congratMessage();
                } else if (isNumberInRange(number)) {
                    numberInRangeMessage(number);
                } else {
                    board.printMessage(GameBoard.Message.NOT_IN_RANGE);
                }
            }
        } catch (WrongRangeException e) {
            board.printMessage(GameBoard.Message.BOUND_ERROR);
            System.out.println(game.getRange());
        }
    }

    private void initGameRange(Scanner sc) {
        int rangeInputs[] = new int[2];

        while(true) {
            try {
                for (int i = 0; i < 2; i++) {
                    board.printMessage(GameBoard.Message.INPUT_RANGE);

                    while (!sc.hasNextInt()) {
                        sc.next();
                        board.printMessage(GameBoard.Message.NOT_A_NUMBER);
                    }

                    rangeInputs[i] = sc.nextInt();
                }

                game = Game.startGame(rangeInputs[0], rangeInputs[1]);
                break;
            } catch (WrongRangeException e) {
                board.printMessage(GameBoard.Message.BOUND_ERROR);
                System.out.println(game.getRange());
            }
        }
    }

    private void congratMessage() {
        board.printMessage(GameBoard.Message.CONGRATULATION);
        isGameEnd = true;
        printStatistic();
    }

    private void printStatistic() {
        System.out.println("Quiz number was: " + game.getQuizNumber());
        System.out.println("Default range was: " + game.getPrimaryRange());
        System.out.println("Attempts: " + game.getNumberOfAttempts());
    }

    private void numberInRangeMessage(int number) {
        board.printMessage(GameBoard.Message.ALREADY_IN);
        game.increaseNumberOfAttempts();
        createSuggestiveRange(number);
        System.out.println("Find in this range: " + game.getRange());
    }




    private int enterNumber(Scanner scanner) {
        System.out.println(GameBoard.Message.ENTER_QUIZ);

        while(!scanner.hasNextInt()) {
            board.printMessage(GameBoard.Message.NOT_A_NUMBER);
        }
        return scanner.nextInt();
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
            changeRange(game.getLowerBound(), number);
        }
    }

    private void changeRange(int newLowerBound, int newUpperBound) {
        game.resizeRange(newLowerBound, newUpperBound);
    }


}
