package bank.account.application;

import java.io.*;
/**
 * Overview: A Customer has a specific mutable balance in their account
 * and can have any three level of membership. This class, although called customer
 * refers to the bank account that a specific customer has. This class is mutable, since all 
 * its instance variables can be changed.
 * 
 * Abstract Function: 
 * AF(r) = r.customerFile.userName + r.customerFile.password + r.currentLevel
 * 
 * Rep Invariant:
 * RI(r) = r.username != NULL && r.password != null 
 * 
 * @author Syed Yousuf
 */
public class Customer 
{
    // Instance Variables
    private double AccountBalance;
    private CustomerFile customerFile;
    private boolean SuccessfulLogin;
    protected Level currentLevel;
    
    // Constructor(s)
    
    /**
     * Creates a Customer account with no balance.
     * 
     * Effects: Creates a Customer account with zero balance.
     * Requires: username and password is not null
     * 
     * @param username The username of this customer
     * @param password The password of this customer
     */
    public Customer(String username, String password) throws FileNotFoundException
    {
        // First load the specifed file.   
        customerFile = new CustomerFile(username);
        
        // Set the account balance.
        this.AccountBalance = 0;
        addMoney(customerFile.getAccountBalance());
        
        SuccessfulLogin = false;
    }
    
    /**
     * Creates a Customer account with specified initial values.
     * 
     * Effects: Creates a customer object with specified values.
     * Requires: accountBalance is a real number, not a String
     * 
     * @param accountBalance The account balance to initialize the customer with.
     */
    public Customer(double accountBalance)
    {
        this.AccountBalance = accountBalance;
    }
    
    // Getters and setters methods
    
    /**
     * Get account balance.
     * 
     * Effects: Get the account balance.
     * 
     * @return gets the Account balance of this customer.
     */
    public double getAccountBalance()
    {
        return this.AccountBalance;
    }
    
    /**
     * Get the level of this customer.
     * 
     * Effects: Get the level of this customer
     * 
     * @return gets the current level of this customer
     */
    public Level getLevel()
    {
        return currentLevel;
    }
    
    /**
     * Get the Customer File.
     * 
     * Effects: Get the customer file which has all the info for this customer.
     * 
     * @return gets the customer file of this customer
     */
    public CustomerFile getCustomerFile()
    {
        return customerFile;
    }
    
    /**
     * Get the success rate.
     * 
     * Effects: Get if the log in was successful or not.
     * 
     * @return gets if the customer has successfully logged in or not.
     */
    public boolean getSuccessfulLogin()
    {
        return this.SuccessfulLogin;
    }
    
    // Other methods
    
    /**
     * Login the customer to their account if the username and 
     * password are valid.
     * 
     * Effects: Checks if the username and password match and sets the success flag respectively.
     * Requires: username and password must not be null.
     * 
     * @param username The username of this customer to test
     * @param password The password of this customer to test
     */
    public void login(String username, String password)
    {
        // Check if the username and passwords match.
        if(this.customerFile.getUsername().equals(username) && this.customerFile.getPassword().equals(password) && this.customerFile.getRole().equals("customer"))
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
     * Effects: Sets the successful flag to false.
     */
    public void logout()
    {
        SuccessfulLogin = false;
    }
    
    /**
     * Add money to the customer's balance.
     * 
     * Effects: Adds the specified amount of money to this customer's balance if sufficient funds exist.
     * Requires: money must be a positive value. It must be a double value.
     * 
     * @param money The money to deposit into this customer bank account.
     * 
     */
    public void addMoney(double money)
    {
        // Add the money
        AccountBalance  = AccountBalance + money;
        
        // Update that info
        customerFile.setAccountBalance(this.AccountBalance);
        customerFile.updateAccountInfo();
        
        // Checks to see if the customer's level has change or not.
        if(AccountBalance < 10000)
        {
            // Silver level.
            currentLevel = new Silver();
            
        }
        else
        if(AccountBalance >= 10000 && AccountBalance < 20000)
        {
            // Gold Level.
            currentLevel = new Gold();
        }
        else
        if(AccountBalance >= 20000)
        {
            // Platinum Level.
            currentLevel = new Platinum();
        }
    }
    
    /**
     * This is to make online purchases. Online purchases must be 50 dollars or more in order
     * to make the purchase.
     * 
     * Effects: Remove specified amount of money from this customer's balance by making a purchase.
     * Requires: money must be a positive value.
     * 
     * @param money The money to be used to make a purchase.
     */
    public void useMoney(double money)
    {
        // Local Variables
        boolean noSufficentFunds = false;
        
        // Check if there are sufficient funds.
        if((AccountBalance - money - currentLevel.getFee()) < 0)
        {
            noSufficentFunds = true;
        }

        
        // Check if the money is 50 dollars or more.     
        if(money >= 50 && (noSufficentFunds == false))
        {
            
        
            AccountBalance = AccountBalance - money - currentLevel.getFee();

            // Update that info
            customerFile.setAccountBalance(this.AccountBalance);
            customerFile.updateAccountInfo();

            // Checks to see if the customer's level has change or not.
            if(AccountBalance < 10000)
            {
                // Silver level.
                currentLevel = new Silver();

            }
            else
            if(AccountBalance >= 10000 && AccountBalance < 20000)
            {
                // Gold Level.
                currentLevel = new Gold();
            }
            else
            if(AccountBalance >= 20000)
            {
                // Platinum Level.
                currentLevel = new Platinum();
            }
        
        }
    }
    
    /**
     * Withdraw the specified amount of money from this customer's account.
     * 
     * Effects: Withdraw specified money.
     * Requires: money must be a positive value
     * 
     * @param money The money that will be withdrawing from the account.
     */
    public void withdrawMoney(double money)
    {
        // Local Variables
        boolean noSufficentFunds = false;
        
        // Check if there are sufficient funds.
        if((AccountBalance - money) < 0)
        {
            noSufficentFunds = true;
        }
        
        if(noSufficentFunds == false)
        {
            AccountBalance = AccountBalance - money;

            // Update that info
            customerFile.setAccountBalance(this.AccountBalance);
            customerFile.updateAccountInfo();

            // Checks to see if the customer's level has change or not.
            if(AccountBalance < 10000)
            {
                // Silver level.
                currentLevel = new Silver();

            }
            else
            if(AccountBalance >= 10000 && AccountBalance < 20000)
            {
                // Gold Level.
                currentLevel = new Gold();
            }
            else
            if(AccountBalance >= 20000)
            {
                // Platinum Level.
                currentLevel = new Platinum();
            }
        }
    }
    
    /**
     * Provides the String representation of this class
     * 
     * Effects: Returns a string representation of this class
     * 
     * @return A string representation of this class
     */
    @Override
    public String toString()
    {
        return "username: " + this.customerFile.getUsername() + " password: " + this.customerFile.getPassword() + this.currentLevel;
    }
    
    
    /**
     * Checks if this class is represented properly.
     * 
     * Effect: Returns true if the class is represented properly, in other words if the account balance isn't null.
     * @return Checks if the representation of this class is ok.
     */
    public boolean RepOk()
    {
        if(this.customerFile.getUsername() != null && this.customerFile.getPassword() != null)
        {
            return true;
        }
        else 
        {
            return false;
        }
    }
}  
