/**
 * This class extends from the interpreter class and takes all of its
 * methods and adds some more. The methods that this add are in terms
 * of security and encrypting and decrypting the data that is added to
 * the stack
 * @author zaknilsen
 *
 */
public class InterpreterCrypto extends Interpreter {
    /**
     * This method evaluates what command to execute based off string
     * that is sent. Overrides other eval method so that the encrypt and
     * decrypt methods do not get sent to stack as data so that they are
     * properly executed
     * 
     * @param data takes in string of data and determines what command
     * to execute
     * @return boolean if true executes command, if false is error 
     * and terminates
     */
    @Override
    public boolean eval(String data) {
        if (data.equals("OP_ENCRYPT")) {
            String holder;
            String caesar;
            if (fancy.size() ==  0) {
                return false;
            }
            holder = fancy.pop();
            caesar = caesar(holder, 3);
            fancy.push(caesar);
            System.out.println("Encrypting...");
            return true;
        } else if (data.equals("OP_DECRYPT")) {
            String holder;
            String caesar;
            if (fancy.size() == 0) {
                return false;
            }
            holder = fancy.pop();
            caesar = caesar(holder, 23);
            fancy.push(caesar);
            System.out.println("Decrypting...");
            return true;
        } 
        
        if (super.eval(data) == false) {
            return false;
        } else {
            return true;
        } 
    }
    
    /**
     * This method shifts statement that is sent in however many
     * it is told to shift, which can be used to encrypt and or
     * decrypt the statement
     * 
     * @param statement is string that will have its char at a certain index
     * be shifted a certain number of indexes in the alphabet 
     * 
     * @param shift determines how many indexes character will be shifted
     * 
     * @return String of encrypted or decrypted statement that is sent 
     * back to eval method that pushes it back into stack
     */
    private String caesar(String statement, int shift) {
        String finalString = "";
        //Caesar cipher and replace upper or lower case letter 
        //Should replace with letter 3 spots to right in alphabet
        // decryption same as 26-n which would be 23 to right
        String encrypt = "";
        String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
        String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        
        for (int i = 0; i < statement.length(); i++) {
            int index;
            if (Character.isLowerCase(statement.charAt(i))) {
                index = lowerAlphabet.indexOf(statement.charAt(i));
                index = (index + shift) % 26;
                encrypt = encrypt + lowerAlphabet.charAt(index);
            } else if (Character.isUpperCase(statement.charAt(i))) {
                index = upperAlphabet.indexOf(statement.charAt(i));    
                index = (index + shift) % 26;
                encrypt = encrypt + upperAlphabet.charAt(index);
            } else {
                encrypt = encrypt + statement.charAt(i);
            }  
        }   
        finalString = finalString + encrypt;
        return finalString; 
    }
}
