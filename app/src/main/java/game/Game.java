package game;

import java.util.Random;

public class Game {
  private static final String[] DICTIONARY = {"MAKERS", "CANDIES", "DEVELOPER", "LONDON", "BRUNCH"};
  private int remainingAttempts = 10;
  String word;
  public Game() {
    word = getRandomWordFromDictionary();
  }
  public static void main(String[] args) {
  }

  public String getWordToGuess(String word) {
    StringBuilder strBuilder= new StringBuilder(word);
    // TODO: This will throw a NullPointerException if world == null

    for(int i = 1; i < word.length(); i++){
      strBuilder.replace(i, word.length(), "_");
    }

    return strBuilder.toString(); // use String.valueOf(x) if target is a primitive types
  }

  public int getRemainingAttempts() {
    return remainingAttempts;
  }

  public String getRandomWordFromDictionary() {
    int randomIndex = new Random().nextInt(DICTIONARY.length);
    return DICTIONARY[randomIndex];
  }
}