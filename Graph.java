import java.util.*;
public class Graph {
	
	private class Vertex
	{
		String name;
		//Edges
		ArrayList<Edge> neighbors;
		public Vertex(String aName)
		{
			this.name = aName;
			this.neighbors = new ArrayList<Edge>();
		}
	}
	
	//Private class of edges
	private class Edge
	{
		
		//Instance variables
		Vertex v1;
		double weight;
		
		//Default constructor
		public Edge(Vertex av1, double aWeight)
		{
			v1 = av1;
			weight = aWeight;
		}
	}
	
	//Instance variables
	Vertex origin;
	ArrayList<Vertex> verticies;
	ArrayList<Vertex> markedVerticies;
	ArrayList<Vertex> visitedVerticies;
	private double maxLength; 
	
	//Default constructor
	public Graph(double aLength)
	{
		origin = null;
		verticies = new ArrayList<Vertex>();
		markedVerticies = new ArrayList<Vertex>();
		visitedVerticies = new ArrayList<Vertex>();
		maxLength = aLength;
	}
	
	//Adding a new vertex
	public void addVertex(String aName)
	{
		if(vertexIsContained(aName))
			return;
		
		//New instance of "V"
		Vertex v = new Vertex(aName);
		
		//Calling the add method
		verticies.add(v);
		
		if(origin == null)
		{
			//Make the new instance of V the first value
			origin = v;
		}
		
	}
	
	//Checking location of vertex
	public boolean vertexIsContained(String aName)
	{
		for(Vertex vert: verticies)
		{
			if(vert.name.equals(aName))
				return true;
		}
		return false;
	}
	
	//Adding a new edge
	public void addEdge(String fromVert, String toVert, double weight)
	{
		Vertex v1 = getVertex(fromVert);
		Vertex v2 = getVertex(toVert);
		if(v1 == null || v2 == null)
			return;
		v1.neighbors.add(new Edge(v2, weight));
	}
	
	// ============================================
	public Vertex getVertex(String aName)
	{
		for(Vertex vert: verticies)
		{
			if(vert.name == aName)
				return vert;
		}
		return null;
	}
	
	// ============================================
	public void printDFS()
	{
		markedVerticies.clear();
		//Recursive DFS
		printDFS(origin);
	}
	//Recursive call Depth First Search
	private void printDFS(Vertex vert)
	{
		if(markedVerticies.contains(vert))
			return; //BACK UP
		System.out.println(vert.name);
		markedVerticies.add(vert);
		
		for(Edge edge : vert.neighbors)
		{
			printDFS(edge.v1);
		}
	}
	
	//================================================
	
	
	public void printBFS()
	{
		markedVerticies.clear();
		visitedVerticies.clear();
		System.out.println(origin.name);
		//Recursive BFS
		printBFS(origin);
	}
	private void printBFS(Vertex vert)
	{
		if(markedVerticies.contains(vert))
			return; //BACK UP
		markedVerticies.add(vert);
		for(Edge edge : vert.neighbors)
		{
			if(visitedVerticies.contains(edge.v1) || markedVerticies.contains(edge.v1))
				continue;
			System.out.println(edge.v1.name);
			visitedVerticies.add(edge.v1);
		}
		//Goes down to the next verts
		for(Edge edge: vert.neighbors)
		{
			printBFS(edge.v1);
		}
	}
	
	
	// ====================================
	
	public void printLazyDFS()
	{
		markedVerticies.clear();
		//Recursive DFS
		printLazyDFS(origin);
	}
	//Recursive call Depth First Search
	private void printLazyDFS(Vertex vert)
	{
		if(markedVerticies.contains(vert))
			return; //BACK UP
		System.out.println(vert.name);
		markedVerticies.add(vert);
		
		for(Edge edge : vert.neighbors)
		{
			if(edge.weight < maxLength)
			{
				printLazyDFS(edge.v1);
			}
		}
	}
		
}


