import java.util.Scanner;
public class RecursionTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner keyboard = new Scanner(System.in);
	}
	
	public static int factorial(int number)
	{
		if(number == 0)  //Stop condition
		{
			return 1;
			
		}
		else
		{
			return number * factorial(number-1); //recursive call
		}
	}
	
	public static int gcd(int num1, int num2)
	{
		if(num2 == 0) //halting condition
		{
			return num1;
		}
		else
		{
			return gcd(num2, num1 % num2); //Recursive call
		}
	}
	
	/**
	 * ===== Fibonacci Number / Sequence =======
	 * 
	 * A series of numbers whose value is the sum 
	 * of the two values that preceded it
	 */
	
	public static int fibonacci(int number)
	{
		if(number == 1 || number == 2)
		{
			return 1;
		}
		else
		{
			return fibonacci(number-1 + fibonacci(number-2));
		}
	}
	
	/**
	 * ===== Selection Sort using recursion =====
	 * 
	 * int [] a = index | 0 | 1 | 2 | 3 | 4 |
	 * 			 values | 8 | 3 | 4 | 2 | 0 |
	 * 
	 * 			after cycling through one time....
	 *
	 *            index | 0 | 1 | 2 | 3 | 4 |
	 *           values | 0 | 3 | 4 | 2 | 8 |
	 */
	
	public static int[] recursiveSelectionSort(int [] arr,
												int startIndex, 
												int smallestIndex, 
												int currIndex)
	{
		if(startIndex >= arr.length) //Check if we are done
		{
			return arr; //Array is already sorted
		}
		if(currIndex >= arr.length) //Check if tge current iteration is done
		{
			if(startIndex != smallestIndex) //There was a smaller value found
			{
				//SWAP
				int temp = arr[smallestIndex];
				arr[startIndex] = arr[smallestIndex];
				arr[smallestIndex] = temp;
			}
			startIndex++;
			return recursiveSelectionSort(arr,startIndex, startIndex, startIndex+1);
		}
		else //still looking for a smaller value
		{
			if(arr[smallestIndex] > arr[currIndex])
			{
				smallestIndex = currIndex;
			}
			return recursiveSelectionSort(arr,startIndex, smallestIndex, currIndex+1);
		}
	}
	
	/** LAB NOTES/HINTS...
	 * keep track of last index... lastIndex-1 ---> currIndex-1 ===== replace above values 
	 */

}
