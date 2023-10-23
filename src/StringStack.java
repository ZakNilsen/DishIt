
import java.util.ArrayList;
/**
 * This class holds the ArrayList that everything  will be added to
 * and will add and remove items depending on which method is called
 *  
 * @author zaknilsen
 *
 */
public class StringStack {
    /** is ArrayList of strings where every piece of data that is added
     * to stack will be held */
    private ArrayList<String> theItems;
    
    public StringStack() {
        theItems = new ArrayList<String>();
    }
    
    /**
     * will add item to the ArrayList
     * 
     * @param item is String that will be added to ArrayList
     * 
     * @return void
     */
    public void push(String item) {
        theItems.add(item);
    }
    
    /**
     * Method will remove the top item of the ArrayList and remove it
     * once it has confirmed that there is first something that can be
     * removed
     * 
     * @return String of item that is removed
     */
    public String pop() {
        if (theItems.size() == 0) {
            return null;
        }
        return theItems.remove(theItems.size() - 1);
    }
}