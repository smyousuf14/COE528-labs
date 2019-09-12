/*
 * A typical passenger that has the common attribute that all passengers have.
 */
package coe528.lab1;

/**
 *
 * @author Syed Yousuf
 */
public abstract class Passenger 
{
    // Instance Variables
    protected String name;
    protected int age;
    
    // Constructors 
    
    /*
    * A default constructor that initializes the instance variables
    *
    *@param name The name of the passenger
    *@param age The age of the passenger
    */
    public Passenger(String name, int age)
    {
        this.name = name;
        this.age = age;
    }
    
    // Getter methods 
    
    /*
    * Get the name of the passenger
    *
    *@return name
    */
    public String getName()
    {
        return name;
    }
    
    /*
    * Get the age of the passenger
    *
    *@return age
    */
    public int getAge()
    {
        return age;
    }
    
    // Setter methods 
    
    /*
    * Sets the value of name
    *
    *@param name The name of the passenger
    */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /*
    * Sets the value of age
    *
    *@param age The age of the passenger
    */
    public void setAge(int age)
    {
        this.age = age;
    }
    
    /*
    * Apply the discount to this ticket. In the subclasses, the overrided method will return a
    * price after applying the discount.
    *
    *@param p The price of the ticket
    */
    public abstract double applyDiscount(double p);

}