package quizgame;

import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private int quizNumber;
    private Range range;
    private Range primaryRange; //Uses only for statistic info
    private int numberOfAttempts = 1;

    public class Range {
        private static final int RAND_MAX = 100;
        private static final int LOWER_RANGE_BOUND = 0;

        private int lowerBound;
        private int upperBound;

        private Range(int lowerBound, int upperBound) {
            this.lowerBound = lowerBound;
            this.upperBound = upperBound;
        }

        public int getLowerBound() {
            return lowerBound;
        }

        public int getUpperBound() {
            return upperBound;
        }
    }

    private static class NumberGenerator {
        /*
        Parameter range.upperBound added 1 needed to include upperBound to generation algorithm
         */
        private static int generateNumber(Range range) {
            return ThreadLocalRandom.current().nextInt(range.lowerBound, range.upperBound + 1);
        }
    }

    public static Game startGame() {
        return new Game(Range.LOWER_RANGE_BOUND, Range.RAND_MAX);
    }

    public static Game startGame(int firstBound, int secondBound) {
        return new Game(firstBound, secondBound);
    }

    private Game(int firstBound, int secondBound) {
        range = initRange(firstBound, secondBound);
        saveDefaultRange();
        quizNumber = NumberGenerator.generateNumber(range);
    }

    private Range initRange(int firstBound, int secondBound) {
        return (firstBound > secondBound) ? new Range(secondBound, firstBound)
                : new Range(firstBound, secondBound);
    }

    private void saveDefaultRange() {
        primaryRange = new Range(range.lowerBound, range.upperBound);
    }

    public void resizeRange(int newLowerBound, int newUpperBound) {
        if(validateNewRangeValue(newLowerBound, newUpperBound)) {
            range.lowerBound = newLowerBound;
            range.upperBound = newUpperBound;
        } else
            throw new WrongRangeException();
    }

    private boolean validateNewRangeValue(int newLowerBound, int newUpperBound) {
        return range.lowerBound <= newLowerBound && range.upperBound >= newUpperBound;
    }

    public boolean isQuizInRange(int quiz) {
        return quiz >= range.lowerBound && quiz <= range.upperBound;
    }

    public boolean isNumberEqualsToQuiz(int number) {
        return number == quizNumber;
    }

    public int getQuizNumber() {
        return quizNumber;
    }

    public Range getRange() {
        return range;
    }

    public int getNumberOfAttempts() {
        return numberOfAttempts;
    }

    public Range getPrimaryRange() {
        return primaryRange;
    }

    public void increaseNumberOfAttempts() {
        numberOfAttempts++;
    }
}
