/**
 * Checker Sequence for Mastermind Game
 * Child class of Sequence
 * 
 * @author Andrea Motas
 * @version 12.4.18
 */
public class CheckerSequence implements Sequence{
  
    private int correctLetterAndPosition = 0;
    private int correctLetterOnly = 0;
    private char[] checkerResponse;
    private final String WIN_RESPONSE;
    
    /*
     * Constructor for a CheckerSequence object.
     * Sets up the final field WIN_RESPONSE based on the passcode's length.
     * @param String newPasscode containing the passcode from the MastermindGame class.
     */
    public CheckerSequence(String newPasscode){
       String s = "";
       for(int i = 0; i < newPasscode.length(); i++)
          s += "B";
       WIN_RESPONSE = s;
    }
   
   /*
    * Analyzes the user's guess and provides information for the correctLetterAndPosition and correctLetter fields.
    * @param String passcode containing the game passcode from MastermindGame class.
    * @param String guess containing the user input from the promptUserToMakeGuess() in MastermindGame class.
    * @return char[] checkerResponse giving information comparing the guess and the passcode.
   */
    public char[] checkGuess(String passcode, String guess){
       char[] passcodeArr = passcode.toCharArray();
       char[] guessArr = guess.toCharArray();
       
       for(int i = 0; i < passcodeArr.length; i++){  //check for correct letter AND position
          if(guessArr[i] == passcodeArr[i]){
             //to replace guessArr[i] and passcodeArr[i] so it isn't counted again
             passcodeArr[i] = 'k';
             guessArr[i] = 'g';
             correctLetterAndPosition++;
          }
       }
       for(int i = 0; i < guess.length(); i++){  //check for correct letter only
          for(int j = 0; j < passcodeArr.length; j++){
             if(guessArr[i] == passcodeArr[j]){
                passcodeArr[j] = 'k';
                correctLetterOnly++;
                break;
             }
          }
       }
       return createSequence(correctLetterAndPosition + correctLetterOnly);
    }
   
   /*
    * Generates a checker response representing the results of the guess when input in checkGuess().
    * @param int checkerResponseLength, determining the length of the sequence based on checkGuess()
    * @return char[] key, a character combination denoting the game response to the user's guess
    */
    @Override
    public char[] createSequence(int checkerResponseLength){
       checkerResponse = new char[checkerResponseLength];
       for(int i = 0; i < checkerResponse.length; i++){
          if(correctLetterAndPosition > 0){
             checkerResponse[i] = 'B';
             correctLetterAndPosition--;
          }
          else{
             checkerResponse[i] = 'b';
             correctLetterOnly--;
          }
       }
       return checkerResponse;
    }
   
    /*
     * Determine if user won by checking the game response (should be all B's for every character)
     * @return true if the user won
     */
    public boolean checkWins(){
       if(WIN_RESPONSE.equals(String.valueOf(checkerResponse)))
          return true;
       return false;
    }  
 }
 