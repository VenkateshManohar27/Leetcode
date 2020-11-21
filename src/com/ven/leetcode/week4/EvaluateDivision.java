package com.ven.leetcode.week4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ven.utility.ArrayUtility;

/**
 * You are given equations in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating-point number). Given
 * some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * The input is always valid. You may assume that evaluating the queries will
 * result in no division by zero and there is no contradiction.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries =
 * [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]] Output:
 * [6.00000,0.50000,-1.00000,1.00000,-1.00000] Explanation: Given: a / b = 2.0,
 * b / c = 3.0 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x =
 * ? return: [6.0, 0.5, -1.0, 1.0, -1.0 ] Example 2:
 * 
 * Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 * queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]] Output:
 * [3.75000,0.40000,5.00000,0.20000] Example 3:
 * 
 * Input: equations = [["a","b"]], values = [0.5], queries =
 * [["a","b"],["b","a"],["a","c"],["x","y"]] Output:
 * [0.50000,2.00000,-1.00000,-1.00000]
 * 
 * 
 * Constraints:
 * 
 * 1 <= equations.length <= 20 equations[i].length == 2 1 <= equations[i][0],
 * equations[i][1] <= 5 values.length == equations.length 0.0 < values[i] <=
 * 20.0 1 <= queries.length <= 20 queries[i].length == 2 1 <= queries[i][0],
 * queries[i][1] <= 5 equations[i][0], equations[i][1], queries[i][0],
 * queries[i][1] consist of lower case English letters and digits.
 * 
 * @author Venkatesh Manohar
 *
 */
class Node {
	String str;
	Double cost;

	public Node(String str, Double cost) {
		this.str = str;
		this.cost = cost;
	}
}

public class EvaluateDivision {
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		double[] res = new double[queries.size()];
		HashMap<String, List<Node>> graph = new HashMap<>();
		for (int i = 0; i < equations.size(); i++) {
			List<String> curr = equations.get(i);
			if (!graph.containsKey(curr.get(0))) {
				graph.put(curr.get(0), new ArrayList<Node>());
			}
			if (!graph.containsKey(curr.get(1))) {
				graph.put(curr.get(1), new ArrayList<Node>());
			}
			graph.get(curr.get(0)).add(new Node(curr.get(1), values[i]));
			graph.get(curr.get(1)).add(new Node(curr.get(0), 1/values[i]));
		}
		for (int i = 0; i < queries.size(); i++) {
			List<String> query = queries.get(i);
			if (graph.containsKey(query.get(0)) && graph.containsKey(query.get(1))) {
				res[i] = bfs(query.get(0), query.get(1), graph);
			} else {
				res[i] = -1.0;
			}
		}
		return res;
	}

	private double bfs(String start, String end, HashMap<String, List<Node>> graph) {
		Queue<Node> q = new LinkedList<Node>();
		HashSet<String> visited = new HashSet<>();
		q.add(new Node(start, 1.0));
		visited.add(start);
		double res = -1.0;
		while (!q.isEmpty()) {
			Node curr = q.poll();
			if (curr.str.equals(end)) {
				return curr.cost;
			}
			List<Node> li = graph.get(curr.str);
			for (Node n : li) {
				if (visited.contains(n.str))
					continue;
				q.add(new Node(n.str, curr.cost * n.cost));
				visited.add(n.str);
			}
		}
		return res;
	}

	public static void main(String[] args) {
		EvaluateDivision e = new EvaluateDivision();
		List<List<String>> equations = new ArrayList<List<String>>();
		equations.add(Arrays.asList(new String[] { "a", "b" }));
		equations.add(Arrays.asList(new String[] { "b", "c" }));

		// [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
		List<List<String>> queries = new ArrayList<List<String>>();
		queries.add(Arrays.asList(new String[] { "a", "c" }));
		queries.add(Arrays.asList(new String[] { "b", "a" }));
		queries.add(Arrays.asList(new String[] { "a", "e" }));
		queries.add(Arrays.asList(new String[] { "a", "a" }));
		queries.add(Arrays.asList(new String[] { "x", "x" }));
		ArrayUtility.print(e.calcEquation(equations, new double[] { 2.0, 3.0 }, queries));

		equations = new ArrayList<List<String>>();
		equations.add(Arrays.asList(new String[] { "a", "b" }));
		equations.add(Arrays.asList(new String[] { "b", "c" }));
		equations.add(Arrays.asList(new String[] { "bc", "cd" }));

		// ["a","c"],["c","b"],["bc","cd"],["cd","bc"]
		queries = new ArrayList<List<String>>();
		queries.add(Arrays.asList(new String[] { "a", "c" }));
		queries.add(Arrays.asList(new String[] { "c", "b" }));
		queries.add(Arrays.asList(new String[] { "bc", "cd" }));
		queries.add(Arrays.asList(new String[] { "cd", "bc" }));

		ArrayUtility.print(e.calcEquation(equations, new double[] { 1.5, 2.5, 5.0 }, queries));
	}
}
