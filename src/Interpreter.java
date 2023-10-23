/**
 * The job of this class is to determine all the basic commands for
 * the DishIt program and evaluates the strings sent in to determine
 * whether what is sent in is either a command, data that can be added 
 * to stack, or finally an error and the program should return an error
 * message and terminate
 * @author zaknilsen
 *
 */
public class Interpreter {
    /** Calls on FancyStack so that methods can be called upon */
    protected FancyStack fancy;

    public Interpreter() {
        fancy = new FancyStack();
    }
    /**
     * This method evaluates multiple commands or statements and determines
     * by splitting them at semicolons and sending them to eval method what
     * to do and then returning true or false determining whether there is an 
     * error or not
     * 
     * @param data String of data that is split at semicolons and then
     * read by eval method to determine what to do with what is sent
     * 
     * @return boolean which determines whether there is an error or not
     * that ultimately determines whether program will be terminated
     */
    public boolean evalMultiple(String[] data) {
        //should evaluate multiple lines which are separated by semicolons
        for (int i = 0; i < data.length; i++) {
            boolean holder;
            holder = eval(data[i].trim()); 
            if (holder == false) {
                return false;
            } 
            
        }
        return true;
    }
    /**
     * Will take in a string and evaluate whether it is a command that
     * can be executed, just data that can be added to the stack, or if
     * what is sent in is an error and cannot be executed, causing program
     * to return false which means there is a problem and program terminates
     * 
     * @param statement is statement that user sends to determine what
     * they want to do in the DishIt program
     * 
     * @return boolean that sends true if statement went through and did something
     * returns false if there is an error
     */
    public boolean eval(String statement) {
        //bunch of if else if statements for each command
        //should return false if statement is called but statement can't be executed
        //do print messages in eval method
        if (statement.equals("OP_DUP")) {
            String holder;
            if (fancy.size() == 0) {
                return false;
            }
            holder = fancy.pop();
            fancy.push(holder);
            fancy.push(holder);
            System.out.println("Duplicating...");
            return true;
            
        } else if (statement.equals("OP_REVERSE")) {
            String reverseStatement = "";
            String holder;
            if (fancy.size() == 0) {
                return false;
            }
            holder = fancy.pop();
            for (int i = holder.length() - 1; i >= 0; i--) {
                reverseStatement = reverseStatement + holder.charAt(i);    
            }
            fancy.push(reverseStatement);
            System.out.println("Reversing...");
            return true;
            
        } else if (statement.equals("OP_CONCAT")) {
            String holder;
            String holder2;
            String concatenation = "";
            if (fancy.size() < 2) {
                return false;
            }
            holder = fancy.pop();
            holder2 = fancy.pop();
            //supposed to print holder 2 or holder first?
            concatenation = concatenation + holder2 + holder;
            fancy.push(concatenation);
            System.out.println("Concatenating...");
            return true;
            
        } else if (statement.equals("OP_EQUAL")) {
            String holder;
            String holder2;
            if (fancy.size() < 2) {
                return false;
            }
            holder = fancy.pop();
            holder2 = fancy.pop();
            if (holder.equals(holder2)) {
                fancy.push("True");
                System.out.println("Testing equality...");
                return true;
            } else {
                fancy.push("False");
                System.out.println("Testing equality...");
                return true;
            }
            
        } else if (statement.equals("OP_ADD")) {
            String holder;
            String holder2;
            int intHolder;
            int intHolder2;
            int total;
            String intToString;
            
            if (fancy.size() < 2) {
                return false;
            }
            holder = fancy.pop();
            holder2 = fancy.pop();
            intHolder = Integer.parseInt(holder);
            intHolder2 = Integer.parseInt(holder2);
            total = intHolder + intHolder2;
            intToString = String.valueOf(total);
            fancy.push(intToString);
            System.out.println("Adding...");
            return true;
            
        } else if (statement.equals("OP_MULT")) {
            String holder;
            String holder2;
            int intHolder;
            int intHolder2;
            int total;
            String intToString;
            
            if (fancy.size() < 2) {
                return false;
            }
            holder = fancy.pop();
            holder2 = fancy.pop();
            intHolder = Integer.parseInt(holder);
            intHolder2 = Integer.parseInt(holder2);
            total = intHolder * intHolder2;
            intToString = String.valueOf(total); 
            fancy.push(intToString);
            System.out.println("Multiplying...");
            return true;
            
        } else if (statement.equals("OP_LOWER")) {
            String holder;
            String toLower;
            if (fancy.size() == 0) {
                return false;
            }
            holder = fancy.pop();
            toLower = holder.toLowerCase();
            fancy.push(toLower);
            System.out.println("Lowering...");
            return true;
            
        } else if (statement.equals("OP_UPPER")) {
            String holder;
            String toUpper;
            if (fancy.size() == 0) {
                return false;
            }
            holder = fancy.pop();
            toUpper = holder.toUpperCase();
            fancy.push(toUpper);
            System.out.println("Uppering...");
            return true;
            
        } else if (statement.equals("OP_SWAP")) {
            String holder;
            String holder2;
            if (fancy.size() < 2) {
                return false;
            }
            holder = fancy.pop();
            holder2 = fancy.pop();
            fancy.push(holder);
            fancy.push(holder2);
            System.out.println("Swapping...");
            return true;
            
        } else if (statement.equals("OP_DROP")) {
            String holder;
            if (fancy.size() == 0) {
                return false;
            }
            holder = fancy.pop();
            System.out.println("Dropping...");
            return true;
            
        } else if (statement.equals("OP_NIP")) {
            String holder;
            String holder2;
            if (fancy.size() < 2) {
                return false;
            }
            holder = fancy.pop();
            holder2 = fancy.pop();
            fancy.push(holder);
            System.out.println("Nipping...");
            return true;
            
        } else if (statement.equals("OP_FINISH")) {
            String holder;
            if (fancy.size() == 0) {
                return false;
            }
            holder = fancy.pop();
            System.out.println("Final Answer: " + holder);
            fancy.clear();
            return true;
        } else {
            fancy.push(statement);
            System.out.println("Adding data to stack...");
            return true;
        }
    }
}
    
