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
        assertEquals(Integer.valueOf(10), game.getRemainingAttempts());
    }

    @Nested
    class testGetWordToGuess {
        @DisplayName("Hides all letters except the first one by default")
        @Test
        public void testGetWordToGuess() {
            assertEquals("D________", game.getWordToGuess());
        }

        @DisplayName("Displays the letters correctly guessed")
        @Test
        public void testGetWordToGuessAfterCorrectGuess() {
            game.guessLetter('E');
            assertEquals("DE_E___E_", game.getWordToGuess());
        }
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
            assertEquals(10, game.getRemainingAttempts());
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
            assertEquals(9, game.getRemainingAttempts());
        }
    }

    @Nested
    class testWordHasBeenGuessed {
        @DisplayName("Word guessed correctly")
        @Test
        public void testWithCorrectGuess() {
            char[] wordToGuess = {'E', 'V', 'L', 'O', 'P', 'R'};
            for(int i = 0; i < wordToGuess.length; i++) {
                game.guessLetter(wordToGuess[i]);
            }
            assertEquals(true, game.wordHasBeenGuessed());
        }

        @DisplayName("Word has not been guessed correctly")
        @Test
        public void testWithIncorrectGuess() {
            char[] wordToGuess = {'E', 'V', 'L', 'O', 'P'};
            for(int i = 0; i < wordToGuess.length; i++) {
                game.guessLetter(wordToGuess[i]);
            }
            assertEquals(false, game.wordHasBeenGuessed());
        }
    }

    @Nested
    class testHasRemainingAttempts {
        @DisplayName("Has remaining attempts")
        @Test
        public void testWithRemainingAttempts() {
            char[] wordToGuess = {'E', 'V', 'L', 'O', 'P', 'R'};
            for(int i = 0; i < wordToGuess.length; i++) {
                game.guessLetter(wordToGuess[i]);
            }
            assertEquals(true, game.hasRemainingAttempts());
        }

        @DisplayName("Has no remaining attempts")
        @Test
        public void testWithNoRemainingAttempts() {
            char[] wordToGuess = {'Q', 'W', 'T', 'Y', 'U', 'I', 'X', 'Z', 'G', 'A'};
            for(int i = 0; i < wordToGuess.length; i++) {
                game.guessLetter(wordToGuess[i]);
            }
            assertEquals(false, game.hasRemainingAttempts());
        }
    }
}