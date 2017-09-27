public class IntLinkedList{
	
	private class Node
	{
		int data;
		Node link;
		public Node(int aData, Node aLink)
		{
			data = aData;
			link = aLink;
		}
	}
	Node head;
	
	public void doubleValues(int value)
	{
		if(value == Node.data)
		{
			Node newNode = new Node(value, newNode);
			newNode.data = newNode.data*2;			
		}

	}

}