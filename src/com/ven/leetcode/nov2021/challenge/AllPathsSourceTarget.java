package com.ven.leetcode.nov2021.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find
 * all possible paths from node 0 to node n - 1 and return them in any order.
 * 
 * The graph is given as follows: graph[i] is a list of all nodes you can visit
 * from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: graph = [[1,2],[3],[3],[]] Output: [[0,1,3],[0,2,3]] Explanation:
 * There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3. Example 2:
 * 
 * 
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]] Output:
 * [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]] Example 3:
 * 
 * Input: graph = [[1],[]] Output: [[0,1]] Example 4:
 * 
 * Input: graph = [[1,2,3],[2],[3],[]] Output: [[0,1,2,3],[0,2,3],[0,3]] Example
 * 5:
 * 
 * Input: graph = [[1,3],[2],[3],[]] Output: [[0,1,2,3],[0,3]]
 * 
 * 
 * Constraints:
 * 
 * n == graph.length 2 <= n <= 15 0 <= graph[i][j] < n graph[i][j] != i (i.e.,
 * there will be no self-loops). All the elements of graph[i] are unique. The
 * input graph is guaranteed to be a DAG.
 * 
 * @author Venkatesh Manohar
 *
 */
public class AllPathsSourceTarget {

	public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();

		List<Integer> li = new ArrayList<>();
		li.add(0);
		backtrack(0, li, l, graph);

		return l;
	}

	private void backtrack(int i, List<Integer> li, List<List<Integer>> l, int[][] g) {
		if (i == g.length - 1) {
			l.add(li);
			return;
		}
		int[] nodes = g[i];

		for (int j = 0; j < nodes.length; j++) {
			List<Integer> lis = new ArrayList<>(li);
			lis.add(nodes[j]);
			backtrack(nodes[j], lis, l, g);
		}

	}

	public List<List<Integer>> allPathsSourceTargetDFS(int[][] graph) {
		List<List<Integer>> l = new ArrayList<List<Integer>>();

		List<Integer> li = new ArrayList<>();
		li.add(0);
		dfs(0, li, l, graph);

		return l;
	}

	private void dfs(int i, List<Integer> li, List<List<Integer>> l, int[][] g) {
		if (i == g.length - 1) {
			l.add(li);
			return;
		}
		int[] nodes = g[i];

		for (int j = 0; j < nodes.length; j++) {
			li.add(nodes[i]);
			dfs(i, li, l, g);
			li.remove(li.size()-1);
		}
	}

	public static void main(String[] args) {
		AllPathsSourceTarget a = new AllPathsSourceTarget();
		System.out.println(a.allPathsSourceTarget(new int[][] { { 1, 2 }, { 3 }, { 3 }, {} }));

	}
}
