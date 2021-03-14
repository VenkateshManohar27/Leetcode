package com.ven.leetcode.mar2021.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * There is an undirected weighted connected graph. You are given a positive
 * integer n which denotes that the graph has n nodes labeled from 1 to n, and
 * an array edges where each edges[i] = [ui, vi, weighti] denotes that there is
 * an edge between nodes ui and vi with weight equal to weighti.
 * 
 * A path from node start to node end is a sequence of nodes [z0, z1, z2, ...,
 * zk] such that z0 = start and zk = end and there is an edge between zi and
 * zi+1 where 0 <= i <= k-1.
 * 
 * The distance of a path is the sum of the weights on the edges of the path.
 * Let distanceToLastNode(x) denote the shortest distance of a path between node
 * n and node x. A restricted path is a path that also satisfies that
 * distanceToLastNode(zi) > distanceToLastNode(zi+1) where 0 <= i <= k-1.
 * 
 * Return the number of restricted paths from node 1 to node n. Since that
 * number may be too large, return it modulo 109 + 7.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 5, edges =
 * [[1,2,3],[1,3,3],[2,3,1],[1,4,2],[5,2,2],[3,5,1],[5,4,10]] Output: 3
 * Explanation: Each circle contains the node number in black and its
 * distanceToLastNode value in blue. The three restricted paths are: 1) 1 --> 2
 * --> 5 2) 1 --> 2 --> 3 --> 5 3) 1 --> 3 --> 5 Example 2:
 * 
 * 
 * Input: n = 7, edges =
 * [[1,3,1],[4,1,2],[7,3,4],[2,5,3],[5,6,1],[6,7,2],[7,5,3],[2,6,4]] Output: 1
 * Explanation: Each circle contains the node number in black and its
 * distanceToLastNode value in blue. The only restricted path is 1 --> 3 --> 7.
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 2 * 104 n - 1 <= edges.length <= 4 * 104 edges[i].length == 3 1 <=
 * ui, vi <= n ui != vi 1 <= weighti <= 105 There is at most one edge between
 * any two nodes. There is at least one path between any two nodes.
 * 
 * @author Venkatesh Manohar
 *
 */
public class CountRestrictedPaths {
	private Map<Integer, List<int[]>> map = new HashMap<>();
	private final static int mod = 1_000_000_007;

	public int countRestrictedPaths(int n, int[][] edges) {
		for (int[] e : edges) {
			map.computeIfAbsent(e[0], x -> new ArrayList<>()).add(new int[] { e[1], e[2] }); // create graph with
																								// weights
			map.computeIfAbsent(e[1], x -> new ArrayList<>()).add(new int[] { e[0], e[2] });
		}
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]); // sort based on weight (Dijkstra's)
		pq.offer(new int[] { n, 0 });
		int[] dist = new int[n + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[n] = 0;
		System.out.print(map);
		while (!pq.isEmpty()) {
			int[] curr = pq.poll();
			int node = curr[0];
			int weight = curr[1];

			for (int[] neighbor : map.get(node)) {
				int nei = neighbor[0];
				int w = weight + neighbor[1];

				if (w < dist[nei]) { // only traverse if this will create a shorter path. At the end we have all the
										// shortest paths for each node.
					dist[nei] = w;
					pq.offer(new int[] { nei, w });
				}
			}
		}
		Integer[] dp = new Integer[n + 1];
		return dfs(1, n, dist, dp);
	}

	public int dfs(int node, int end, int[] dist, Integer[] dp) {
		if (node == end)
			return 1;
		if (dp[node] != null)
			return dp[node];
		long res = 0;
		for (int[] neighbor : map.get(node)) {
			int nei = neighbor[0];
			if (dist[node] > dist[nei]) { // use our calculations from Dijkstra's to determine if we can travel to a
											// neighbor.
				res = (res + (dfs(nei, end, dist, dp)) % mod);
			}
		}
		res = (res % mod);
		return dp[node] = (int) res; // memoize for looking up values that have already been computed.
	}
	
	public static void main(String[] args) {
		CountRestrictedPaths c = new CountRestrictedPaths();
		
		c.countRestrictedPaths(5, new int[][] {{1,2,3},{1,3,3},{2,3,1},{1,4,2},{5,2,2},{3,5,1},{5,4,10}});
	}
}
