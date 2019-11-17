package bank.account.application;

import java.io.*;
import java.util.Scanner;

/**
 * Overview: A Manager manages the customer accounts in the bank application. This class is not 
 * mutable since its contents cannot change.
 * 
 * @author Syed Yousuf
 */
public class Manager 
{
    // Instance Variables
    private String Username;
    private String Password;
    private String Role;
    private boolean successfulLogin;
    
    // Constructors
    
    /**
     * A default constructor which creates a Manager which 
     * the specified values.
     * 
     * Effect: Creates an object of the Manager class with default constructor values.
     */
    public Manager()
    {
        // Set the default values.
        Username = "admin";
        Password = "admin";
        Role = "manager";
        
        successfulLogin = false;
    }
    
    // Getters and Setters
    
    /**
     * Gets the username of the manager.
     * 
     * Effects: Returns the username of this manager.
     * @return Username
     */
    public String getUsername()
    {
        return Username;
    }
    
    /**
     * Get the password.
     * 
     * Effects: Get the password of this Manager.
     * @return Password
     */
    public String getPassword()
    {
        return Password;
    }
    
    /**
     * Get the role.
     * 
     * Effects: Get the role of this manager.
     * @return Role
     */
    public String getRole()
    {
        return Role;
    }
    
    /**
     * Effects: Gets if the login was successful or not.
     */
    public boolean getLoginSucess()
    {
        return this.successfulLogin;
    }
    
    // Other important methods.
    
    /**
     * Logs in this manager object.
     * 
     * Effects: Checks if Login is possible and set success flag accordingly.
     */
    public void login(String username, String password)
    {
        // Validate the username and password.
        if(this.Username.equals(username) && this.Password.equals(password) && this.Role.equals("manager"))
        {
            successfulLogin = true;
        }
        else
        {
            successfulLogin = false;
        }
    }
    
    /**
     * Logs out this Manager object.
     * 
     * Effects: Sets the login flag to false.
     */
    public void logout()
    {
        successfulLogin = false;
    }
    
    /**
     * Adds a customer.
     * 
     * 
     */
    public void addCustomer(String username, String password)
    {
        try
        {
            // create a new file 
            File CustomerFile = new File("" + username + ".txt");
            CustomerFile.createNewFile();

            FileWriter Write = new FileWriter("" + username + ".txt");
            Write.write("" + username);
            
            // new line
            Write.write(System.getProperty( "line.separator" ));
            
            Write.write("" + password);
            
             // new line
            Write.write(System.getProperty( "line.separator" ));
            
            Write.write("customer");
            
             // new line
            Write.write(System.getProperty( "line.separator" ));
            
            Write.write("100");
            
            
            // Close the file
            Write.close();
        }
        catch(IOException e)
        {
            
        }
    }
    
    
    /**
     * Deletes a customer.
     * 
     * 
     */
    public void deleteCustomer(String username, String password)
    {
        File Customer = new File("" + username + ".txt");
        Customer.delete();
        
        // Delete the object by giving it a null reference
        //customer = null;
    }
    
    /**
     *  Converts an instance of this object into its String equivalent.
     * 
     */
    public String toString()
    {
        return "" + this.Username + this.Password + this.Role;
    }
    
    public static void main(String[]args)
    {
        try
        {
        Manager m = new Manager();
        m.addCustomer("Abdullah", "4321");
        
        Customer m2 = new Customer("Abdullah", "4321");
        
        //m.deleteCustomer(m2, "Abdullah");
        }
        catch(Exception e)
        {
            
        }
    }
}
