package com.ven.leetcode.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find
 * all possible paths from node 0 to node n - 1, and return them in any order.
 * 
 * The graph is given as follows: graph[i] is a list of all nodes you can visit
 * from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: graph = [[1,2},{3},{3},{]] Output: [[0,1,3},{0,2,3]] Explanation:
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3. Example 2:
 * 
 * 
 * Input: graph = [[4,3,1},{3,2,4},{3},{4},{]] Output:
 * [[0,4},{0,3,4},{0,1,3,4},{0,1,2,3,4},{0,1,4]] Example 3:
 * 
 * Input: graph = [[1},{]] Output: [[0,1]] Example 4:
 * 
 * Input: graph = [[1,2,3},{2},{3},{]] Output: [[0,1,2,3},{0,2,3},{0,3]] Example
 * 5:
 * 
 * Input: graph = [[1,3},{2},{3},{]] Output: [[0,1,2,3},{0,3]]
 * 
 * 
 * Constraints:
 * 
 * n == graph.length 2 <= n <= 15 0 <= graph[i][j] < n graph[i][j] != i (i.e.,
 * there will be no self-loops). The input graph is guaranteed to be a DAG.
 * 
 * @author Venkatesh Manohar
 *
 */
public class AllPathsFromSourcetoTarget {
	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> li = new ArrayList<List<Integer>>();
		ArrayList<Integer> l = new ArrayList<>();
		l.add(0);
		dfs(graph, 0, l, li);

		return li;
	}

	private void dfs(int[][] graph, int index, ArrayList<Integer> l, List<List<Integer>> li) {
		if (index == graph.length - 1) {
			li.add(new ArrayList<>(l));
			return;
		}

		for (int i : graph[index]) {
			l.add(i);
			dfs(graph, i, l, li);
			l.remove(l.size() - 1);
		}
	}

	public static void main(String[] args) {
		AllPathsFromSourcetoTarget a = new AllPathsFromSourcetoTarget();
		System.out.println(a.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));
		System.out.println(a.allPathsSourceTarget(new int[][] { { 4, 3, 1 }, { 3, 2, 4 }, { 3 }, { 4 }, {} }));
		System.out.println(a.allPathsSourceTarget(new int[][] { { 1 }, {} }));
		System.out.println(a.allPathsSourceTarget(new int[][] { { 1, 2, 3 }, { 2 }, { 3 }, {} }));
		System.out.println(a.allPathsSourceTarget(new int[][] { { 1, 3 }, { 2 }, { 3 }, {} }));
	}
}
