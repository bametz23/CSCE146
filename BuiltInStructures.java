import java.util.*;
public class BuiltInStructures {


	//Main method
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Random r = new Random();//random variable that we use to populate our array


		//Completing the process 3 times
		for(int k=0; k<3; k++)
		{
			ArrayList <Integer> arrList = new ArrayList <Integer>();

			int Size = r.nextInt(10)+10;

			//tells user randomly generated array will print out
			System.out.println("Populating the Array List of Size " +Size);
			System.out.println("This list contains ");

			//Random array with integers from 0-99
			for(int i = 0; i<Size; i++)
			{
				arrList.add(r.nextInt(100));
			}

			//Print them out
			for (int i : arrList)
			{
				System.out.println(i);
			}

			//Call sorting method and print sorted array
			System.out.println("Sorting... ");
			System.out.println("Printing sorted numbers: ");

			quickSort(arrList,0,Size-1);
			for(int i=0; i<Size; i++)
			{
				System.out.println(arrList.get(i));
			}

			//Printing sorted elements in a queue
			System.out.println("Adding elements in the list to a queue ");
			System.out.println("Removing and Printing each element from the Queue ");

			//Initializes queue
			Queue<Integer> q = new LinkedList<Integer>();
			for (int i=0; i<Size; i++)
			{
				//Enqueuing numbers that have been sorted
				q.add(arrList.get(i));
			}
			while(q.isEmpty()==false)
			{
				//Dequeueing sorted numbers
				System.out.println(q.remove());
			}

			//Printing sorted elements in a stack

			System.out.println("Adding elements in the list to a stack ");
			System.out.println("Removing and Printing each element from the Stack ");

			//Initialize stack
			Stack<Integer> stack = new Stack<Integer>();

			//Pushing sorted numbers onto stack
			for (int i=0;i<Size;i++)
			{
				stack.push(arrList.get(i));
			}

			while(stack.isEmpty()== false)
			{
				//Popping off sorted number array
				System.out.println(stack.pop());
			}
		}
	}


	//Quick Sorting method
	public static void quickSort(ArrayList <Integer> arrList, int left, int right)
	{
		int index = partition(arrList, left, right);
		if (left < index -1)
		{
			//calls quick Sort on the left
			quickSort(arrList, left, index-1);
		}
		if (index < right)
		{
			//calls quick Sort on the right
			quickSort(arrList, index, right);
		}
	}

	//Partition function within quickSorting method
	public static int partition(ArrayList <Integer> arrList, int left, int right)
	{
		int i = left;
		int j = right;
		int pivot = arrList.get((left + right)/2);
		while (i <= j)
		{
			//In sequential order, so continue down list
			while (arrList.get(i) < pivot) 
			{
				i++;
			}

			//Restart
			while (arrList.get(j) > pivot) 
			{
				j--;
			}

			//SWAPPING because elements are out of order
			if(i <= j) 
			{
				//swapping values with temporary variables
				int temp = arrList.get(i);
				arrList.set(i, arrList.get(j));
				arrList.set(j, temp);
				i++;
				j--;
			}
		}
		return i;
	}
}