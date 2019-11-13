package bank.account.application;

/**
 * A gold level customer only has to pay a fee of 10 dollars when making purchases.
 * 
 * @author Syed Yousuf
 */
public class Gold extends Level
{
   // Instance Variables
    
    // Constructors
    
    /**
     * A default constructor for creating Gold level objects.
     * 
     * @Effects: Creates a Gold Level object with default values.
     */
    public Gold()
    {
        status = "Gold";
        Fee = 10;
    }
    
    /**
     * 
     * @Effects: Gets the status of this level.
     */
    @Override
    public String getStatus()
    {
        return status;
    }
    
    /**
     * 
     * @Effects: Gets the Fee of this level.
     */
    @Override
    public int getFee()
    {
        return Fee;
    }
    
    /**
     * Set current Level to this level.
     * 
     * @Effects: Sets the current level to this level.
     */
    @Override
    public void setLevel(Customer customer)
    {
        customer.currentLevel = new Gold();
    }
    
}
