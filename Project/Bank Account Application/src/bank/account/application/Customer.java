package bank.account.application;

import java.io.*;
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
    protected Level currentLevel;
    
    // Constructor(s)
    
    /**
     * Creates a Customer account with no balance.
     * 
     * @Effects: Creates a Customer account with zero balance.
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
    
    /**
     * 
     * @Effects: Get the level of this customer
     */
    public Level getLevel()
    {
        return currentLevel;
    }
    
    /**
     * 
     * @Effects: Get the customer file which has all the info for this customer.
     */
    public CustomerFile getCustomerFile()
    {
        return customerFile;
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
     * @Effects: Sets the successful flag to false.
     */
    public void logout()
    {
        SuccessfulLogin = false;
    }
    
    /**
     * 
     * @Effects: Adds the specified amount of money to this customer's balance.
     */
    public void addMoney(double money)
    {
        // Add the money
        AccountBalance  = AccountBalance + money;
        
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
     * 
     * @Effects: Remove specified amount of money from this customer's balance.
     */
    public void useMoney(double money)
    {
        AccountBalance = AccountBalance - money - currentLevel.getFee();
        
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
    
    public static void main(String[]args)
    {
        try
        {
        Customer c = new Customer("yousuf" , "123");
        
        System.out.println(c.getAccountBalance());
        System.out.println(c.getLevel().getStatus());
        
        c.addMoney(100);
        
        System.out.println(c.getAccountBalance());
        System.out.println(c.getLevel().getStatus());
        
        c.useMoney(1);
        
        System.out.println(c.getAccountBalance());
        System.out.println(c.getLevel().getStatus());
        
        System.out.println(c.getCustomerFile().getRole());
        
        }
        catch(FileNotFoundException e)
        {
            System.err.println("username not correct");
        }
    }
}
