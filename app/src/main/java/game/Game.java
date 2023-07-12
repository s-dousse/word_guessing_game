package game;

public class Game {
  private String world;
  public Game(String wordInput){
    world = wordInput;
  }
  public static void main(String[] args) {
  }

  public String getWordToGuess() {
    StringBuilder solution = new StringBuilder();
    char[] arr = world.toCharArray();

    solution.append(arr[0]);
    int length = arr.length - 1;
    for(int i = 0; i < (arr.length - 1); i++){
      solution.append("_");
    }

    return String.valueOf(solution);
  }
}