package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mColoringProblem {
	static class Graph {
		int V;
		List<Integer>[] adjacencyList;

		public Graph(int v) {
			super();
			V = v;
			this.adjacencyList = new List[V];
			for (int i = 0; i < adjacencyList.length; i++) {
				this.adjacencyList[i] = new ArrayList<>();
			}
		}

		public void addEdge(int src, int dest) {
			this.adjacencyList[src].add(dest);
		}

	}

	private void printSolution(Graph g, int[] color) {
		for (int i = 0; i < g.V; i++) {
			System.out.println("Color of vertex is " + i + " is : " + color[i]);
		}
	}

	public void colorGraph(Graph g, int numOfColors) {
		int[] color = new int[g.V];
		Arrays.fill(color, 0);
		if (!graphColoringUtil(g, 0, color, numOfColors)) {
			System.out.println("Solution does not exist");
			return;
		}
		printSolution(g, color);
	}

	private boolean isColorSafeForVertex(Graph g, int vertex, int color, int[] colors) {
		List<Integer> adjacencyList = g.adjacencyList[vertex];
		for (int adjVertex : adjacencyList) {
			if (colors[adjVertex] == color) {
				return false;
			}
		}
		return true;
	}

	private boolean graphColoringUtil(Graph g, int vertex, int[] color, int numOfColors) {
		// All vertices are visited
		if (vertex == g.V) {
			return true;
		}

		for (int i = 1; i <= numOfColors; i++) {
			if (isColorSafeForVertex(g, vertex, i, color)) {
				color[vertex] = i;
				if (graphColoringUtil(g, vertex + 1, color, numOfColors)) {
					return true;
				}
				color[vertex] = 0;
			}
		}
		return false;
	}
	/*
	 * static class Graph { int V; List<Integer>[] adjacencyList = null;
	 * 
	 * public Graph(int v) { super(); V = v; adjacencyList = new List[V]; for (int i
	 * = 0; i < V; i++) { this.adjacencyList[i] = new ArrayList<Integer>(); } }
	 * 
	 * public void addEdge(Integer src, Integer dest) {
	 * this.adjacencyList[src].add(dest); }
	 * 
	 * private boolean isColorSafe(int vertex, int color, int[] colors) {
	 * List<Integer> adjacentVertices = this.adjacencyList[vertex]; for (int
	 * vertices : adjacentVertices) { if (colors[vertices] == color) { return false;
	 * } } return true; } }
	 * 
	 * public boolean colorGraph(Graph g, int numOfColors) { // Initialize all color
	 * values as 0. This // initialization is needed correct functioning // of
	 * isSafe() int[] color = new int[g.V]; for (int i = 0; i < g.V; i++) { color[i]
	 * = 0; } // Call graphColoringUtil() for vertex 0 if (!graphColoringUtil(g, 0,
	 * color, numOfColors)) { System.out.println("Solution does not exist"); return
	 * false; }
	 * 
	 * // Print the solution printSolution(g, color); return true;
	 * 
	 * }
	 * 
	 * private void printSolution(Graph g, int[] color) { for (int i = 0; i < g.V;
	 * i++) { System.out.println("Color of vertex is " + i + " is : " + color[i]); }
	 * 
	 * }
	 * 
	 * private boolean graphColoringUtil(Graph g, int vertex, int[] color, int
	 * numOfColors) { if (vertex == g.V) { return true; }
	 * System.out.println("Vertex :"+vertex);
	 * 
	 * for (int i = 1; i <= numOfColors; i++) { if (g.isColorSafe(vertex, i, color))
	 * { System.out.println("Vertex :"+vertex +" Color:"+i); color[vertex] = i;
	 * if(graphColoringUtil(g, vertex+1, color, numOfColors)) { return true; }
	 * color[vertex] = 0; } } return false; }
	 */

	public static void main(String[] args) {

		/*
		 * Create following graph and test whether it is 3 colorable
		 * 
		 */
		System.out.println("	       (3)---(2) ");
		System.out.println("	        |   // | ");
		System.out.println("	        |  //  | ");
		System.out.println("	        | //   | ");
		System.out.println("	       (0)---(1) ");
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(0, 3);
		g.addEdge(1, 0);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 1);
		g.addEdge(2, 3);
		g.addEdge(3, 0);
		g.addEdge(3, 2);
		mColoringProblem mcp = new mColoringProblem();
		mcp.colorGraph(g, 3);

	}

}
