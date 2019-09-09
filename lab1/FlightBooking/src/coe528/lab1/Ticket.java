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
    * A string representation of the Ticket class
    *
    *@return stringRepresentation
    */
    public String toString()
    {
        return passenger + ", " + flight.getFlightNumber() + ", " + flight.getOrigin() + " to " + flight.getDestination() 
              + ", "   + flight.getDepartureTime() + ", original price: " + flight.getOriginalPrice() + ", ticket price: $" + flight.getOriginalPrice();
    }
    
    public static void main(String[]args)
    {
        Flight test1 = new Flight(1030, "Toronto", "Karachi", "03/02/99 8:50 pm", 10, 2500);
        //test this class
    }
    
}
