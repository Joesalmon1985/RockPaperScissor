import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
  static Scanner input = new Scanner(System.in);
  static Random rand = new Random();

  public static void main(String[] args) {
    Type user = getUserType();
    Type computer = getComputerType();

    while (user == null) {
      System.out.println("Enter your play: ");
      user = Type.parseType(input.next());
      if (user == null) {
        System.out.println("invalid try again");
      }
    }

    if (user.equals(computer)) {
      System.out.println("It's a tie!");
    } else if (user.beats(computer)) {
      System.out.println(user + " beats " + computer + " You win!!");
    } else {
      System.out.println(computer + " beats " + user + " You lose!!");
    }
  }

  public static Type getUserType() {
    Type person = null;
    while (person == null) {
      System.out.println("Enter your play: ");
      person = Type.parseType(input.next());
      if (person == null) {
        System.out.println("invalid try again");
      }
    }

    return person;
  }

  public static Type getComputerType() {
    int computerType = GenerateRandomNumber(1, 3);
    if (computerType == 1) {
      return Type.ROCK;
    } else if (computerType == 2) {
      return Type.PAPER;
    } else {
      return Type.SCISSOR;
    }
  }
  
  public static int GenerateRandomNumber(int min, int max) {
      return rand.nextInt((max - min) + 1) + min; //generate random number between 1 inclusive and 3 inclusive
  }
}
