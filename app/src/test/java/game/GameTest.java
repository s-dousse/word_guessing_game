package game;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    Game game;

    @BeforeEach
    public void setUp() {
        game = new Game();
    }

    @DisplayName("Game is initialised with 10 remaining attempts")
    @Test
    public void testGetRemainingAttempts() {
        assertEquals(game.getRemainingAttempts(), Integer.valueOf(10));
    }

    @DisplayName("Hides all letters except the first one")
    @Test
    public void testGetWordToGuess() {
        assertEquals(game.getWordToGuess("MAKERS"), "M_____");
    }

    @Disabled
    @DisplayName("Selects a random word from the dictionary")
    @Test
    public void testGetRandomWordFromDictionary() {
        // TODO: how to test randomness? test the random word is included in the dictionary supplied list?
    }
}