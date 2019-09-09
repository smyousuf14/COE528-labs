/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Syed Yousuf
 */
public class TestFlight 
{
    /*
    * Test the method with valid arguments
    */
    @Test
    public void testConstructor()
    {
        Flight test1 = new Flight(1030, "Toronto", "Karachi", "03/02/99 8:50 pm", 10, 2500);
        
    }
    
    /*
    * Test the method with invalid arguments
    */
    @Test
    public void testInvalidConstructor()
    {
        // Local Variable List
        boolean exceptionThrown = false;
        
        try
        {
            Flight test2 = new Flight(2040, "Toronto", "Toronto", "03/02/99 8:50 pm", 200, 1000);
        }
        catch(IllegalArgumentException e)
        {
            exceptionThrown = true;
        }
        
        assertTrue(exceptionThrown);
    }
    
    /*
    * Test all public methods, geters, setters, and toString() method
    */
    @Test
    public void testAllMethods()
    {
        Flight test3 = new Flight(1030, "Toronto", "Karachi", "03/02/99 8:50 pm", 10, 2500);
        test3.bookASeat();
        System.out.println(test3);
        
        // Test all the setters
        test3.setCapacity(900);
        test3.setDepartureTime("03/03/2020 10:10 pm");
        test3.setDestination("Jeddah");
        test3.setFlightNumber(900);
        test3.setOrigin("Karachi");
        test3.setOriginalPrice(900);
        System.out.println(test3);
        
        // Test all the geters
        System.out.println(test3.getCapacity());
        System.out.println(test3.getDepartureTime());
        System.out.println(test3.getDestination());
        System.out.println(test3.getFlightNumber());
        System.out.println(test3.getNumberOfSeatsLeft());
        System.out.println(test3.getOriginalPrice());
        System.out.println(test3.getOrigin());
        
        
    }
}
