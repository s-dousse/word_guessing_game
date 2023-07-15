package game;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    Game game;

    @BeforeEach
    public void setUp() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

        game = new Game(mockedChooser);
    }

    @DisplayName("Game is initialised with 10 remaining attempts")
    @Test
    public void testGetRemainingAttempts() {
        assertEquals(game.getRemainingAttempts(), Integer.valueOf(10));
    }

    @DisplayName("Hides all letters except the first one")
    @Test
    public void testGetWordToGuess() {
        assertEquals(game.getWordToGuess(), "D________");
    }

}