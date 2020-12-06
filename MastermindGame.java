/**
 * Logic for Mastermind Game
 * 
 * @author Andrea Motas
 * @version 12.4.18
 */
import java.util.Scanner;

public class MastermindGame {
   
 //fields to keep track of game
   private int passcodeLength;
   private final String PASSCODE;
   private int numGuesses = 0;
   private Scanner sc = new Scanner(System.in);
 //fields to check status to determine whether game should end
   private boolean userWins;
   private boolean userQuits;
 //fields that are game components
   private PasscodeSequence passcodeMaker = new PasscodeSequence();
   private CheckerSequence checker;
   private InputChecker inputChecker = new InputChecker();
   
   /*
    * Constructor for MastermindGame class
    * Sets up difficulty and passcode for game
    */
   public MastermindGame(){
      //game setup:  print welcome, generate passcode, initialize checker
      printStart();
      PASSCODE = String.valueOf(passcodeMaker.createSequence(passcodeLength));
      checker = new CheckerSequence(PASSCODE);
   }
   
   /*
    * Called in driver class (Mastermind)
    * Governs the running of the game
    */
   public void play(){
      //continue guess turns until user wins or takes their 20th turn
      while((numGuesses < 20) && !userWins){  
         numGuesses++;
         String guessInput = promptUserToMakeGuess();
         if(userQuits) 
            break;
         runGuess(guessInput);
      }
      endGame();
   }

      
   /*
    * Starting print statement
    * Calls selectDifficulty() and prints response.
    */
   public void printStart(){ 
      System.out.println("\n****************************************");
      System.out.println("///\t\t\tWELCOME TO MASTERMIND\t\t\t///");
      System.out.println("****************************************");
      passcodeLength = selectDifficulty();
      System.out.println("Guess the " + passcodeLength + "-character passcode in as few tries as possible!");
      System.out.println("Valid character 'beads' are represented by the characters:  'q', 'w', 'e', 'r', 't', and 'y'");
      System.out.println("You lose if you fail to guess the passcode in 20 tries.");
      System.out.println("****************************************");
   }
   
   /*
    * Prompt user to choose difficulty, which determines length of passcode
    * Recursion occurs until input is valid.
    * @return int equal to length of passcode.
    */
   public int selectDifficulty(){
      System.out.println("Select difficulty: Easy(e), Normal(n), Hard(h), Master(m)");
      int inputStatus = inputChecker.correctDifficultyInput(sc.next());
      if(inputStatus != 0) //inputStatus is valid (either e, n, h, m)
         return inputStatus;
      System.out.println("Invalid input!");
      return selectDifficulty();
   }
   
   /*
    * Print user input instruction, scan user input, call checkValidInput.
    * Recursion occurs until input is valid.
    * @return String user guess for passcode
    */
   public String promptUserToMakeGuess(){  
      System.out.println("Guess #" + numGuesses + ":\nMake a guess.");
      String userInput = sc.next();
      if(inputChecker.correctGuessInput(userInput, PASSCODE.length())){
         if(inputChecker.quit(userInput)) //check if user quits
            userQuits = true;
         return userInput;
      }
      System.out.println("Invalid input! See text file for instruction.");
      return promptUserToMakeGuess();  //recurse until input is valid
   }     
    
   /*
    * Check the user's guess and print game response
    * @param String input which is the user's guess
    */
   public void runGuess(String guess){
      System.out.println(String.valueOf(checker.checkGuess(PASSCODE, guess)));
      if(checker.checkWins()) //check if the user won.
         userWins = true;
   }
   
   /*
    * Print statement corresponding to user quitting, winning, or losing.
    */
   public void endGame(){
      if(userQuits)
         System.out.println("You quit! Laaaameeee. The passcode is: " + PASSCODE);
      else if(userWins)
         System.out.println("You win! Guesses used: " + numGuesses);
      else
         System.out.println("You lose! The passcode is: " + PASSCODE);
      System.out.println("\n****************************************");
      System.exit(0);
   }
}