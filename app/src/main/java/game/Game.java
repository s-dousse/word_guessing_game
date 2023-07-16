package game;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
  private int remainingAttempts = 10;
  private ArrayList<Character> guessedLettersTracker = new ArrayList<>();
  String word;
  public Game(WordChooser wordChooser) {
    this.word = wordChooser.getRandomWordFromDictionary();
  }
  public static void main(String[] args) {
  }

  public String getWordToGuess() {
    StringBuilder strBuilder= new StringBuilder(this.word);
    // TODO: This will throw a NullPointerException if world == null
    for(int i = 1; i < this.word.length(); i++){
      strBuilder.replace(i, this.word.length(), "_");
    }

    return strBuilder.toString(); // use String.valueOf(x) if target is a primitive types
  }

  public int getRemainingAttempts() {
    return remainingAttempts;
  }

  public boolean guessLetter(char letter) {
    if (Arrays.asList(this.word.split("")).contains(String.valueOf(letter))) {
      guessedLettersTracker.add(letter);
      return true;
    } else {
      remainingAttempts--;
      return false;
    }
  }
}