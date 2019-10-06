package coe528.lab3;

/**
 * An Odometer has an n-array of linked digit counter and an (n-1) array of digit counter. 
 * 
 * @author Syed Yousuf
 */
public class Odometer implements Counter
{
    // Instance Variables
    private DigitCounter lastCounter;
    private LinkedDigitCounter [] counters;
    private int n;
    
    // Constructors
    
    /**
     * Default constructor creates and n-length Odometer.
     * 
     * @param n The amount of Counters on the Odometer. n >= 1.
     */
    public Odometer(int n)
    {
        // Check if the n value was valid.
        if(n < 1)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            // Now the Odometer instance can be successfully initialized
            this.n = n;
            
            // Successfully create the n - 1 linked digit counters and the 1 digitcounter
            counters = new LinkedDigitCounter[n - 1];
            
            // Create the last counter next.
            lastCounter = new DigitCounter(0);
            
            
            // Set each linked digit counter to 0
            int indexNumber = 0;
            
            if(n > 1)
            {
                counters[0] = new LinkedDigitCounter(0, lastCounter);
            }
            
            for(indexNumber = 1; indexNumber < n - 1; indexNumber++)
            {
                counters[indexNumber] = new LinkedDigitCounter(0, counters[indexNumber - 1]);
            }
                     
        }
    }
    
    // Main Implemented Methods
    
    /**
     * Provide the count of the Odometer
     * 
     * @return The count value
     */
    @Override
    public String count()
    {
        // Local Variables
        String countValue = "";
        int indexNumber = 0;
        
        // First add the last counter.
        countValue += lastCounter.count();
        
        // Next add the rest of the counter. Go from left to right.
        for(indexNumber = 0; indexNumber < (n - 1); indexNumber++)
        {
            countValue += counters[indexNumber].count();
        }
            
        return countValue;
    }
    
    
    /**
     * Increment the Odometer. 
     */
    @Override
    public void increment()
    {
        
       // Increment from the right most if conditions are meet. 
       // Make sure to check if the last counter needs to be incremented  
       if(counters[n - 2].count().equals("9"))
       {
            IncrementLeftNeighbour(counters[n - 2]);
       }
       
       counters[n - 2].increment();
       
        
    }
    
    /**
     * Decrement from the right most if conditions are meet. 
     */
    @Override
    public void decrement()
    {
       // Decrement from the right most if conditions are meet. 
       // Make sure to check if the last counter needs to be decremented 
       if(counters[n - 2].count().equals("0"))
       {
            DecrementLeftNeighbour(counters[n - 2]);
       }
       
       counters[n - 2].decrement();
    }
    
    /**
     * Reset all the values to zero.
     */
    @Override
    public void reset()
    {
        // Local Variables
        int indexNumber = 0;
        
        // Set the last counter - right most to zero
        lastCounter.reset();
        
        for(indexNumber = 0; indexNumber < (n - 1); indexNumber++)
        {
            counters[indexNumber].reset();
        }
    }
    
    /**
     * This function is used to increment the left neighbour. It is important because of the recursion used 
     * in the increment algorithm.
     * 
     * @param  current The current linked digit counter to be incremented.
     */ 
    private void IncrementLeftNeighbour(LinkedDigitCounter current)
    {
        if(current.getLeftNeighbour().count().equals("9"))
        {
            try
            {
            
                // Then increment the left Neighbour
                IncrementLeftNeighbour((LinkedDigitCounter)current.getLeftNeighbour());
            }
            catch(java.lang.ClassCastException e)
            {
                //Do nothing
            }
        }
        
        try
        {
            current.getLeftNeighbour().increment();
        }
        catch(java.lang.ClassCastException e)
        {
            // Do nothing
        }
    }
    
    /**
     * This function is used to decrement the left neighbour. It is important because of the recursion used 
     * in the increment algorithm.
     * 
     * @param  current The current linked digit counter to be decremented.
     */
    private void DecrementLeftNeighbour(LinkedDigitCounter current)
    {
        if(current.getLeftNeighbour().count().equals("0"))
        {
            // Then increment the left Neighbour
            try
            {
                DecrementLeftNeighbour((LinkedDigitCounter)current.getLeftNeighbour());
            }
            catch(java.lang.ClassCastException e)
            {
                //Do nothing
            }
        }
        
        try
        {
            current.getLeftNeighbour().decrement();
        }
        catch(java.lang.ClassCastException e)
        {
            //Do nothing
        }
    }
}
