package bank.account.application;

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
    
    // Constructor(s)
    
    /**
     * Creates a CustomerFile with default values.
     * 
     * @Effects: Creates a default value CustomerFile
     */
    public CustomerFile(String username, String password, String role)
    {
        this.username = username;
        this.password = password;
        this.role = role;
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
}
