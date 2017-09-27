public class minHeapDriver
{

		public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Int Min Heap Tester");
		System.out.println("Populating heap with values");

		minHeap testHeap = new minHeap();

		int array[] = {21, 37, 49, 11, 23, 1, 13, 16, 33, 17};

		for(int i : array)
		{
			testHeap.insert(i);
			System.out.println(i);
		}

		System.out.println("Printing heap");
		testHeap.print();
		System.out.println("Testing heap sort");
		testHeap.heapSort();
		System.out.println("Removing an element from the heap");
		testHeap.delete();
		System.out.println("the element removed is 1 and the heap now is");
		testHeap.print();
		
		}
}