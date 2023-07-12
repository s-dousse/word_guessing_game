package game;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game("MAKERS");
    }

    @DisplayName("Game is initialised with 10 remaining attempts")
    @Test
    public void testGetRemainingAttempts() {
        assertEquals(game.getRemainingAttempts(), 10);
    }

    @DisplayName("Hides all letters except the first one")
    @Test
    public void testGetWordToGuess() {
        assertEquals(game.getWordToGuess("MAKERS"), "M_____");
    }
}