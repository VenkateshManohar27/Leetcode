package com.ven.leetcode.greedy;

import java.util.Arrays;

public class Graph {
	private int V;
	private int E;
	private Edge[] edges;

	public Graph(int v, int e) {
		super();
		V = v;
		E = e;

		edges = new Edge[e];
		for (int i = 0; i < e; i++) {
			edges[i] = new Edge();
		}
	}

	public Edge[] getEdges() {
		return edges;
	}

	public void setEdges(Edge[] edges) {
		this.edges = edges;
	}

	class Subset {
		int parent;
		int rank;
	}

	public void KruskalMST() {
		Arrays.sort(this.edges);
		Arrays.stream(this.edges).forEach(System.out::println);
		Subset[] subsets = new Subset[this.V];
		for (int i = 0; i < subsets.length; i++) {
			subsets[i] = new Subset();
			subsets[i].parent = i;
			subsets[i].rank = 0;
		}
		Edge[] result = new Edge[V - 1];
		int edgesAdded = 0;
		for (int i = 0; i < edges.length; i++) {
			if (edgesAdded == result.length) {
				break;
			}
			Edge current = edges[i];
			int x = find(subsets, current.getSrc());
			int y = find(subsets, current.getDest());

			if (x != y) {
				result[edgesAdded] = current;
				edgesAdded++;
				Union(subsets, current.getSrc(), current.getDest());
			}
		}
		// print the contents of result[] to display
		// the built MST
		System.out.println("Following are the edges in " + "the constructed MST");
		for (int i = 0; i < edgesAdded; ++i)
			System.out.println(result[i].getSrc() + " -- " + result[i].getDest() + " == " + result[i].getWeight());
	}

	private void Union(Subset subsets[], int x, int y) {
		int xroot = find(subsets, x);
		int yroot = find(subsets, y);

		// Attach smaller rank tree under root of high rank tree
		// (Union by Rank)
		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].parent = yroot;
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].parent = xroot;

			// If ranks are same, then make one as root and increment
			// its rank by one
		} else {
			subsets[yroot].parent = xroot;
			subsets[xroot].rank++;
		}
	}

	private int find(Subset[] subsets, int x) {

		if (subsets[x].parent != x) {
			subsets[x].parent = find(subsets, subsets[x].parent);
		}
		return subsets[x].parent;
	}

	public static void main(String[] args) {

		System.out.println("        		10 ");
		System.out.println("		   0--------1 ");
		System.out.println("		   |  \\     | ");
		System.out.println("		  6|   5\\   |15 ");
		System.out.println("		   |      \\ | ");
		System.out.println("		   2--------3 ");
		System.out.println("		       4       ");
		int V = 4; // Number of vertices in graph
		int E = 5; // Number of getEdges()s in graph
		Graph graph = new Graph(V, E);

		// add getEdges() 0-1
		graph.getEdges()[0].setSrc(0);
		graph.getEdges()[0].setDest(1);
		graph.getEdges()[0].setWeight(10);

		// add getEdges() 0-2
		graph.getEdges()[1].setSrc(0);
		graph.getEdges()[1].setDest(2);
		graph.getEdges()[1].setWeight(6);

		// add getEdges() 0-3
		graph.getEdges()[2].setSrc(0);
		graph.getEdges()[2].setDest(3);
		graph.getEdges()[2].setWeight(5);

		// add getEdges() 1-3
		graph.getEdges()[3].setSrc(1);
		graph.getEdges()[3].setDest(3);
		graph.getEdges()[3].setWeight(15);

		// add getEdges() 2-3
		graph.getEdges()[4].setSrc(2);
		graph.getEdges()[4].setDest(3);
		graph.getEdges()[4].setWeight(4);

		graph.KruskalMST();
	}

}
