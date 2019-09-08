/*
 * The Ticket class represents a flight ticket
 */
package coe528.lab1;

/**
 *
 * @author Syed Yousuf
 */
public class Ticket 
{
    // Instance Variables
    private Passenger passenger;
    private Flight flight;
    private double price;
    
    private static int number = 0;
    
    // Constructors
    /*
    * This is the default constructor that takes in the three main parameters
    *
    *@param p The passenger that this ticket belongs to
    *@param flight The flight that this ticket is registered for
    *@param price The price of this ticket
    */
    public Ticket(Passenger p, Flight flight, double price)
    {
        // Initilize the instance variables
        passenger = p;
        this.flight = flight;
        this.price = price; 
    }
    
    // Setter methods
    
}
