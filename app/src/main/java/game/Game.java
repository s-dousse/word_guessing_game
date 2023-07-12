package game;

public class Game {
  public Game(String wordInput){}
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
}