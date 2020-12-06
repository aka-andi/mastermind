/**
 * Passcode Sequence for Mastermind Game
 * Child class of Sequence
 * 
 * Generates random numbers 1-6 to be converted to chars qwerty for passcode
 * @author Andrea Motas
 * @version 12.4.18
 */
import java.lang.Math;
public class PasscodeSequence implements Sequence {
   
   /*
    * Creates a passcode of length numChars.
    * @param int numChars, determining the length of the sequence
    * @return char[] key, a 4 character combination of q,w,e,r,t, or y
    */
   @Override
   public char[] createSequence(int numChars){
      char[] key = new char[numChars];
      for(int i = 0; i < key.length; i++){
         int num = (int)((Math.random()*6) + 1); //generate random int 1-6 inclusive
         key[i] = convertKey(num);
      }
      return key;
   }
   
   /*
    * Converts randomly generated int from createSequence() to a character for the passcode.
    * @param int number is an int 1-6 inclusive that has a corresponding character.
    * @return char[] key, a 3, 4, or 5 character combination of q, w, e, r, t, or y
    */
   public char convertKey(int number){
      char converted = ' ';
      switch(number){ //convert random integer from 1-6 to corresponding character in passcode
         case 1: converted = 'q'; 
            break;
         case 2: converted = 'w'; 
            break;
         case 3: converted = 'e'; 
            break;
         case 4: converted = 'r'; 
            break;
         case 5: converted = 't'; 
            break;
         case 6: converted = 'y'; 
            break;
      }
      return converted;
   }
   
}
