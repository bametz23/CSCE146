/**
 * 
 * Written by Bailey Metz
 * 03/31/16
 *
 */
public class SheepHeapTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Sheep Min Heap Tester");
		System.out.println("Populating heap with sheep!!!");

		//Testing the two different heaps (name and weight)
		SheepHeap testHeap1 = new SheepHeap();
		SheepHeap testHeap2 = new SheepHeap();

		//Creating the names for the sheep
		String sheepNames[] = new String[15];
		sheepNames[0] = "Itchy";
		sheepNames[1] = "Curly";
		sheepNames[2] = "Spots";
		sheepNames[3] = "Cleo";
		sheepNames[4] = "Lacy";
		sheepNames[5] = "Parker";
		sheepNames[6] = "SHAWN";
		sheepNames[7] = "Richard";
		sheepNames[8] = "Drake/6God";
		sheepNames[9] = "Feminist";
		sheepNames[10] = "Sinister";
		sheepNames[11] = "Benji";
		sheepNames[12] = "Showboat";
		sheepNames[13] = "Braaaaaadley";
		sheepNames[14] = "Alexandra";
		
		//Creating the weight for the sheep
		String sheepWeights[] = {100 +"lbs", 23+"lbs", 679+"lbs", 900+"lbs", 86
				+"lbs", 300+"lbs", 60+"lbs", 50+"lbs", 99
				+"lbs", 40+"lbs", 79+"lbs", 24+"lbs", 78+"lbs", 11
				+"lbs", 88+"lbs"};
		
		//Going through and adding/printing the sheep's names
		for(String i : sheepNames)
		{
			testHeap1.addSheep(i);
			System.out.println(i);
		}
		//Going through and adding/printing the sheep's weights
		System.out.println("============================");
		for(String i : sheepWeights)
		{
			testHeap2.addSheep(i);
			System.out.println(i);
		}
		
		//Using roll call method for names
		System.out.println("============================");
		System.out.println("Printing Sheep Heap of Names!");
		testHeap1.sheepRollCall();
		
		//Using roll call method for weight
		System.out.println("============================");
		System.out.println("Printing Sheep Heap of Weights!");
		testHeap2.sheepRollCall();
		
		//Using sheep heap sort method for names
		System.out.println("============================");
		System.out.println("Testing Sheap heap sort of Names!!!");
		System.out.println("============================");
		testHeap1.sheepHeapSort();
		
		//Using sheep heap sort method for weight
		System.out.println("============================");
		System.out.println("Testing Sheap heap sort of Weights!!!");
		System.out.println("============================");
		testHeap2.sheepHeapSort();
		
		//Using remove sheep method for names then calling roll call
		System.out.println("============================");
		System.out.println("Removing a sheep Name from the heap");
		testHeap1.removeSheep();
		System.out.println("the first sheep in the heap has been removed is and the heap now is");
		System.out.println("============================");
		testHeap1.sheepRollCall();
		System.out.println("============================");
		System.out.println("Removing 4 more sheep from the heap");
		System.out.println("============================");
		for(int i=0; i<4; i++)
		{
			testHeap1.removeSheep();
		}
		testHeap1.sheepRollCall();
		
		//Using remove sheep method for weight then calling roll call
		System.out.println("============================");
		System.out.println("Removing a sheep's weight from the heap");
		testHeap2.removeSheep();
		System.out.println("the first sheep's weight in the heap has been removed is and the heap now is");
		System.out.println("============================");
		testHeap2.sheepRollCall();
		System.out.println("============================");
		System.out.println("Removing 4 more sheep's weights from the heap");
		System.out.println("============================");
		for(int i=0; i<4; i++)
		{
			testHeap2.removeSheep();
		}
		testHeap2.sheepRollCall();

	}

}
