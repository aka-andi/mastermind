/**
 * Parent class of CheckerSequence and PasscodeSequence
 
 * @author Andrea Motas
 * @version 12.4.18
 */
public interface Sequence {

   /*
    * Abstract method
    * @param int numElements to determine char[] length
    * @return char[] sequence
    */
   public char[] createSequence(int numElements);
}
