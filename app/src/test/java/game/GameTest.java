package game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest {
    @DisplayName("Hides all letters except the first one")
    @Test
    public void testGetWordToGuess() {
        Game game = new Game("MAKERS");
        assertEquals(game.getWordToGuess("MAKERS"), "M_____");
    }
}