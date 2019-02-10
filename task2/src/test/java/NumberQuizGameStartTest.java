import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import quizgame.Game;
import quizgame.WrongRangeException;

import static org.junit.jupiter.api.Assertions.*;


public class NumberQuizGameStartTest {
    private static Game game;

    @BeforeAll
    public static void init() {
        game = Game.startGame();
        assertNotNull(game);
    }

    @Test
    void should_initRangeFrom0to100_When_InitRangeNotSpecified() {
        assertEquals("0..100", game.getRange().toString());
    }

    @Test
    void shouldThrownException_When_RangeGreaterThan100() {
        assertThrows(WrongRangeException.class, () -> {
            Game gameWithUpperRangeValue = Game.startGame(0, 120);
        });
    }

    @Test
    void shouldGenerateNumberInRangeFrom0to100() {
        int number = game.getQuizNumber();
        assertTrue(number > 0 && number <= 100);
    }
}
