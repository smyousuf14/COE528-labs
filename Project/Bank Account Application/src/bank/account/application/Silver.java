package bank.account.application;

/**
 * A silver level customer is the lowest level a customer can be. Only customers
 * that have less than a $10 000 are at this level. The fee that must be paid when 
 * an online purchase is made is 20 dollars with this level.
 * 
 * @author Syed Yousuf
 */
public class Silver implements Level
{
    // Instance Variables
    protected String status;
    protected int Fee;
    
    // Constructor methods
    
    /**
     * A default constructor for creating Silver level objects.
     * 
     * @Effects: Creates a Silver Level object with default values.
     */
    @Override
    public void addMoney(double Money)
    {
        
    }
    
    // Other methods
    
    
}
