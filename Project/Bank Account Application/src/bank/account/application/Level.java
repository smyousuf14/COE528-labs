package bank.account.application;

/**
 * Provides an abstract view of a level that a Customer can have.
 * 
 * @author Syed Yousuf
 */
public interface Level 
{
    // List of abstract methods
    
    /**
     * 
     * @Effects: Adds specified amount of money.
     */
    public void addMoney(double money);
    
    /**
     * 
     * @Effects: Removes specified amount of money.
     */
    public void useMoney(double money);
}
