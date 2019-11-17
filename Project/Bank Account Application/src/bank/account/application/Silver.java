package bank.account.application;

/**
 * A silver level customer is the lowest level a customer can be. Only customers
 * that have less than a $10 000 are at this level. The fee that must be paid when 
 * an online purchase is made is 20 dollars with this level.
 * 
 * @author Syed Yousuf
 */
public class Silver extends Level
{
    // Instance Variables
    
    
    // Constructor methods
    
    /**
     * A default constructor for creating Silver level objects.
     * 
     * Effects: Creates a Silver Level object with default values.
     */
    public Silver()
    {
        status = "Silver";
        Fee = 20;
    }
    
    // Other methods
    
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
        customer.currentLevel = new Silver();
    }
    
}
