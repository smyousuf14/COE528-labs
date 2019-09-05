/*
 * Each object of this class represents a flight. 
 */
package lab1;

/**
 *
 * @author Syed Yousuf
 */
public class Flight 
{
    // Instance variables
    private int flightNumber;
    private String origin;
    private String destination;
    private String departureTime;
    private int capacity;
    private int numberOfSeatsLeft;
    private double originalPrice;
    
    /*
    * Default Constructor which initializes six of the instance variables.
    *
    *@param flightNumber The flight number
    *@param origin Where the flight will start from
    *@param destination The location the flight will go to
    *@param capacity The total capacity of the flight
    *@param originalPrice The original price of the flight
    */
    public Flight(int flightNumber, String origin, String destination, String departureTime,
            int capacity, double originalPrice)
    {
        // Initialize all the instance variables
        this.flightNumber = flightNumber;
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.capacity = capacity;
        this.originalPrice = originalPrice;
        
        // Initialize numberOfSeatsLeft
        numberOfSeatsLeft = capacity;
        
        // Check for errors
        if(origin.equals(destination))
        {
            throw new IllegalArgumentException("Origin and destination can not be same.");
        }
    }
    
    // Getters
    
    /*
    * Gets flightNumber
    *
    *@return flightNumber
    */
    public int getFlightNumber()
    {
        return flightNumber;
    }
    
    /*
    * Gets origin
    *
    *@return origin
    */
    public String getOrigin()
    {
        return origin;
    }
    
    /*
    * Gets the value of destination
    *
    *@return destination
    */
    public String getDestination()
    {
        return destination;
    }
    
    /*
    * Gets the value of departureTime
    *
    *@return departureTime
    */
    public String getDepartureTime()
    {
        return departureTime;
    }
    
    /*
    * Gets the capacity
    *
    *@return capacity
    */
    public int getCapacity()
    {
        return capacity;
    }
    
    /*
    * Gets the number of seats avaliable
    *
    *@return numberOfSeatsLeft
    */
    public int getNumberOfSeatsLeft()
    {
        return numberOfSeatsLeft;
    }
    
    /*
    * Gets the originalPrice 
    *
    *@return originalPrice
    */
    public double getOriginalPrice()
    {
        return originalPrice;
    }
    
    
    // Setter methods
    
    /*
    * Set the flight number
    *
    *@param flightNumber
    */
    public void setFlightNumber(int flightNumber)
    {
        this.flightNumber = flightNumber;
    }
    
    /*
    * Set the origin
    *
    *@param origin
    */
    public void setOrigin(String origin)
    {
        this.origin = origin;
    }
    
    /*
    * Set the destination
    *
    *@param destination
    */
    public void setDestination(String destination)
    {
        this.destination = destination;
    }
    
    /*
    * Set the Departure Time
    *
    *@param departureTIme
    */
    public void setDepartureTime(String departureTime)
    {
        this.departureTime = departureTime;
    }
    
    /*
    * Set the capacity
    *
    *@param capacity
    */
    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }
    
    /*
    * Set the number of seats avaliable
    *
    *@param numberOfSeatsLeft
    */
    public void numberOfSeatsLeft(int numberOfSeatsLeft)
    {
        this.numberOfSeatsLeft = numberOfSeatsLeft;
    }
    
    /*
    * Set the originalPrice
    *
    *@param originalPrice
    */
    public void setOriginalPrice(double originalPrice)
    {
        this.originalPrice = originalPrice;
    }
    
    // Other methods
    
    /*
    * Book a seat on the flight
    *
    *@return ifBookedASeat
    */
    public boolean bookASeat()
    {
        // Local Variable List
        boolean bookedSeatSuccess = false;
        
        // Check if there are seats avaliable
        if(numberOfSeatsLeft > 0)
        {
            // Book a seat
            numberOfSeatsLeft--;
            bookedSeatSuccess = true;
        }
        
        return bookedSeatSuccess;
    }
}
