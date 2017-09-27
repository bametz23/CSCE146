/**
 * Written by Bailey Metz
 */

//importing the java scanner and randomizer
import java.util.Scanner;
import java.util.Random;
public class DoubleMatrix {
	
	/*Static final integer that sets the maximum digit for the number randomizer.
	 * The instructions for the program were to allow the program to randomly
	 * select numbers between 0-9.
	 */
	public static final int UPPER_NUMBER = 10;

	//Main method of the program
	public static void main(String[] args) 
	{
		//Implementing the scanner to receive user input
		Scanner keyboard = new Scanner(System.in);
	/*	
	  	Implementing the java number randomizer to randomly 
		select numbers based on the size of the matrix entered
		by the user
	*/
		
		Random q = new Random();
		boolean decision = true;
	
		//Program greeting
		System.out.println("Welcome to the matrix doubling program!!");
		
		//'While' loop allowing the user to use the program 
		//multiple times without clicking restart
		while(decision == true)
	{
			
		//User prompt
		System.out.println("Please enter the size of the matrix you'd like to see doubled.");
		//Storing user input
		int size = keyboard.nextInt();
		keyboard.nextLine();
		
		//Matrix construction
		int firstMatrix[] [] = new int[size] [size];
		for (int i=0; i<size; i++)
		{
			
			for (int j=0; j<size; j++)
			{
				//Randomizing the matrix digits
				int matrixSpace = q.nextInt(UPPER_NUMBER);
				firstMatrix[i][j] = matrixSpace;
			}
		}
		
		//Printing out the matrix
		System.out.println("The matrix is:");
		for (int i=0; i<size; i++)
		{
			for(int j=0; j<size; j++)
			{
				System.out.print(firstMatrix[i][j] + "   ");
			}
			//Proper spacing
			System.out.println("");

		}
		
		//Printing out the matrix doubled)
		System.out.println("The doubled matrix is:");
		int secondMatrix[] [] = new int[size] [size];
		
		for (int i=0; i<size*2; i++)
		{
			for (int j=0; j<size*2; j++)
			{
				System.out.print(firstMatrix[i/2][j/2] + "   ");
			}
			//Proper spacing
			System.out.println("");
			
		}
		
		System.out.println("SUCCESS!!");
		
		//Prompting the user to rerun the program
		System.out.println("Would you like to double another matrix?");
		
		//Capturing the response
		String answer = keyboard.nextLine();
		
		//Validating the response given
		if(answer.equalsIgnoreCase("No"))
		{
			//User decided to quit and so the program terminates
			//itself after giving a formal dismissal 
			decision = false;
			System.out.println("GOODBYE");
		}
		
	}	
		

   }

}
