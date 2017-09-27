//Parent Linked List class
public class GenLLQueue <T> 
{
	
	//Subclass
	private class ListNode
	{
		//More instance variables
		private T data;
		private ListNode link;
	}
	//Instance variables
	private ListNode head;
	private ListNode tail;
	
	//Default constructor
	public GenLLQueue()
	{
		head = null;
		tail = null;
	}
	
	//Enqueue - Refers to adding a node from the list. FIFO - First In First Out
	public void enqueue (T adata)
	{
		//New instance of ListNode
		ListNode  newNode = new ListNode();
		newNode.data = adata;
		
		//Empty queue
		if(head == null)
		{
			head = tail = newNode;
			return;
		}
		tail.link = newNode;
		tail = tail.link;
	}
	
	//Dequeue - Refers to subtracting a node from the list. FIFO - First In First Out
	public T dequeue()
	{
		if(head == null)
		{
			System.out.println("EMPTY LIST.");
			return null;
		}
		
		T retData = head.data;
		head = head.link;
		return retData;
	}
	
	//Peeking method which observes the head of the data list
	public T peek()
	{
		return head.data;
	}
	
	//Printing method which returns all the nodes in the list
	public void showQueue()
	{
		//Nothing to show...
		if(head == null)
		{
			System.out.println("Printing an empty list");
		}
		
		//Showing the results of the list
		while(head != null)
		{
			System.out.println(head.data.toString());
			head = head.link;
		}
		
	}


}
