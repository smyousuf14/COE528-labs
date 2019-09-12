/*
 * This class represents a frequent flyer member.
 */
package coe528.lab1;

/**
 *
 * @author Syed Yousuf
 */
public class Member extends Passenger
{
    // Instance Variables
    private int yearsOfMembership;
    
    
    // Constructor
    
    /*
    * Default constructor for creating a member
    *
    *param name The name of the member
    *@param age The age of the member
    *@param yearsOfMembership The amount of years this person has been a member
    */
    public Member(String name, int age, int yearsOfMembership)
    {
        super(name, age);
        this.yearsOfMembership = yearsOfMembership;
    }
    
    // Methods 
    /*
    * Apply the discount to this ticket. In the subclasses, the overrided method will return a
    * price after applying the discount.
    *
    *@param p The price of the ticket
    */
    @Override 
    public double applyDiscount(double p)
    {
        // Local variables
        double priceAfterDiscount;
        
        // Check the number of years of membership and apply appropriate discount.
        if(yearsOfMembership > 5)
        {
            priceAfterDiscount = p * 0.5;
        }
        else
        if(yearsOfMembership > 1 && yearsOfMembership <= 5)
        {
            priceAfterDiscount = p  - (p * 0.10);
        }
        else
        {
            // No discount
            priceAfterDiscount = p;
        }
        
        return priceAfterDiscount;
        
    }
    
    
}
