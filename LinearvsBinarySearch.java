import java.util.Random;
import java.util.Arrays; 
public class LinearvsBinarySearch {
	
	public static int linearSearchCount = 0;
	public static int binarySearchCount = 0;

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		//Integer array of size 1000
		int[] array = new int[1000];
		
		//Java randomizer
		Random r = new Random();
		
		//Running count
		int numberOfRuns = 0;		
		
		int LinearCount = 0;
		int BinaryCount = 0;
		//User prompt
		System.out.println("Welcome to the search tester. We are going to see which algorithm performs the best out of 20 tests");
		
		
		//Running the binary and linear searching methods 20 times
        while(numberOfRuns < 20)
	       {
           		linearSearchCount = 0;
        		binarySearchCount = 0;
        		for(int i = 0; i<array.length; i++)
        		{
        			array[i] = r.nextInt(1000);
        			Arrays.sort(array);
        		}
	        	
        		//Calling methods
        		int Array = r.nextInt(1000);
        		System.out.println("Searching using linear search...");
        		linearSearchRecursive(array, Array, 0);
        		System.out.println("Searching using binary search...");
        		binarySearchRecursive(array, Array, 0, 999);
        		
        		//Printing results of counts
        		System.out.println("Linear checks: "+linearSearchCount);
        		System.out.println("Binary checks: "+binarySearchCount);
        		
        		//Counting the number of times while loop runs
		        LinearCount += ((int) linearSearchCount);
		        BinaryCount += ((int) binarySearchCount);
		        numberOfRuns++;
		        
	       }
	       
        	//Printing averages
           System.out.println("The average number of linear searches was "+LinearCount/20);
	       System.out.println("The average number of binary searches was "+BinaryCount/20);
	       

		
	}
	
	
	
	//Recursive algorithm
		public static boolean linearSearchRecursive(int [] array, int value, int index)
		{
			if(array[index] == value)
			{
				linearSearchCount++;
				System.out.println("Found!");
				return true;
			}
			else
			{
				index++;
				if(index >= array.length)
				{
					linearSearchCount++;
					System.out.println("Not found!");
					return false;
				}
				else
				{
					linearSearchCount++;
					return linearSearchRecursive(array,value,index);
				}
			}
		}

		//Binary recursive algorithm
		public static boolean binarySearchRecursive(int [] array, int value, int minIndex, int maxIndex)
		{
			int midIndex = (maxIndex+minIndex)/2;
			
			if(minIndex > maxIndex)
			{
				
				System.out.println("Not found!");
				return false;
			}
			if(array[midIndex] == value)
			{
				binarySearchCount++;
				System.out.println("Found!");
				return true;
			}
			else
			{
				//Searches the top half
				if(value > array[midIndex])
				{
					binarySearchCount++;
					return binarySearchRecursive(array, value, midIndex+1, maxIndex);
				}
				//Searches bottom half
				else
				{
					binarySearchCount++;
					return binarySearchRecursive(array, value, minIndex, midIndex-1);
				}
			}
			
	}

}

