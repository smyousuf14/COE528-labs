package coe528.lab4;

/**
 *
 * @author Syed Yousuf
 */
import java.util.ArrayList;

public class StackOfDistinctStrings {

// Overview: StacksOfDistinctStrings are mutable, bounded
// collection of distinct strings that operate in
// LIFO (Last-In-First-Out) order.
//
// The abstraction function is:
// a) AF(r) = r.items.get(0) + r.items.get(1) + r.items.get(3) + ... + r.items.get(i - 1) 
//       where  i is the number of elements in the stack 
//      
//
//
// The rep invariant is:
// b) RI(r) = r.pop() when r.items.size() != 0
//
//
//
//
//the rep
    private ArrayList<String> items;

// constructor
    public StackOfDistinctStrings() {

// EFFECTS: Creates a new StackOfDistinctStrings object
        items = new ArrayList<String>();

    }

    public void push(String element) throws Exception {

// MODIFIES: this
// EFFECTS: Appends the element at the top of the stack
// if the element is not in the stack, otherwise
// does nothing.
        if (element == null) {
            throw new Exception();
        }

        if (false == items.contains(element)) {
            items.add(element);
        }

    }

    public String pop() throws Exception {

// MODIFIES: this
// EFFECTS: Removes an element from the top of the stack
        if (items.size() == 0) {
            throw new Exception();
        }

        return items.remove(items.size() - 1);

    }

    public boolean repOK() {

// EFFECTS: Returns true if the rep invariant holds for this
// object; otherwise returns false
// c) Check if the conditions hold. 
        // Local Variables
        boolean repOK = false;

        if (items.size() == 0) 
        {
            repOK = false;
        } 
        else 
        {
            repOK = true;
        }

        return repOK;

    }

    public String toString() {

// EFFECTS: Returns a string that contains the strings in the
// stack and the top element. Implements the
// abstraction function.
// d) Write the code for the toString() here
    
        // Local Variables
        String returnString = "";
        int length = items.size();
        int indexNumber;

        // Iterate through each element and get all the elements
        for(indexNumber = 0; indexNumber < length; indexNumber++)
        {
            returnString += " " + items.get(indexNumber);
        }

        return returnString;
    
    }

}
