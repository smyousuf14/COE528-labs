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
        
        
    }
    
    
    public static void main(String[]args)
    {
        Flight f1 = new Flight(1, "Toronto", "Karachi", "03/03/2020 10:10 pm", 1000, 12000);
        NonMember m1 = new NonMember("Bob", 66);
        Ticket t1 = new Ticket(m1, f1, 1200);
        
        System.out.println(m1.applyDiscount(100));
        
    }
}
