import java.util.Scanner;
import java.util.*;
public class SortingAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Calling built in ARRAY LISTS
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		for(int i=0; i<10; i++)
		{
			arrList.add(i);
		}
		for(int i : arrList)
		{
			System.out.println(i);
		}
		arrList.get(4);
		
		
		
		//Calling built in QUEUES
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i=0; i<10; i++)
		{
			q.add(i); //Enqueue
		}
		while(q.isEmpty() == false)
		{
			System.out.println(q.remove()); //Dequeue
		}
		
		
		
		//Calling built in STACKS
		Stack<Integer> stack = new Stack<Integer>();
		for(int i=0; i<10; i++)
		{
			stack.push(i);
		}
		while(stack.isEmpty() == false)
		{
			System.out.println(stack.pop());
		}
	}
	
	//BUBBLE SORT METHOD
	public static int[] bubbleSort(int [] array)
	{
		
		boolean done = false;
		
		//Array.length 
		int n = array.length;
		while(done == false)
		{
			done = true;
			for(int i=0; i<n-1; i++) //Minus one avoids out of bounds exception
			{
				//Out of order... SWAP
				if(array[i]>array[i+1])
				{
					
					//Temporary value at i is stored
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					done = false;
					
					
				}
				
			}
		}
		return array;
		
	}
	
	
	
	//MERGE SORTING "RECURSIVE"
	/**public static void mergeSort(int [] array, int left, int right)
	{
		int mid;
		
		//SPLITTING AND MERGING NEED TO CONTINUE
		if(right > left)
		{
			//Determining midpoint
			mid = (right+left)/2;
			mergeSort(array,left,mid); //Left side
			mergeSort(array,mid+1,right);//Right side
			
			//Merge!
			doMerge(array,left,mid+1,right);
			
			
			
		}
	}
	
	//THE MERGING FUNCTION
	public static void doMerge(int[] array, int left, int mid, int right)
	{
		int [] temp = new int[array.length];
		int left_end = (mid-1);
		int tmp_pos = left;
		int num_elements = (right - left + 1);
		
		
		while(	(left <= left_end) && (mid <= right)	)
		{
			
				
			if(	array[left] <= array[mid]	)
			{
				temp[tmp_pos++] = array[left++];
			}
			else
			{
				temp[tmp_pos++] = array[mid++];
			}
		}
		//Left over elements
		while(left < left_end) //left over elements in the left part of the array
		{
			temp[tmp_pos++] = array[left++];
		}
		
		while(mid <= right)
		{
			temp[tmp_pos++] = array[mid++];
		}
		
		//Modify initial array
		for(int i=0; i<num_elements; i++)
		{
			array[right] = temp[right];
			right--;
		}
	}
	
	*/
	
	//Merge Sort
	public static void mergeSort(int [] array)
	{
		int size = array.length;
		
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
			left[i] = array[i];
		}
		
		//Populate right
		for(int i=mid; i<size; i++)
		{
			right[i-mid] = array[i];
		}
		mergeSort(left);
		mergeSort(right);
		
		//Merge
		merge(left, right, array);
		
	}
	
	public static void merge(int [] left, int [] right, int [] array)
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
				array[k] = left[i];
				i++;
				k++;
			}
			else
			{
				array[k] = right[j];
				j++;
				k++;
				
			}
		}
		//Fills in the rest
		while(i<leftSize)
		{
			array[k] = left[i];
			i++;
			k++;
		}
		
		while(j<rightSize)
		{
			array[k] = right[j];
			j++;
			k++;
		}
		
		
	}
	
	
	
	
	
	//QUICK SORTING FUNCTION
	public static void quickSort(int [] array, int left, int right)
	{
		
		int index = partition(array, left, right);
		if(left < index - 1)
		{
			
			quickSort(array, left, index-1);
		}
		if(index < right)
		{
			
			quickSort(array, index+1, right);
			
		}
	}
	
	//Partition Function
	public static int partition(int [] array, int left, int right)
	{
		int i = left;
		int j = right;
		
		//Making the pivot the center element
		int pivot = array[(left+right)/2];
		
		while(i<=j)
		{
			while(array[i] < pivot)
			{
				i++; //Correct position so move forward
			}
				while(array[j] > pivot)
				{
					j--; //Correct position
				}
					if(i<=j)
					{
						int temp = array[i];
						array[i] = array[j];
						array[j] = temp;
						i++;
						j--;
					}
		}
		return i;
	}
	
	
	//SELECTION SORTING METHOD
	public static void selectionSort(int [] array)
	{
		
		     for (int i = array.length-1; i > 0; i--)  
		     {
		         int first = 0;   //initialize to subscript of first element
		          for(int j = 1; j <= i; j++)   //locate smallest element between positions 1 and i.
		          {
		               if(array[j] < array[first])         
		                 first = j;
		          }
		          
		          
		          int temp = array[first];   //swap smallest found with element in position i.
		          array[first] = array[i];
		          array[i] = temp;
		          
		      }           
		
		
		
	}
	
	
	
	

}
