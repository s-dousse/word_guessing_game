package game;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;
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

    @Nested
    class testGuessLetter {
        @DisplayName("Indicates if the letter is in the word")
        @Test
        public void testGuessLetterWithCorrectGuess() {
            assertTrue(game.guessLetter('E'));
        }

        @DisplayName("Does not decrease the number of attempts when the guess is correct")
        @Test
        public void testGuessLetterDoesNotChangeRemainingAttemptsCount() {
            game.guessLetter('E');
            assertEquals(game.getRemainingAttempts(), 10);
        }

        @DisplayName("Indicates if the letter is not in the word")
        @Test
        public void testGuessLetterWithIncorrectGuess() {
            assertFalse(game.guessLetter('A'));
        }

        @DisplayName("Indicates if the letter is not in the word - non letter character")
        @Test
        public void testGuessLetterWithNonLetterCharacter() {
            assertFalse(game.guessLetter('7'));
        }

        @DisplayName("Decreases the number of attempts when the guess is wrong")
        @Test
        public void testGuessLetterChangesRemainingAttemptsCount() {
            game.guessLetter('G');
            assertEquals(game.getRemainingAttempts(), 9);
        }
    }
}