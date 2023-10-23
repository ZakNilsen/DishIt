import java.util.Scanner;
/**
 * This class compiles all the other classes so that the DishIt program
 * can function properly and also takes in user data to determine whether
 * the crypto function or normal function wants to be used. Once this is 
 * determined it takes in user data that will evaluated and execute whatever
 * is resulted from the inputed user data
 * @author zaknilsen
 *
 */
public class DishItDriver {

    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        StringStack stringStack = new StringStack();
        FancyStack extra = new FancyStack();
        Interpreter dishIt;
        String programType;
        
        System.out.println("DishIt or DishIt-crypto: ");
        programType = keyboard.nextLine();
        
        if (programType.equals("DishIt")) {
            dishIt = new Interpreter();   
        } else  {
            dishIt = new InterpreterCrypto();
        } 
        
        //do more thorough testing on others later as well
        while (true) {
            String data = null;
            String[] multipleData;
            boolean eval;
            System.out.println(">> ");
            data = keyboard.nextLine();
            if (data.equals(":exit")) {
                System.out.println("Goodbye!");
                return; 
            }
            //eval = dishIt.eval(data);
            multipleData = data.split(";");
            eval = dishIt.evalMultiple(multipleData);
            if (eval == false) {
                System.out.println("Error");
                System.out.println("Goodbye!");
                return;
            }      
        }  
    }  
}
