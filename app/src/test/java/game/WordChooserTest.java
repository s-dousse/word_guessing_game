package game;

import org.junit.jupiter.api.*;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class WordChooserTest {
    WordChooser wordChooser;

    @BeforeEach
    public void setUp() {
        wordChooser = new WordChooser();
    }

    @DisplayName("Selects a random word from the dictionary")
    @Test
    public void testGetRandomWordFromDictionary() {
        String[] MOCK_DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON", "BRUNCH"};
        assertTrue(Arrays.asList(MOCK_DICTIONARY).contains(wordChooser.getRandomWordFromDictionary()));
    }
}