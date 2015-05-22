/*************************************
*   @author Harrison Jordan
*************************************/

/*
 * Harrison Jordan
 * CS3401
 * Section 02
 * Prof. Gayler
 * 04/27/2015
 * Assignment 10
 */
import java.util.List;
import java.util.ArrayList;


public class MyGraph<V> extends UnweightedGraph<V>{

	  public MyGraph() {
		  
	  }
	    
	  /** Construct a graph from vertices and edges stored in arrays */
	  public MyGraph(V[] vertices, int[][] edges) {
	    super(vertices, edges);
	  }

	  /** Construct a graph from vertices and edges stored in List */
	  public MyGraph(List<V> vertices, List<Edge> edges) {
	    super(vertices, edges);
	  }

	  /** Construct a graph for integer vertices 0, 1, 2 and edge list */
	  public MyGraph(List<Edge> edges, int numberOfVertices) {
	    super(edges, numberOfVertices);
	  }
	  
	  /** Construct a graph from integer vertices 0, 1, and edge array */
	  public MyGraph(int[][] edges, int numberOfVertices) {
	    super(edges, numberOfVertices);
	  }
	  
	  
	  /**
	   * @param the vertices must be integers
	   * @return a list of connected components of a graph
	   */
	
	public List<List<Integer>> getConnectedComponents(){
		List<List<Integer>> connectedComps = new ArrayList<List<Integer>>();
		List<Integer> vertices = (List<Integer>) getVertices();

		Tree traversal = dfs((Integer) vertices.get(0));
		List<Integer> traversed = traversal.getSearchOrder();
		connectedComps.add((List<Integer>) traversed);

		List<Integer> listed = new ArrayList<Integer>();
		listed.addAll(traversed);

		while (listed.size() != vertices.size()) {
			traversal = dfs((Integer) vertices.get(traversed.size()));
			traversed = traversal.getSearchOrder();
			connectedComps.add((List<Integer>) traversed);
			listed.addAll(traversed);
		}

		return connectedComps;
			
	  }

}
