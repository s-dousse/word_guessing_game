package game;

import java.util.Random;

public class WordChooser {
    private static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON", "BRUNCH"};
    // TODO: add a more robust dictionary

    public WordChooser() {}

    public String getRandomWordFromDictionary() {
        int randomIndex = new Random().nextInt(DICTIONARY.length);
        return DICTIONARY[randomIndex];
    }
}