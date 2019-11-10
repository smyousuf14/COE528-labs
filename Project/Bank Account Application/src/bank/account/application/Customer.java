package bank.account.application;

/**
 * A Customer has a specific mutable balance in their account
 * and can have any three level of membership. This class, although called customer
 * refers to the bank account that a specific customer has. 
 * 
 * 
 * @author Syed Yousuf
 */
public class Customer 
{
    // Instance Variables
    private double AccountBalance;
    private CustomerFile customerFile;
    private boolean SuccessfulLogin;
    
    // Constructor(s)
    
    /**
     * Creates a Customer account with no balance.
     * 
     * @Effects: Creates a Customer account with zero balance.
     */
    public Customer(String username, String password)
    {
        AccountBalance = 0;
        customerFile = new CustomerFile(username, password, "customer");
        SuccessfulLogin = false;
    }
    
    /**
     * Creates a Customer account with specified initial values.
     * 
     * @Effects: Creates a customer object with specified values.
     */
    public Customer(double accountBalance)
    {
        this.AccountBalance = accountBalance;
    }
    
    // Getters and setters methods
    
    /**
     * Get account balance.
     * 
     * @Effects: Get the account balance.
     */
    public double getAccountBalance()
    {
        return this.AccountBalance;
    }
    
    // Other methods
    
    /**
     * Login the customer to their account if the username and 
     * password are valid.
     * 
     * @Effects: Checks if the username and password match and sets the success flag respectively.
     */
    public void login(String username, String password)
    {
        // Check if the username and passwords match.
        if(this.customerFile.getUsername().equals(username) && this.customerFile.getPassword().equals(password))
        {
            // Set the successful flag on.
            SuccessfulLogin = true;
        }
        else
        {
            // Set the success flag off just in case.
            SuccessfulLogin = false;
        }
    }
    
    /**
     * Logs out the Customer from their account.
     * 
     * @Effects: Sets the successful flag to false.
     */
    public void logout()
    {
        SuccessfulLogin = false;
    }
    
}
