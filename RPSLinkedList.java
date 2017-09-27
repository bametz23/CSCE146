public class RPSLinkedList <T> 
{
	private class ListNode 
	{
        private int data;
        private ListNode link;
        public ListNode() 
        {
            link = null;
            data = 0;
        }
        public ListNode(int newData, ListNode linkValue) 
        {
            data = newData;
            link = linkValue;
        }
    }
	
	private ListNode head;
    private ListNode current;
    private ListNode previous;
    
    
    public RPSLinkedList() 
    {
        head = null;
        current = null;
        previous = null;
    }
    

    
    public void addANodeToStart(int addData) 
    {
        head = new ListNode(addData, head);
        if ((current == head.link) && (current != null))
            //if current is at old start node
            previous = head;
    }
    
    /**
     * Inserts a new node containing newData after the current node.
     * The current node is the same after invocation as it is before.
     * Precondition: List is not empty; current node is not
     * beyond the entire list.
     */
    public void insertNodeAfterCurrent(int newData) 
    {
        ListNode newNode = new ListNode();
        newNode.data = newData;
        if (current != null) 
        {
            newNode.link = current.link;
            current.link = newNode;
        } 
        else if (head != null) 
        {
            System.out.println("Inserting when iterator is past all " +
                    "nodes or is not initialized.");
            System.exit(0);
        } 
        else 
        {
            System.out.println(
                    "Using insertNodeAfterCurrent with empty list.");
            System.exit(0);
        }
    }
    /*
     * Adds data to the end of the linked list
     * */
    public void insert(int addData)
    {
    	ListNode newNode = new ListNode();
    	newNode.data = addData;
    	if(head == null)
    	{
    		head = newNode;
    		current = head;
    		return;
    	}
    	ListNode position = head;
    	ListNode prevPos = null;
    	while(position != null)
    	{
    		prevPos = position;
    		position = position.link;
    	}
    	position = newNode;
    	prevPos.link = position;
    }    
    /**
     * Sets iterator to beginning of list.
     */
    public void resetIteration() 
    {
        current = head;
        previous = null;
    }
    
    
    /**
     * Returns true if iteration is not finished.
     */
    public boolean moreToIterate() 
    {
        return current != null;
    }
    
    
    /**
     * Advances iterator to next node.
     */
    public void goToNext() 
    {
        if (current != null) 
        {
            previous = current;
            current = current.link;
        } 
        else if (head != null) 
        {
            System.out.println(
                    "Iterated too many times or uninitialized iteration.");
            System.exit(0);
        } 
        else 
        {
            System.out.println("Iterating with an empty list.");
            System.exit(0);
        }
    }
    
    
    /**
     * Returns the data at the current node.
     */
    public int getDataAtCurrent() 
    {
        int result = 0;
        if (current != null)
        {
            result = current.data;
        }
        else 
        {
            System.out.println("Getting data when current is not at any node.");
            System.exit(0);
        }
        return result;
    }
    
    
    
    /**
     * Replaces the data at the current node.
     */
    public void setDataAtCurrent(int newData) 
    {
        if (current != null) 
        {
            current.data = newData;
        } 
        else 
        {
            System.out.println(
                    "Setting data when current is not at any node.");
            System.exit(0);
        }
    }
    /**
     * Displays the data on the list.
     */
    public void showList() 
    {
        ListNode position = head;
        while (position != null) 
        {
            System.out.println(position.data);
            position = position.link;
        }
    }
    
    
    /**
     * Returns the number of nodes on the list.
     */
    public int length() 
    {
        int count = 0;
        ListNode position = head;
        while (position != null) 
        {
            count++;
            position = position.link;
        }
        return count;
    }
    
    
    /**
     * Sees whether target is on the list.
     */
    public boolean inList(int target)
    {
        return find(target) != null;
    }
    
    
// Returns a reference to the first node containing the
// target data. If target is not on the list, returns null.
    private ListNode find(int target) 
    {
        boolean found = false;
        ListNode position = head;
        while ((position != null) && ! found)
        {
            int dataAtPosition = position.data;
            if (dataAtPosition == target)
            {
                found = true;
            }
            else
            {
                position = position.link;
            }
        }
        return position;
    }     
    
    /**
     * Deletes the current node. After the invocation,
     * the current node is either the node after the
     * deleted node or null if there is no next node.
     */
    public void deleteCurrentNode() 
    {
        if ((current != null) && (previous != null)) 
        {
            previous.link = current.link;
            current = current.link;
        } 
        else if ((current != null) && (previous == null)) 
        {//At head node
            head = current.link;
            current = head;
        } 
        else //current == null which could mean it deleted the last node or at the end of the list
        {
           this.resetIteration();
        }
    }


}
