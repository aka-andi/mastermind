/**
 * Class that handles user input for Mastermind Game
 * 
 * @author Andrea Motas
 * @version 12.4.18
 */

public class InputChecker {

    /*
     * Check if user input for selectDifficulty() in MastermindGame class is correct.
     * @param String difficultyPicked containing the user input
     * @return int = length of the passcode depending on difficulty selected.
     */
    public int correctDifficultyInput(String difficultyPicked){
       switch(difficultyPicked){
          case "e": 
             return 3; 
          case "n": 
             return 4; 
          case "h": 
             return 5; 
          case "m": 
             return 6; 
          default: 
             return 0;
       }
    }
    
    /*
     * Check if the user's input is a 4 character combination of q,w,e,r,t, or y or a single z.
     * Called in promptUserToMakeGuess() in MastermindGame class.
     * @param String userInput which is the user's input during a guess.
     * @param int passcodeLength which is the passcode's length.
     * @return boolean true if input is valid
     */
    public boolean correctGuessInput(String userInput, int passcodeLength){
       if(quit(userInput))
          return true;
       if(userInput.length() == passcodeLength)
          for(int i = 0; i < userInput.length(); i++) //check that each character in input is either q,w,e,r,t, or y
             switch(userInput.charAt(i)){
                case 'q': 
                case 'w': 
                case 'e': 
                case 'r':
                case 't':
                case 'y': 
                   return true;
             }
       return false;
    }
    
    /*
     * Check if user input calls to quit the game
     * @param String userInput containing the user's input from the promptUserToMakeGuess() in MastermindGame class.
     * @return true if the user wants to quit (inputs 'z')
     */
    public boolean quit(String userInput){
       if(userInput.equals("z")) //key for quitting
          return true;
       return false;
    }
 }