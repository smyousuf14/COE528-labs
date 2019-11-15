package bank.account.application;

import java.io.*;
import java.util.Scanner;

/**
 * Each Customer file contains the information of a customer.
 * 
 * @author Syed Yousuf
 */
public class CustomerFile 
{
    // Instance Variables
    private String username;
    private String password;
    private String role;
    private double AccountBalance;
    
    // Constructor(s)
    
    /**
     * Creates a CustomerFile with default values.
     * 
     * @Effects: Creates a default value CustomerFile
     */
    public CustomerFile(String username) throws FileNotFoundException
    {
        // Get the file by its username.
        File thisFile = new File("" + username + ".txt");
        Scanner reader = new Scanner(thisFile);
        
        this.username = reader.nextLine();
        this.password = reader.nextLine();
        this.role = reader.nextLine();
        this.AccountBalance = Double.parseDouble(reader.nextLine());
        
        // Close the reader
        reader.close();
    }
    
    // Getter and Setter methods.

    /**
     * 
     * @Effects: Gets the Username
     * @return the username
     */
    public String getUsername() 
    {
        return username;
    }

    /**
     * @Effects: Gets the password
     * @return the password
     */
    public String getPassword() 
    {
        return password;
    }

    /**
     * @Effects: Get the role
     * @return the role
     */
    public String getRole() 
    {
        return role;
    }
    
    /**
     * @Effects: Get the Account Balance
     */
    public double getAccountBalance()
    {
        return AccountBalance;
    }
    
    /**
     * @Effects: Sets the account balance.
     */
    public void setAccountBalance(double accountBalance)
    {
        this.AccountBalance = accountBalance;
    }
    
    // Other methods
    
    /**
     * @Effects: Updates the account info instance variables.
     */
    public void updateAccountInfo()
    {
        File CustomerFile = new File("" + username + ".txt");
        try{
            FileWriter Write = new FileWriter("" + username + ".txt");
            Write.write("" + this.username);
            
            // new line
            Write.write(System.getProperty( "line.separator" ));
            
            Write.write("" + this.password);
            
             // new line
            Write.write(System.getProperty( "line.separator" ));
            
            Write.write("customer");
            
             // new line
            Write.write(System.getProperty( "line.separator" ));
            
            Write.write("" + this.AccountBalance);
            
            
            // Close the file
            Write.close();
        }
        catch(IOException e)
        {
            
        }
    }
}
