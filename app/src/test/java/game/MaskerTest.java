package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class MaskerTest {
    Masker masker;
    ArrayList<Character> guessedLetters;

    @BeforeEach
    public void setUp() {
        masker = new Masker();
        guessedLetters = new ArrayList<>();
    }

    @Nested
    class testHideWord {
        @DisplayName("Hides all letters except the first one by default")
        @Test
        public void testHideWord() {
            assertEquals("D________", masker.hideWord("DEVELOPER", guessedLetters));
        }

        @DisplayName("Displays the letters correctly guessed")
        @Test
        public void testHideWordAfterCorrectGuess() {
            guessedLetters.add('E');
            guessedLetters.add('V');
            assertEquals("DEVE___E_", masker.hideWord("DEVELOPER", guessedLetters));
        }
    }
}