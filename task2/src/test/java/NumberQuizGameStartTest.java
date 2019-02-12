import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import quizgame.Game;
import quizgame.WrongRangeException;

import static org.junit.jupiter.api.Assertions.*;


class NumberQuizGameStartTest {
    private static Game game;

    @BeforeAll
    static void init() {
        game = Game.startGame();
        assertNotNull(game);
    }

    @RepeatedTest(1000)
    void QuizNumber_ShouldEquals_To_0_AtLeast_OneTime() {
        assertEquals(0, Game.startGame().getQuizNumber());
    }

    @RepeatedTest(1000)
    void QuizNumber_ShouldEquals_To_100_AtLeast_OneTime() {
        assertEquals(100, Game.startGame().getQuizNumber());
    }

    @Test
    void should_initRangeFrom0to100_When_InitRangeNotSpecified() {
        assertEquals("0..100", game.getRange().toString());
    }

    @Test
    void shouldThrownException_When_RangeGreaterThan100() {
        assertThrows(WrongRangeException.class, () ->
            Game.startGame(0, 120));
    }

    @Test
    void shouldGenerateNumberInRangeFrom0to100() {
        int number = game.getQuizNumber();
        assertTrue(number > 0 && number <= 100);
    }
}
