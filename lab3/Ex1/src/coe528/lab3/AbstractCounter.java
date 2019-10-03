package coe528.lab3;

/**
 * This is an abstract representation of a counter. 
 * 
 * @author Syed Yousuf
 */
public abstract class AbstractCounter implements Counter
{
    // Instance Variables
    protected int counter;
    
    // Constructors
    
   /**
    * The default constructor that initializes the counter value to 0.
    * 
    */
    public AbstractCounter()
    {
        counter = 0;
    }
    
    // Implement tha important methods from the interface.
    
    /**
     * Return the count value.
     * 
     * @return counter
     */
    @Override
    public String count()
    {
        return Integer.toString(counter); 
    }
    
    /**
     * Increment the count value by 1, if possible.
     */
    @Override
    public void increment()
    {
        if(counter < 9)
        {
            counter++;
        }
        else
        {
            counter = 0;
        }
    }
    
    /**
     * Decrement the count value by 1, if possible.
     */
    @Override
    public void decrement()
    {
        if(counter > 0)
        {
            counter--;
        }
        else
        {
            counter = 9;
        }
    }
    
    /**
     * Reset the counter value.
     */
    @Override
    public void reset()
    {
        counter = 0;
    }
}