
public class SearchingAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		

	}
	//Linear searching algorithm ("FOR" LOOP METHOD) 
	public static boolean linearSearchIterative(int [] a, int value)
	{
		for(int i=0; i<a.length; i++)
		{
			if(a[i] == value)
			{
				return true;
			}
		}
		return false;
	}
	
	//Recursive searching algorithm
	public static boolean linearSearchRecursive(int [] a, int value, int index)
	{
		if(a[index] == value)
		{
			return true;
		}
		else
		{
			index++;
			if(index >= a.length)
			{
				return false;
			}
			else
			{
				return linearSearchRecursive(a,value,index);
			}
		}
	}
	public static boolean binarySearchRecursive(int [] a, int value, int minIndex, int maxIndex)
	{
		int midIndex = (maxIndex+minIndex)/2;
		if(minIndex > maxIndex)
		{
			return false;
		}
		if(a[midIndex] == value)
		{
			return true;
		}
		else
		{
			//Searches the top half
			if(value > a[midIndex])
			{
				return binarySearchRecursive(a, value, midIndex+1, maxIndex);
			}
			//Searches bottom half
			else
			{
				return binarySearchRecursive(a, value, minIndex, midIndex-1);
			}
		}
	}
	
	/**
	 * O(1) - Constant
	 * O(log(n)) - Logarithmic
	 * 0(n) - Linear
	 * O(nlogn) Lineararithmic
	 * O(n^2) - Quadratic
	 * O(2^n) - Exponential "Bad"
	 * O(n!) - Factorial "Really bad"
	 */
	

}
