import java.util.Random;
import java.util.Scanner;
public class SortingAlgos {
	
	//Counters
	public static int selectionSort = 0;
	public static int bubbleSort = 0;
	public static int mergeSort = 0;
	public static int quickSort = 0;


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Integer counter, counting the total number of times the algorithms are run
		int times = 0;

	/**
	 * This "for" loop cycles through the algorithms 
	 * and runs all 4 of them a total of 20 times
	 */
	for(int b=0; b<20; b++)
	{
		//Integer array of size 1000
		int[] array = new int[1000];
				
		//Java randomizer
		Random Gen = new Random();
		
		System.out.println("Random array");
		
		//Populating the array randomly
		for(int i = 0; i<array.length; i++)
		{
			System.out.println(array[i] = Gen.nextInt(1000));
		}
		
		System.out.println("Selection sorting array...");
		
		//Call SS and sort the array
		selectionSort(array);
		
		//Print the results
		for(int i = 0; i<array.length; i++)
		{
			System.out.println(array[i]);
		}
		
		
		System.out.println("Random array");
		
		//Initializing new array
		int[] array2 = new int[1000];
		
		//Populating the array randomly
		for(int i = 0; i<array2.length; i++)
		{
			System.out.println(array2[i] = Gen.nextInt(1000));
		}
		System.out.println("Bubble sorting array...");
		
		//Call BS and sort array
		bubbleSort(array2);
		
		//Print results
		for(int i = 0; i<array2.length; i++)
		{
			System.out.println(array2[i]);
		}
		
		System.out.println("Random array");
		
		//Initializing new array
		int[] array3 = new int[1000];
		
		//Populating the array randomly
		for(int i = 0; i<array3.length; i++)
		{
			System.out.println(array3[i] = Gen.nextInt(1000));
		}
		System.out.println("Merge sorting array...");
	
		//Calling MS and printing results
		mergeSort(array3);
		//Print results
		for(int i = 0; i<array3.length; i++)
		{
			System.out.println(array3[i]);
		}
		
		System.out.println("Random array");
		
		//Initializing new array
		int[] array4 = new int[1000];
		//Populating array randomly
		for(int i = 0; i<array4.length; i++)
		{
			System.out.println(array4[i] = Gen.nextInt(1000));
		}
		
		
		System.out.println("Quick sorting array...");
		//Initializing parameters from QS and then calling that method
		int left=0;
		int right = array4.length-1;
		
		
		quickSort(array4,left,right);
		
		//Print results
		for(int i = 0; i<array4.length; i++)
		{
			System.out.println(array4[i]);
		}
		
		//Spacing and updating "for" loop visible counter
		System.out.println("");
		times++;
		System.out.println("All algorithms have been run "+times +" time(s)");
		System.out.println("");
		
	}
		//THE TASK IS COMPLETE!!!
		System.out.println("DONE!");
		System.out.println("");
		
		//Printing averages
		System.out.println("The average number of checks for selection sorting was: "+selectionSort/20);
		System.out.println("The average number of checks for bubble sorting was: "+bubbleSort/20);
		System.out.println("The average number of checks for merge sorting was: "+mergeSort/20);
		System.out.println("The average number of checks for quick sorting was: "+quickSort/20);
				
	}
	
	
	//BUBBLE SORT METHOD
	public static int[] bubbleSort(int [] array2)
	{
		
		boolean done = false;
		
		//Array.length 
		int n = array2.length;
		while(done == false)
		{
			done = true;
			for(int i=0; i<n-1; i++) //Minus one avoids out of bounds exception
			{
				//Out of order... SWAP
				if(array2[i]>array2[i+1])
				{
					bubbleSort++;
					//Temporary value at i is stored
					int temp = array2[i];
					array2[i] = array2[i+1];
					array2[i+1] = temp;
					done = false;
					
					
				}
				
			}
		}
		return array2;
		
	}
	
	
	
	
		//MERGE SORT METHOD
		public static void mergeSort(int [] array3)
		{
			int size = array3.length;
			
			if(size < 2) //HALTING CONDITION AND RETURN
			{
				return;
			}
			int mid = size / 2;
			
			int leftSize = mid;
			int rightSize = size - mid;
			int [] left = new int[leftSize];
			int [] right = new int[rightSize];
			
			//Populate left
			for(int i=0; i<mid; i++)
			{
				left[i] = array3[i];
				
			}
			
			//Populate right
			for(int i=mid; i<size; i++)
			{
				right[i-mid] = array3[i];
				
				
			}
			mergeSort(left);
			mergeSort(right);
			
			
			
			//Merge
			merge(left, right, array3);
			
			
			
		}
		
		//The merging function
		public static void merge(int [] left, int [] right, int [] array3)
		{
			int leftSize = left.length;
			int rightSize = right.length;
			int i = 0; //Index for left
			int j = 0; //Index for right
			int k = 0; //Index for array
			
			while(i<leftSize && j<rightSize) //Compares until the end is reached in either 
			{
				if(left[i] <= right [j])
				{
					
					array3[k] = left[i];
					i++;
					k++;
					mergeSort++;
					
					
				}
				else
				{
					
					array3[k] = right[j];
					j++;
					k++;
					
				}
			}
			//Fills in the rest
			while(i<leftSize)
			{
				
				array3[k] = left[i];
				i++;
				k++;
				
				
			}
			
			while(j<rightSize)
			{
				
				array3[k] = right[j];
				j++;
				k++;
				
				
			}
			
			
		}
	
	
	
	//QUICK SORTING METHOD
	public static void quickSort(int [] array4, int left, int right)
	{
		
		int index = partition(array4, left, right);
		if(left < index - 1)
		{
			quickSort(array4, left, index-1);
		}
		
		if(index < right)
		{
			
			quickSort(array4, index, right);
			
			
		}
	}
	
	//Partition Function
	public static int partition(int [] array4, int left, int right)
	{
		int i = left;
		int j = right;
		
		//Making the pivot the center element
		int pivot = array4[(left+right)/2];
		
		while(i<=j)
		{
			while(array4[i] < pivot)
			{
				
				i++; //Correct position so move forward
				quickSort++;
			}
				while(array4[j] > pivot)
				{
					
					j--; //Correct position
				}
					if(i<=j)
					{
						int temp = array4[i];
						array4[i] = array4[j];
						array4[j] = temp;
						i++;
						j--;
						quickSort++;
					}
		}
		return i;
	}
	
	
	
	
	
	//SELECTION SORTING METHOD
	public static void selectionSort(int [] array)
	{
	         
	        for (int i = 0; i < array.length - 1; i++)
	        {
	            int index = i;
	            for (int j = i + 1; j < array.length; j++)
	            {
	                
	            	if (array[j] < array[index])
	                {
	            		selectionSort++;
	                    index = j;
	                }
	            }
	      
	            int smallerNumber = array[index]; 
	            array[index] = array[i];
	            array[i] = smallerNumber;
	            
	        }
	        return;
	}
		
		
		
}
	