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

    for (char letter : word.toCharArray()) {
      char result =  guessedLetters.contains(letter) ? letter : '_' ;
      strBuilder.append(result);
    }

    strBuilder.replace(0, 1, String.valueOf(word.charAt(0)));

    return strBuilder.toString();
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