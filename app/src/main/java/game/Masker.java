package game;

import java.util.ArrayList;

public class Masker {
    public String hideWord(String word, ArrayList<Character> guessedLetters) {
        StringBuilder strBuilder = new StringBuilder();
        // TODO: This will throw a NullPointerException if world == null

        for (char letter : word.toCharArray()) {
            char result =  guessedLetters.contains(letter) ? letter : '_' ;
            strBuilder.append(result);
        }

        strBuilder.replace(0, 1, String.valueOf(word.charAt(0)));

        return strBuilder.toString();
    }
}