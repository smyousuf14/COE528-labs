package bank.account.application;

/**
 * A Platinum level customer does not have to pay any fees.
 * 
 * @author Syed Yousuf
 */
public class Platinum extends Level
{
    // Instance Variable List
    
    // Constructors
    
    /**
     * A default constructor for creating Platinum level objects.
     * 
     * Effects: Creates a Platinum Level object with default values.
     */
    public Platinum()
    {
        status = "Platinum";
        Fee  = 0;
    }
    
    /**
     * 
     * Effects: Gets the status of this level.
     */
    @Override
    public String getStatus()
    {
        return status;
    }
    
    /**
     * 
     * Effects: Gets the Fee of this level.
     */
    @Override
    public int getFee()
    {
        return Fee;
    }
    
    /**
     * Set current Level to this level.
     * 
     * Effects: Sets the current level to this level.
     */
    @Override
    public void setLevel(Customer customer)
    {
        customer.currentLevel = new Platinum();
    }
    
    
}
