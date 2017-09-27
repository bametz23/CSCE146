
public class GenArrayQueue <T> {
	
	//Final int to set array size
	public static final int DEFAULT_SIZE = 100;
	
	//Instance variable T array
	private T[] queue;
	
	//Default constructor
	public GenArrayQueue()
	{
		queue = (T[]) new Object[DEFAULT_SIZE];
		//tailIndex = 0;
	}
	
	//Parameterized constructor
	public GenArrayQueue(int size)
	{
		queue = (T[]) new Object[size];
		tailIndex = 0;
	}
	
	//Instance variable
	private int tailIndex;
	
	//Enqueue method which adds data to the list
	public void enqueue (T data)
	{
		if(tailIndex >= queue.length)
		{
			System.out.println("Queue is full");
			return;
		}
			queue[tailIndex] = data;
			tailIndex++;
	}
	
	//Dequeue method which subtracts data to the list
	public T dequeue ()
	{
		T retData = queue[0];
		for(int i = 0; i<queue.length-1; i++)
		{
			queue[i] = queue[i+1];
		}
		queue[queue.length-1] = null;
		tailIndex--;
		return retData;
	}
	
	//Peeking method which shows data at a specific index
	public T peek()
	{
		return queue[0];
	}
	
	/**
	 * Showing the elements inside the queue
	 */
	public void showQueue()
	{
		/**
		 * ======== "For each" loop ========
		 */
		for(T node : queue)
		{
			if(node == null)
			{
				break;
			}
			
			System.out.println(node.toString());
		}
	}
	

}
