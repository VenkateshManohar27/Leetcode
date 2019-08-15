package com.ven.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

public class MultistageGraph {

	static class Result {
		int cost;
		List<Integer> path = new ArrayList<Integer>();

		@Override
		public String toString() {
			return "Result [cost=" + cost + ", path=" + path + "]";
		}

	}

	// Driver code
	public static void main(String[] args) {
		// Graph stored in the form of an
		// adjacency Matrix
		int[][] graph = new int[][] {
				{ Integer.MAX_VALUE, 1, 2, 5, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
						Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 4, 11, Integer.MAX_VALUE,
						Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 9, 5, 16,
						Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
						Integer.MAX_VALUE, 2, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
						Integer.MAX_VALUE, Integer.MAX_VALUE, 18 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
						Integer.MAX_VALUE, Integer.MAX_VALUE, 13 },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
						Integer.MAX_VALUE, Integer.MAX_VALUE, 2 } };

		System.out.println(shortestDist(graph));
	}

	private static Result shortestDist(int[][] graph) {
		Result res = new Result();
		int N = graph.length + 1;
		int[] cost = new int[N];
		int[] path = new int[N];
		cost[N - 1] = 0;
		for (int i = N - 2; i >= 0; i--) {
			cost[i] = Integer.MAX_VALUE;
			int min = Integer.MAX_VALUE;
			int vertex = Integer.MAX_VALUE;
			for (int j = i + 1; j < N; j++) {
				if (graph[i][j] == Integer.MAX_VALUE) {
					continue;
				}
				System.out.println("i:" + i +" , j:"+j);
				System.out.println("cost[i]:" + cost[i]);
				System.out.println("graph[i][j]:" + graph[i][j]+", cost[j]:" + cost[j]);
				
				System.out.println("-------------------------------------------");
				if(min > Math.min(min, graph[i][j] + cost[j])) {
					path[i] = i;
					System.out.println("path[i]: "+path[i]);
				}
				min = Math.min(min, graph[i][j] + cost[j]);
			}
			System.out.println("min" + min);
			System.out.println("i:" + i);
			System.out.println("-------------------------------------------");
			cost[i] = min;
			res.path.add(0, path[i]);
		}
		res.cost = cost[0];
		return res;
	}

	/*
	 * public static int shortestDist(int[][] graph) {
	 * //System.out.println(graph.length + 1); int N = graph.length + 1; int[] dist
	 * = new int[N]; dist[N - 1] = 0; // int[] cost = new int[graph.length+1]; for
	 * (int i = N - 2; i >= 0; i--) { dist[i] = Integer.MAX_VALUE; // nt min =
	 * Integer.MIN_VALUE; for (int j = i; j < N; j++) { if (graph[i][j] ==
	 * Integer.MAX_VALUE) { continue; } dist[i] = Math.min(dist[i], graph[i][j] +
	 * dist[j]); } } return dist[0]; }
	 */

}
