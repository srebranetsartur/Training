package quizgame;

import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    private int quizNumber;
    private Range range;
    private Range primaryRange; //Uses only for statistic info
    private int numberOfAttempts = 1;

    public class Range {
        private static final int RAND_MAX = 100;
        private static final int LOWER_RANGE_BOUND = 0;

        //Delimiters uses for printRange
        private final static char PREFIX = '[';
        private final static String OVERLAPS = "...";
        private final static char SUFFIX = ']';

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

        @Override
        public boolean equals(Object obj) {
            if(obj == this) return true;
            if(!(obj instanceof Range)) return false;
            Range r = (Range) obj;
            return r.lowerBound == lowerBound &&
                    r.upperBound == upperBound;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(this);
        }

        @Override
        public String toString() {
            return "" + Range.PREFIX
                    + getLowerBound()
                    + Range.OVERLAPS
                    + getUpperBound()
                    + Range.SUFFIX;
        }
    }

    private static class NumberGenerator {
        private static int generateNumber(Range range) {
            return ThreadLocalRandom.current().nextInt(range.lowerBound, range.upperBound);
        }
    }

    public static Game startGame() {
        return new Game(Range.LOWER_RANGE_BOUND, Range.RAND_MAX);
    }

    public static Game startGame(int firstBound, int secondBound) {
        if(isBoundValid(firstBound) && isBoundValid(secondBound))
            return new Game(firstBound, secondBound);

        throw new WrongRangeException();
    }

    private static boolean isBoundValid(int bound) {
        return bound >= 0 && bound <= 100;
    }

    private Game(int firstBound, int secondBound) {
        range = initRange(firstBound, secondBound);
        saveDefaultRange();
        quizNumber = NumberGenerator.generateNumber(range);
    }

    public void resizeRange(int newLowerBound, int newUpperBound) {
        if(validateNewRangeValue(newLowerBound, newUpperBound)) {
            range.lowerBound = newLowerBound;
            range.upperBound = newUpperBound;
        } else
            throw new WrongRangeException();
    }

    private Range initRange(int firstBound, int secondBound) {
        Range r;

        if(firstBound > secondBound) {
            r = new Range(secondBound, firstBound);
        }
        else {
            r = new Range(firstBound, secondBound);
        }

        return r;
    }

    private boolean validateNewRangeValue(int newLowerBound, int newUpperBound) {
        return range.lowerBound <= newLowerBound && range.upperBound >= newUpperBound;
    }

    private void saveDefaultRange() {
        primaryRange = new Range(range.lowerBound, range.upperBound);
    }

    public boolean isQuizInRange(int quiz) {
        return quiz >= getLowerBound() && quiz <= getUpperBound();
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

    public int getLowerBound() {
        return range.lowerBound;
    }

    public int getUpperBound() {
        return range.upperBound;
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
