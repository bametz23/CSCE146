import java.util.*;

public class ADJMatrixGraph {
	private static final int DEFAULT_NODE_COUNT = 10;
	private double [][] adjMatrix;
	
	private ArrayList<Integer> markedVerts;
	public ArrayList<Integer> visitedVerts;
	
	//Constructors
	public ADJMatrixGraph()
	{
		adjMatrix = new double[DEFAULT_NODE_COUNT][DEFAULT_NODE_COUNT];
		markedVerts = new ArrayList<Integer>();
		visitedVerts = new ArrayList<Integer>();
		
	}
	public ADJMatrixGraph(int size)
	{
		if(size<=0)
				return;
		adjMatrix = new double[size][size];
		markedVerts = new ArrayList<Integer>();
		visitedVerts = new ArrayList<Integer>();
	}
	
	public void addEdge(int toVertex, int fromVertex, double weight)
	{
		if(toVertex < 0 || fromVertex < 0)
			return;
		adjMatrix[toVertex][fromVertex] = weight;
		
	}
	public void printDFS()
	{
		markedVerts.clear();
		//DFS Recursive call
		printDFS(0);
	}
	public void printDFS(int index)
	{
		markedVerts.clear();
		//Visit node mark index
		System.out.println(index);
		markedVerts.add(index);
		//Find a neighbor to traverse to
		for(int i=0; i<adjMatrix[index].length; i++)
		{
			if(adjMatrix[index][i] != 0 && markedVerts.contains(i) == false)
			{
				printDFS();
			}
		}
		return;
	}
	public void printBFS()
	{
		markedVerts.clear();
		visitedVerts.clear();
		//Recursive BFS
		printBFS(0);
	}
	
	public void printBFS(int index)
	{
		if(visitedVerts.contains(index) == false)
		{
			System.out.println(index);
			visitedVerts.add(index);
			
		}
		markedVerts.add(index);
		for(int i=0; i<adjMatrix[index].length; i++)
		{
			if(adjMatrix[index][i] != 0 && visitedVerts.contains(i) == false)
			{
				System.out.println(i);
				visitedVerts.add(i);
			}
		}
		//Move to next node that's not marked
		for(int i=0; i<adjMatrix[index].length; i++)
		{
			if(adjMatrix[index][i] != 0 && markedVerts.contains(i) == false)
			{
				printBFS(i);
			}
		}
		return;
	}
	
	
	public void printDFSForAll()
	{
		for(int i=0; i<adjMatrix.length; i++)
		{
			markedVerts.clear();
			printDFS(i);
		}
		return;
	}
	
	public void printBFSForAll()
	{
		for(int i=0; i<adjMatrix.length; i++)
		{
			markedVerts.clear();
			visitedVerts.clear();
			printBFS(i);
		}
		return;
	}	
}

