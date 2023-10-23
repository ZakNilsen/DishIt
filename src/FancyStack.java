import java.util.ArrayList;
import java.util.Collections;
/**
 * This class extends StringStack and takes all of its methods, but
 * the ArrayList is private in StringStack so it has to use the methods
 * in StringStack to gain access to the ArrayList there and work in
 * the methods here. This class adds a few more things to do with the
 * stack overall
 * 
 * @author zaknilsen
 *
 */
public class FancyStack extends StringStack {
   
    /**
     * Method determines if the ArrayList is empty or not and returns true
     * if it is and false if is is not.
     * 
     * @return boolean, if true ArrayList is empty, if false ArrayList
     * contains something
     */
    public boolean isEmpty() {
        String holder;
        holder = pop();
        if (holder == null) {
            return true;
        } else {
            push(holder);
            return false;
        }
    }
    
    /**
     * This method will pop every item in ArrayList until the pop 
     * method returns null meaning there is nothing left to pop
     * 
     * @return void
     */
    public void clear() {
        while (pop() != null) {
            pop();
        }
    }
    
    /**
     * This method pops everything in ArrayList since it does not have
     * access to the private instance variable in StringStack and stores
     * all the data that is popped into another ArrayList and then pushes
     * it back in the correct order
     * 
     * @return int returns integer that represents size of ArrayList
     */
    public int size() {
        String holder;
        int size = 0;
        ArrayList<String> storage = new ArrayList<String>();
        holder = pop();
        while (holder != null) { 
            storage.add(holder);
            size = size + 1;
            holder = pop();
        }
        Collections.reverse(storage);
        for (int j = 0; j < size; j++ ) {
            push(storage.get(j)); 
        }
        return size;
    }
}
