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
    
}
