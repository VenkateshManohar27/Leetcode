package com.ven.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
	private int V;
	private List<Integer>[] adjList = null;

	public Graph(int v) {
		super();
		V = v;
		adjList = new List[V];
		for (int i = 0; i < this.V; i++) {
			adjList[i] = new ArrayList<>();
		}
	}

	public int getV() {
		return V;
	}

	public List<Integer>[] getAdjList() {
		return adjList;
	}

	public void addEdge(int src, int dest) {
		this.adjList[src].add(dest);
		this.adjList[dest].add(src);
	}

	public void printGraph() {
		for (int i = 0; i < this.V; i++) {
			System.out.println("Adjacency list of vertex " + i);
			for (Integer vertex : adjList[i]) {
				System.out.print("->" + vertex);
			}
			System.out.println();
		}
	}

	public void dfs(int src) {
		if (src < 0 || src >= this.V) {
			return;
		}
		System.out.println("Depth First search for the graph is as follows:");
		boolean[] visited = new boolean[this.V];
		dfsUtil(src, visited);
		System.out.println();
	}

	private void dfsUtil(int src, boolean[] visited) {
		visited[src] = true;
		System.out.print(src + "->");
		for (int i : this.adjList[src]) {
			if (!visited[i])
				dfsUtil(i, visited);
		}
	}

	public void bfs(int src) {
		if (src < 0 || src >= this.V) {
			return;
		}
		System.out.println("Breadth First search for the graph is as follows:");
		boolean[] visited = new boolean[this.V];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(src);
		visited[src] = true;
		while (!q.isEmpty()) {
			int vertex = q.poll();
			System.out.print(vertex + "->");

			for (Integer adjVertex : this.adjList[vertex]) {
				if (!visited[adjVertex]) {
					q.add(adjVertex);
					visited[adjVertex] = true;
				}
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {

		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// print the adjacency list representation of
		// the above graph
		graph.printGraph();

		graph.bfs(2);

		graph.dfs(2);
		
		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.bfs(2);

		g.dfs(2);
	}
}
