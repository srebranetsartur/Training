import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import quizgame.Game;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NumberQuizGameTest {
    private Game game;

    @BeforeAll
    void init() {
        game = new Game();
        assertNotNull(game);
    }

    @Test
    void shouldGenerateNumberInRangeFrom0to100() {
        int number = game.getQuizNumber();
        assertTrue(number > 0 && number <= 100);
    }
}
