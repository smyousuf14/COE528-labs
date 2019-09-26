/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coe528.lab2;

/**
 * A Palindrome is a word the reads the same way backwards as it does forwards.
 * @author Syed Yousuf
 */
public class Palindrome 
{
    
    // Requires: a can not be null and a can not be empty
    // Effects: Checks if the string is a palindrome and return true if it is.    
    public static boolean isPalindrome(String a)
    {
        // Local Variables
        int indexNumber;
        
        int length = a.length();
        boolean APalindrome = true;
        
        // Now lets find the reversal of A.
        for(indexNumber = 0; indexNumber < length; indexNumber++)
        {
            if(a.substring(indexNumber,indexNumber + 1).equals(a.substring(length - indexNumber - 1, length - indexNumber) ))
           {
               // nothing         
           }
           else
           {
               APalindrome = false;
           }     
        }
        
        return APalindrome;
    }
    
     public static void main(String[] args) {

if(args.length == 1) {

    if (args[0].equals("1"))

        System.out.println(isPalindrome(null));

    else if (args[0].equals("2"))

        System.out.println(isPalindrome(""));

    else if (args[0].equals("3"))

        System.out.println(isPalindrome("deed"));

    else if (args[0].equals("4"))

        System.out.println(isPalindrome("abcd"));

        }

    } 
    
}
