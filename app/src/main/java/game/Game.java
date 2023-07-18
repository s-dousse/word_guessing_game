package game;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Game {
  private int remainingAttempts = 10;
  public ArrayList<Character> guessedLetters = new ArrayList<>();
  String word;

  public static void main(String[] args) {
    Game game = new Game(new WordChooser());
    Scanner scanner = new Scanner(System.in);
    System.out.println("Welcome! Here's a little game where you have to guess a given word :)");
    System.out.println("The word to guess is: " + game.getWordToGuess());
    System.out.println("Remember you can only guess one letter at the time, it's your turn:");
    String usersGuess = scanner.nextLine();
    game.guessLetter(usersGuess.charAt(0));
  }
  public Game(@NotNull WordChooser wordChooser) {
    this.word = wordChooser.getRandomWordFromDictionary();
  }

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