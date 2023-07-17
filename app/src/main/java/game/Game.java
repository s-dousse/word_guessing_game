package game;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
  private int remainingAttempts = 10;
  public ArrayList<Character> guessedLetters = new ArrayList<>();
  String word;
  public Game(WordChooser wordChooser) {
    this.word = wordChooser.getRandomWordFromDictionary();
  }
  public static void main(String[] args) {}

  public String getWordToGuess() {
    StringBuilder strBuilder = new StringBuilder();
    // TODO: This will throw a NullPointerException if world == null

    // for each letter of the word to guess
    // check if it is part of our guessedLetters list
    for (char letter : word.toCharArray()) {
      if (guessedLetters.contains(letter)) {
        strBuilder.append(letter);
      } else {
        strBuilder.append("_");
      }
    }
    // add first letter by default
    strBuilder.replace(0, 1, String.valueOf(word.charAt(0)));

    return strBuilder.toString(); // use String.valueOf(x) if target is a primitive types
  }

  public int getRemainingAttempts() {
    return remainingAttempts;
  }

  public boolean guessLetter(char letter) {
    if (Arrays.asList(this.word.split("")).contains(String.valueOf(letter))) {
      guessedLetters.add(letter);
      return true;
    } else {
      remainingAttempts--;
      return false;
    }
  }
}