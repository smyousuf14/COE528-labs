package bank.account.application;

/**
 * Provides an abstract view of a level that a Customer can have.
 * 
 * @author Syed Yousuf
 */
public abstract class Level 
{
    // List of abstract methods
    protected String status;
    protected int Fee;
    
    /**
     * 
     * Effects: Gets the status of this level.
     */
    public abstract String getStatus();
    
    /**
     * 
     * Effects: Gets the Fee of this level.
     */
    public abstract int getFee();
    
    /**
     * Set current Level to this level.
     * 
     * Effects: Sets the current level to this level.
     */
    public abstract void setLevel(Customer customer);
}
