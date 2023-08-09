package game;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class GameTest {
    Game game;
    Masker mockedMasker;


    @BeforeEach
    public void setUp() {
        WordChooser mockedChooser = mock(WordChooser.class);
        when(mockedChooser.getRandomWordFromDictionary()).thenReturn("DEVELOPER");

        mockedMasker = mock(Masker.class);
        game = new Game(mockedChooser, mockedMasker);
    }

    @DisplayName("Game is initialised with 10 remaining attempts")
    @Test
    public void testGetRemainingAttempts() {
        assertEquals(Integer.valueOf(10), game.getRemainingAttempts());
    }

    @Nested
    class testGuessLetter {
        @DisplayName("Indicates if the letter is in the word")
        @Test
        public void testGuessLetterWithCorrectGuess() {
            assertTrue(game.guessLetter('E'));
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
    }

    @Nested
    class testWordHasBeenGuessed {
        @DisplayName("Word guessed correctly")
        @Test
        public void testWithCorrectGuess() {
            ArrayList<Character> guessedLettersList = new ArrayList<>();
            char[] lettersToGuess = {'E', 'V', 'L', 'O', 'P', 'R'};
            for(int i = 0; i < lettersToGuess.length; i++) {
                game.guessLetter(lettersToGuess[i]);
                guessedLettersList.add(lettersToGuess[i]);
            }

            when(mockedMasker.hideWord("DEVELOPER", guessedLettersList )).thenReturn("DEVELOPER");
            assertEquals(true, game.wordHasBeenGuessed());
        }

        @DisplayName("Word has not been guessed correctly")
        @Test
        public void testWithIncorrectGuess() {
            ArrayList<Character> guessedLettersList = new ArrayList<>();
            char[] lettersToGuess = {'E', 'V', 'L', 'O', 'P'};
            for(int i = 0; i < lettersToGuess.length; i++) {
                game.guessLetter(lettersToGuess[i]);
                guessedLettersList.add(lettersToGuess[i]);
            }
            when(mockedMasker.hideWord("DEVELOPER", guessedLettersList )).thenReturn("DEVELOPE_");
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

    @Nested
    class testGetRemainingAttempts {
        @DisplayName("Decreases the number of attempts when the guess is wrong")
        @Test
        public void testGuessLetterChangesRemainingAttemptsCount() {
            game.guessLetter('G');
            assertEquals(9, game.getRemainingAttempts());
        }

        @DisplayName("Does not decrease the number of attempts when the guess is correct")
        @Test
        public void testGuessLetterDoesNotChangeRemainingAttemptsCount() {
            game.guessLetter('E');
            assertEquals(10, game.getRemainingAttempts());
        }
    }

    @Disabled
    @DisplayName("Randomly generates a word from the list of words")
    @Test
    public void testGetRandomWord() {
        // TODO: how do test randomness?
    }
}