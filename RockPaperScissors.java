// So import java.util.Scanner and Random imports modules to get user input and generate random numbers right?
import java.util.Scanner;
import java.util.Random;

/* All java code has to contain at least one class, but can contain more, and while you've written this whole
 * thing in one big class this could have been split up into several smaller classes? Is that correct? 
 * 
 * Then within this class you've broken it into 4 thingys (I don't know the term), one called main which is what
 * happens when the class is run, another called getUserType which returns the users selection, another called
 * getComputerType which returns the computers selection and finally GenerateRandomNumber which returns the 
 * random number used to determine the computers selection.
 */

public class RockPaperScissors {

	/* I thought this line specifies that once the RockPaperScissors class is called within that class there is a 
	 * variable of somekind called Scanner, and the one below another variable called Random, but I think I've 
	 * got that wrong.
	 */
  static Scanner input = new Scanner(System.in);
  static Random rand = new Random();

  /* I've just realised the word Type must relate to the file Type.java, but I don't understand exactly how 
   * that relationship works or why lines don't just read user = getUserType for example. Basically this says, 
   * 'User should be defined as whatever variable is returned after running the getUserType thingy and computer 
   * should be defined as whatever variable is returned after running the getComputerType thingy though. 
   */
  public static void main(String[] args) {
    Type user = getUserType();
    Type computer = getComputerType();

    /* so this tells the program to ask for a play in the form of keyboard input from the user if user is
     * currently null. 
     */
    while (user == null) {
      System.out.println("Enter your play: ");
      user = Type.parseType(input.next());
      if (user == null) {
        System.out.println("invalid try again");
      }
    }

    /*This bit decides the outcome of the game, comparing the 'user' and 'computer' variables which were defined 
     * earlier. I don't quite get how beats works or calls the operation thingy from the other file though.
     */
    
    if (user.equals(computer)) {
      System.out.println("It's a tie!");
    } else if (user.beats(computer)) {
      System.out.println(user + " beats " + computer + " You win!!");
    } else {
      System.out.println(computer + " beats " + user + " You lose!!");
    }
  }

  // So this is the thingy (I really need to learn the term) which gets the user choice.
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

  // And this is the thingy that gets the computer type.
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
  
  // This generates a random number from a given limit provided when the thingy (I want to say operation) 
  // is called  
  public static int GenerateRandomNumber(int min, int max) {
      return rand.nextInt((max - min) + 1) + min; //generate random number between 1 inclusive and 3 inclusive
  }
}
