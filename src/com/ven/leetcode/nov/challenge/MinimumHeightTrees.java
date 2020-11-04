package com.ven.leetcode.nov.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * A tree is an undirected graph in which any two vertices are connected by
 * exactly one path. In other words, any connected graph without simple cycles
 * is a tree.
 * 
 * Given a tree of n nodes labelled from 0 to n - 1, and an array of n - 1 edges
 * where edges[i] = [ai, bi] indicates that there is an undirected edge between
 * the two nodes ai and bi in the tree, you can choose any node of the tree as
 * the root. When you select a node x as the root, the result tree has height h.
 * Among all possible rooted trees, those with minimum height (i.e. min(h)) are
 * called minimum height trees (MHTs).
 * 
 * Return a list of all MHTs' root labels. You can return the answer in any
 * order.
 * 
 * The height of a rooted tree is the number of edges on the longest downward
 * path between the root and a leaf.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 4, edges = [[1,0],[1,2],[1,3]] Output: [1] Explanation: As shown,
 * the height of the tree is 1 when the root is the node with label 1 which is
 * the only MHT. Example 2:
 * 
 * 
 * Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]] Output: [3,4] Example
 * 3:
 * 
 * Input: n = 1, edges = [] Output: [0] Example 4:
 * 
 * Input: n = 2, edges = [[0,1]] Output: [0,1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 2 * 104 edges.length == n - 1 0 <= ai, bi < n ai != bi All the
 * pairs (ai, bi) are distinct. The given input is guaranteed to be a tree and
 * there will be no repeated edges.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MinimumHeightTrees {

	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		if (n == 1)
			return Arrays.asList(0);
		if (n == 2)
			return Arrays.asList(0, 1);

		HashMap<Integer, Set<Integer>> graph = new HashMap<>();
		for (int i = 0; i < n; i++)
			graph.put(i, new HashSet<>());

		for (int i = 0; i < edges.length; i++) {
			graph.get(edges[i][0]).add(edges[i][1]);
			graph.get(edges[i][1]).add(edges[i][0]);
		}
		List<Integer> res = new ArrayList<>();
		// find leaves
		for (int i = 0; i < n; i++) {
			if (graph.get(i).size() == 1) {
				res.add(i);
			}
		}

		while (n > 2) {
			n -= res.size();
			List<Integer> newres = new ArrayList<>();
			for (int i : res) {
				for (int neigh : graph.get(i)) {
					// graph.get(i).remove(neigh);
					graph.get(neigh).remove(i);
					if (graph.get(neigh).size() == 1) {
						newres.add(neigh);
					}
				}
			}
			res = newres;
		}

		return res;
	}

	// TLE
	public List<Integer> findMinHeightTrees2(int n, int[][] edges) {
		HashMap<Integer, List<Integer>> graph = new HashMap<>();

		for (int i = 0; i < n; i++) {
			List<Integer> l = new ArrayList<>();
			graph.put(i, l);
		}

		for (int i = 0; i < edges.length; i++) {

			int a = edges[i][0];
			int b = edges[i][1];
			List<Integer> l = graph.get(a);
			l.add(b);
			graph.put(a, l);

			l = graph.get(b);
			l.add(a);
			graph.put(b, l);
		}
		// System.out.println(graph);
		int min = Integer.MAX_VALUE;
		Set<Integer> nodes = graph.keySet();
		// Set<Integer> visited = new HashSet<>();
		Queue<Integer> q = new LinkedList<Integer>();
		HashMap<Integer, List<Integer>> heightToNodeList = new HashMap<>();
		for (int node : nodes) {
			q.add(node);
			Set<Integer> visited = new HashSet<>();
			visited.add(node);
			// System.out.println("node:"+node);
			int height = 0;
			while (!q.isEmpty()) {
				int size = q.size();
				while (size > 0) {
					int node1 = q.poll();
					visited.add(node1);
					List<Integer> l = graph.get(node1);
					for (int i : l) {
						if (visited.contains(i)) {
							continue;
						}
						q.add(i);
					}
					size--;
				}
				height++;
				if (height > min) {
					break;
				}
			}
			q.clear();
			min = Math.min(min, height);
			// System.out.println("min:"+min);
			// System.out.println("height:"+height);
			if (height == min) {
				if (heightToNodeList.containsKey(min)) {
					List<Integer> l = heightToNodeList.get(min);
					l.add(node);
					heightToNodeList.put(min, l);
				} else {
					List<Integer> l = new ArrayList<>();
					l.add(node);
					heightToNodeList.put(min, l);
				}
			}
		}

		return heightToNodeList.get(min);
	}

	public static void main(String[] args) {
		/*4
		[[1,0],[1,2],[1,3]]
		1
		[]
		6
		[[3,0],[3,1],[3,2],[3,4],[5,4]]
		2
		[[0,1]]*/
	}
}
