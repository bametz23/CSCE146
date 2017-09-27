/**  Written by Bailey Metz
	 *
	 *	CODE INCOMPLETE!
	 *	
	 *	Could not get FSort class to print the program by greatest number of Fs in user input
	 *	I tried many different things, but decided to leave the code in its original form
	 *	since everything I tested did not work in sorting the heap correctly.
	 *
	 * 	This program sorts the heap of user input alphabetically instead of by number of Fs
	 *
	 */
	

import java.util.Scanner;
public class FWordsTester {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
				
		System.out.println("Welcome to the F word sorter!  Enter words or phrases and it will sort from least "
				+ "\nnumber of F’s to the most number of F’s.  Enter “Sort” to finish and sort.");
		
		FSort TestSort = new FSort();
		String [] array = new String[100];
		
			for(String i : array)
			{
					String Words = keyboard.nextLine();
					
					if(Words.equalsIgnoreCase("SORT"))
					{
						
						System.out.println("");
						System.out.println("The sorted phrases are");
						System.out.println("");
						
						TestSort.WordsHeapSort();
						
					}
					TestSort.addWords(Words);
					
					
			}
		
		
		
	}

}
