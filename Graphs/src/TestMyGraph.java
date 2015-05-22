/*****************************************
 *  @author Harrison Jordan
 ****************************************/
/*
 * CS3401
 * Section 02
 * Prof. Gayler
 * 04/27/2015
 * Assignment 10
 */
public class TestMyGraph {

	public static void main(String[] args) {
		

		// Edge array for graph in Figure 28.1
		int[][] edges = { { 0, 1 }, { 0, 2 }, 
						  { 1, 0 }, { 1, 3 },
						  { 2, 0 }, { 2, 3 }, { 2, 4 }, 
						  { 3, 1 }, { 3, 2 }, { 3, 4 }, { 3, 5}, 
						  { 4, 2 }, { 4, 3 }, { 4, 5 }, 
						  { 5, 3 }, { 5, 4 }
						};
		
		int[][] edges2 = { 	{ 0, 1 }, { 0, 2 }, 
				  			{ 1, 0 }, { 1, 3 },
				  			{ 2, 0 }, { 2, 3 },
				  			{ 3, 1 }, { 3, 2 }, 
				  			{ 4, 5 }, 
				  			{ 5, 4 }
				};
		
		int[][] edges3 = { { 0, 1 }, 
	  			{ 1, 2 }, { 1, 3 },
	  			{ 2, 1 }, { 2, 3 },
	  			{ 3, 1 }, { 3, 2 }, 
	  			{ 4, 5 }, 
	  			{ 5, 4 }
	};

		MyGraph<Integer> graph = new MyGraph<Integer>(edges, 6);
		MyGraph<Integer> graph2 = new MyGraph<Integer>(edges2, 6);
		MyGraph<Integer> graph3 = new MyGraph<Integer>(edges3, 6);
		System.out.println(graph2.getConnectedComponents());
		System.out.println(graph.getPath(0, 5));
		System.out.println(graph3.getACycle());
		
	}

}
