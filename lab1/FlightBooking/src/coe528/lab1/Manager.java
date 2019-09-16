/*
 * Manages the flights of a specific airline. 
 */
package coe528.lab1;

/**
 *
 * @author Syed Yousuf
 */
public class Manager 
{
    // Instance Variables
    Flight [] flights;
    Ticket [] tickets;
    
    
    // Constructors
    
    /*
    * A default constructor that initialize the ticket arrays.
    *
    *@param totalTickets The total number of tickets in print
    */
    public Manager(int totalTickets)
    {
        // Local Variables
        int indexNumber;
        
        tickets = new Ticket[totalTickets];
        
        
    }
    
    
    // Methods
    
    /*
    * Creates a specified array of flights. 
    * Each flight will have a unique number that will be incrementing in chronological order.
    * Each flight will go from  Toronto to Karachi at the same time. 
    *
    *@param numberOfFlights The number of flights that needs to be created.
    */
    public void createFlights(int numberOfFlights)
    {
        // Local Variables
        int indexNumber;
        
        flights = new Flight[numberOfFlights];
        
        // Create each of the flight objects
        for(indexNumber = 0; indexNumber < numberOfFlights; indexNumber++)
        {
            flights[indexNumber] = new Flight(indexNumber);
        }
        
    }
    
    /*
    * Displays all the available flights from origin to destination. It will only 
    * display those flights that are not yet fully booked.
    *
    *@param origin The origin value of the flights we want to display
    *@param destination The destination value of the flights we want to display
    */
    public void displayAvailableFlights(String origin, String destination)
    {
        // Local Variable
        int indexNumber;
        
        for(indexNumber = 0; indexNumber < flights.length; indexNumber++)
        {
            // Check if the flight has the same origin and destination values.
            if(flights[indexNumber].getOrigin().equals(origin) && flights[indexNumber].getDestination().equals(destination))
            {
                // Check if this flight has been booked or not. 
                if(flights[indexNumber].getNumberOfSeatsLeft() > 0)
                {
                    // Only display those flights which have not been fully booked.
                    System.out.println(flights[indexNumber]);
                }
            }
        }
    }
    
    /*
    * Get the flight object for the specified flight Number
    *
    *@param flightNumber The specified flight number 
    @return flightObject
    */
    public Flight getFlight(int flightNumber)
    {
        return flights[flightNumber];
    }
       
    
    /*
    * Get the specific ticket
    *
    *@param ticketNumber The number of the specific ticket we want
    */
    public Ticket getTickets(int ticketNumber) 
    {
        return tickets[ticketNumber];
    }
    
    
    
    
    /*
    * Book a seat in the specified flight number. Apply discount, if possible, for the passenger
    *
    *@param flightNumber The flight number of the flight that is attempting to be booked
    *@param p The passenger that is trying to book a seat
    */
    public void bookSeat(int flightNumber, Passenger p)
    {
        // Local Variables
        Flight FlightWanted = null;
        boolean flightExists = false; 

        // Check if the flight of the flight number exists
        try
        {
            FlightWanted = flights[flightNumber];
            flightExists = true;
        }
        catch(IllegalArgumentException e)
        {
            // Do nothing.
        }
        
        // If flight exists, book a seat
        if(flightExists)
        {
            if(FlightWanted.bookASeat())
            {
                // If the booking was successful. Apply the discount and issue a new ticket.
                tickets[flightNumber] = new Ticket(p, FlightWanted, p.applyDiscount(FlightWanted.getOriginalPrice()));
            }
        }
        
        
    }
    
    public static void main(String[]args)
    {
        Manager m = new Manager(1000000);
        m.createFlights(5);
        m.displayAvailableFlights("Toronto", "Karachi");
        
        Member bob = new Member("Bob", 21, 20);
        m.bookSeat(0, bob);
        m.bookSeat(0, bob);
        m.bookSeat(0, bob);
        m.bookSeat(0, bob);
        m.bookSeat(0, bob);
        
        
        System.out.println(m.getTickets(0));
        
        m.displayAvailableFlights("Toronto", "Karachi");
        
        
    }
}
