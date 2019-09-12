/*
 * This class represents a passenger who is not a frequent flyer member. 
 */
package coe528.lab1;

/**
 *
 * @author Syed Yousuf
 */
public class NonMember extends Passenger
{
    // Instance Variables
    
    // Constructors
    /*
    * This is a default contructor which creates a nonmember object
    *
    *@param name The name of the nonmember
    *@param age The age of the nonmember
    */
    public NonMember(String name, int age)
    {
        super(name, age);
    }
    
    
    // Methods
    
    /*
    *Apply the discount to this ticket. In the subclasses, the overrided method will return a
    * price after applying the discount.
    *
    *@param p The price of the ticket
    */
    @Override
    public double applyDiscount(double p)
    {
        // Local variables
        double priceAfterDiscount;
        
        // Check the age and then apply appropriate discount
        if(age > 65)
        {
            priceAfterDiscount = p - (p * 0.10);
        }
        else
        {
            // No discount is applied.
            priceAfterDiscount = p;
        }
        
        return priceAfterDiscount;
    }
    
}
