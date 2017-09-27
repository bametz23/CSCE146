
public class Stack<T> 
{
	
public static final int DEAFULT_SIZE = 100;
	
	//Generic Type array
	public T[] stack;
	
	//Default constructor
	public Stack()
	{
		stack = (T[]) new Object[DEAFULT_SIZE];
		headIndex = 0;
	}
	
	//Parameterized constructor
	public Stack(int size)
	{
		stack = (T[]) new Object[size];
		headIndex = 0;
	}
	
	//Points to last element inserted
	int headIndex;
	
	//"Push" method (adding data)
	public void Push(T data)
	{
		//Checking to see if array is full
		if(headIndex+1 >= stack.length)
		{
			System.out.println("Stack is full");
			return;
		}
		if(stack[0] == null)
		{
			stack[0] = data;
			return;
		}
		headIndex++;
		stack[headIndex] = data;
	}
	
	//"Pop" method (deleting data)
	public T Pop()
	{
		T retData = stack[headIndex];
		stack[headIndex] = null;
		headIndex--;
		
		if(headIndex < 0)
		{
			headIndex = 0;
		}
		return retData;
	}
	


}

