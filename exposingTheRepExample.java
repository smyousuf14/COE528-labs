/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

/**
 *
 * @author Syed Yousuf
 */
public class Df 
{
    public int[] x;
    
    public Df(int[] x)
    {
        this.x = x; // Exposing the Rep
    }
    
    public static void main(String[]args)
    {
        int[] num = {1, 3, 4};
        
        Df a = new Df(num);
        
        System.out.println(a.x[1]); // outputs 3
        
        num[1] = 10;
        
        System.out.println(a.x[1]); // outputs 10!!
    }
}
