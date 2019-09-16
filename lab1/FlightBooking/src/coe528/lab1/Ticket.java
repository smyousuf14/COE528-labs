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
    private int number = 0;
    
    private static int numberOfTickets = 0;
    
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
        
        // Set the ticket number
        numberOfTickets++;
        number = numberOfTickets;
    }
    
    // Setter methods
    
    /*
    * Set the passenger value
    *
    *@param passenger The passenger of this ticket
    */
    public void setPassenger(Passenger passenger)
    {
        this.passenger = passenger;
    }
    
    /*
    * Set the value of the flight.
    *
    *@param flight The flight associated with this ticket
    */
    public void setFlight(Flight flight)
    {
        this.flight = flight;
    }
    
    /*
    * Set the price value
    *
    *@param price The price of this ticket
    */
    public void setPrice(double price)
    {
        this.price = price;
    }
    
    /*
    * Set the value of the number
    *
    *@param number The new value of number
    */
    public void setNumber(int number)
    {
        this.number = number;
    }
    
    
    // Getter methods
    
    /*
    * Get the value of passenger
    *
    *@return passenger
    */
    public Passenger getPassenger()
    {
        return passenger;
    }
    
    /*
    * Get the flight of this ticket
    *
    *@return flight
    */
    public Flight getFlight()
    {
        return flight;
    }
    
    /*
    * Get the price of this ticket
    *
    *@return price
    */
    public double getPrice()
    {
        return price;
    }
    
    /*
    * Get the value of number
    *
    *@return number
    */
    public int getNumber()
    {
        return number;
    }
    
    /*
    * A string representation of the Ticket class
    *
    *@return stringRepresentation
    */
    public String toString()
    {
        return passenger.getName() + ", " + flight.getFlightNumber() + ", " + flight.getOrigin() + " to " + flight.getDestination() 
              + ", "   + flight.getDepartureTime() + ", original price: " + flight.getOriginalPrice() + ", ticket price: $" + price;
    }
    
}
