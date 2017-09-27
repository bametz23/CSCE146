
public class SheepHeap <T extends Comparable <T>> {
	
	
		public static final int default_size = 100;
		
		private T[] heap;
		private int size; //Always assumed to look at the last open element
		
		public SheepHeap()
		{
			heap = (T[])(new Comparable[default_size]);
			size = 0;
		}
		public SheepHeap(int length)
		{
			if(length > 0)
			{
				heap = (T[])(new Comparable[length]);
				size = 0;
			}
		}
		
		public void addSheep(T value)
		{
			if(size >= heap.length)
			{
				System.out.println("Filled up");
				return;
			}
			heap[size] = value;
			
			//Climb up
			climbUp();
			size++;
		}
		private void climbUp()
		{
			int index = this.size;
			while(index > 0)
			{
					//TERTIARY OPERATOR
					int parentIndex = index % 2 != 0 ? (index-1)/2:(index-2)/2;
				
				if(parentIndex >= 0 && heap[index].compareTo(heap[parentIndex]) < 0)
				{
					//Out of order... SWAP
					T temp = heap[parentIndex];
					heap[parentIndex] = heap[index];
					heap[index] = temp;
				}
				else
				{
					break;
				}
				index = parentIndex;

			}
		
		}
		
		public T removeSheep()
		{
			T retVal = heap[0];
			
			if(size == 0)
			{
				return null;	
			}
			
			else
			{
				//Views the element in the root to the last element in the tree
				heap[0] = heap[size-1];
				
				heap[size-1] = null;
				size--;
				
				//Bubble down
				climbDown();
				
				return retVal;
			}
		}
		
		
		private void climbDown()
		{
			//Always start at root
			int index = 0;
			
			while(index*2+1 < size)
			{
				int bigIndex = index*2+1; //Assumed left is bigger than right
				int otherIndex = index*2+2;
				
				if(otherIndex < size && heap[bigIndex].compareTo(heap[otherIndex]) > 0)
				{
					bigIndex = otherIndex;//Nope, right was bigger
				}
				if(heap[index].compareTo(heap[bigIndex]) > 0)
				{
					//SWAP
					T temp = heap[index];
					heap[index] = heap[bigIndex];
					heap[bigIndex] = temp;
				}
				else
				{
					break;
				}
				index = bigIndex;
					
			}
			
		}
		
		public void sheepRollCall()
		{
			for(T moo : heap)
			{
				if(moo == null)
					break;
				System.out.println(moo.toString());
			}
		}
		
		public void sheepHeapSort()
		{
			SheepHeap tempHeap = new SheepHeap(heap.length);
			
			//Creates a deep copy
			T[] cloneHeap = heap.clone();
			
			for(int i=0; i<size; i++)
			{
				//Inserting same values into the clone heap
				tempHeap.addSheep(cloneHeap[i]);
			}
			//Heap sort
			for(int i=size; i>0; i--)
			{
				System.out.print(tempHeap.removeSheep() + " ");
			}
			System.out.println();
		}
	}