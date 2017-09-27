import java.util.Scanner;
public class RecursivePalindromes 
{
	//Recursive Method
    public static boolean PalindromeCheck(String chars)
    {   
    	/**
    	* If length is null (0 characters) or 1 character then String is 
    	* immediately considered a palindrome without actually calling
    	* the checking method
    	*/
       if(chars.length() == 0 || chars.length() == 1)
        {
            return true;
        }
        
        if(chars.charAt(0) == chars.charAt(chars.length()-1))
        {
        
        /** Check for first and last character of the word/phrase entered:
         * If they are same then do the same thing for a substring
         * with the first and last character removed. The function recalls itself
         * until the string is completed or a condition fails
         */
        	return PalindromeCheck(chars.substring(1, chars.length()-1));
        }

        /** If the program reaches this statement
         * the word/phrase is not a palindrome 
         * and returns false.
         */
        return false;
    }

    //Main Method
    public static void main(String[]args)
    {
    	//Calling scanner
        Scanner keyboard = new Scanner(System.in);
        //User prompt
        System.out.println("Enter a string of characters and the "
        		+ "computer \nwill check whether or not it is a"
        		+ " palindrome: ");
        
        //Capturing word/phrase entered
        String Char = keyboard.nextLine();
        
        //Ignoring white spaces, tabs, blanks, etc.
        Char.replaceAll("\\s+",""); 
        	   
        //Calling recursive method defined above main method       
        if(PalindromeCheck(Char.replaceAll("\\s+","").toLowerCase().trim()))
        {
        	System.out.println("");
            System.out.println("The string " +"'"+Char+"'" + " is a palindrome");
        }
        
        /*Recursive method was called above but the word/phrase did not meet the
         * requirements to be a palindrome 
        */
        else
        {
        	System.out.println("");
            System.out.println("The string " +"'"+Char+"'" + " is not a palindrome");
        }
        
    }
    
}
