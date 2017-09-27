public class IntBSTree {
	
	/**
	 * 	
	 * This program tests a tree of integers.
	 * The driver and some of the code below is written by JJ Shepherd
	 *
	 */
	private class Node
	{
		private int data;
		private Node leftChild;
		private Node rightChild;
		
		public Node(int aData)
		{
			this.data = aData;
			this.leftChild = null;
			this.rightChild = null;
		}
	}
	private Node root;
	

	public IntBSTree()
	{
		root = null;
	}

	//Insert function that creates a new instance of a Node with the included data
	public void insert(int data)
	{
		root = insertNode(root, new Node(data));
	}

	//Recursive insertion call
	private Node insertNode(Node current, Node newNode) 
	{

		//If the current node being observed is null, insert a new node
		if (current == null) 
		{
			return newNode;
			
		} 
		
		//Checking to see if the data within the new node is greater than the data within the current node
		else if (newNode.data > current.data) 
		{
			current.rightChild = insertNode(current.rightChild, newNode); //Go Right!
			
		} 
		//Checking to see if the data within the new node is less than the data within the current node
		else if (newNode.data < current.data) 
		{
			current.leftChild = insertNode(current.leftChild, newNode); //Go Left!
			
		}

		return current;
	}
	

	//This method prints the list of integers
	public void printInorder()
	{
		//call recursive print in order
		printInOrder(root);
	}
			//This method recursively prints the values throughout the list of nodes
			private void printInOrder(Node aNode)
			{
				//Error check
				if(aNode == null)
				{
					return;
				}
				//As long as the left child isn't blank, print the value
				if(aNode.leftChild != null)
				{
					printInOrder(aNode.leftChild);
				}
				
				//Print the data
				System.out.println(aNode.data);
				
				//As long as the right isn't blank, print the value
				if(aNode.rightChild != null)
				{
					printInOrder(aNode.rightChild);
					return;
				}
			}
	
	//Counter for searching recursive through the tree 	
	int count = 0;
	
	public int getDepth(int value)
	{
		//Recursive search being called
		return recursiveSearch(root, value);	
	}
		
		//Private recursive search function
		public int recursiveSearch(Node aNode, int data)
		{
			
			if(aNode == null) //Not found in the list ... Print -1
			{
				return -1;
			}
			if(aNode.data-data == 0) //FOUND IT!!! Now return the count from counting through the tree
			{
				return count;
			}
			
			else if(aNode.data-data > 0) //Keep searching...
			{
				count++;
				return recursiveSearch(aNode.leftChild,data);
				
			}
			else		//Keep searching...
			{
				count++;
				return recursiveSearch(aNode.rightChild,data);
			}
		}

	}
