package coe528.lab3;

/**
 * A digit counter that is linked with the next counter. Each linked
 * digit counters knows its counter value, as well as its neighbour.
 * 
 * @author Syed Yousuf
 */
public class LinkedDigitCounter extends AbstractCounter
{
    // Instance Variables
    private Counter leftNeighbour;
    
    // Constructors
    /**
     * Default constructor to create a linked digit counter,
     * 
     * @param Counter The value the counter should be set to.
     */
    public LinkedDigitCounter(int Counter)
    {
        this.counter = Counter;
    }
    
    // Getter methods
    
    /**
     * Get the left neighbour of this class.
     * 
     * @return leftNeighbour
     */
    public Counter getLeftNeighbour() 
    {
        return leftNeighbour;
    }
    
    
    
}
