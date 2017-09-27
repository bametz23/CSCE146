
public class ADJMatrixGraphTester {

	public static void main(String[] args) {
		
		ADJMatrixGraph g = new ADJMatrixGraph();
		
		System.out.println("Adding edges");
		g.addEdge(2, 1, 1.0);
		g.addEdge(4, 1, 1.0);
		g.addEdge(3, 4, 1.0);
		g.addEdge(5, 4, 1.0);
		g.addEdge(7, 5, 1.0);
		g.addEdge(7, 5, 1.0);
		g.addEdge(5, 3, 1.0);
		g.addEdge(1, 3, 1.0);
		g.addEdge(6, 3, 1.0);
		
		
		
		System.out.println("Printing DFS");
		g.printDFS();
		System.out.println("Printing BFS");
		g.printBFS();
		System.out.println("Printing DFS for all");
		g.printDFSForAll();
		System.out.println("Printing BFS for all");
		g.printBFSForAll();
		
		
	}
}