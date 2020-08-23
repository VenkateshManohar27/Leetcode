package com.ven.leetcode.augchallenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumNumberVerticesReachAllNodes {
	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
		HashMap<Integer, Set<Integer>> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new HashSet<>());
		}
		for (int i = 0; i < edges.size(); i++) {
			map.get(edges.get(i).get(0)).add(edges.get(i).get(1));
		}
		HashSet<Integer> visited = new HashSet<>();
		Set<Integer> res = new HashSet<>();
		for (int i = 0; i < n; i++) {
			if (!visited.contains(i)) {
				res.add(i);
				visited.add(i);
				search(res, map, i, i, visited, new HashSet<>());
			}
		}

		return new ArrayList<>(res);
	}

	private void search(Set<Integer> res, Map<Integer, Set<Integer>> nodes, int cur, int start, Set<Integer> visited,
			Set<Integer> currVisited) {
		currVisited.add(cur);
		visited.add(cur);
		for (int next : nodes.get(cur)) {
			if (res.contains(next) && next != start) {
				res.remove(next);
			}
			if (!currVisited.contains(next)) {
				search(res, nodes, next, start, visited, currVisited);
			}
		}
	}

	public static void main(String[] args) {
		MinimumNumberVerticesReachAllNodes m = new MinimumNumberVerticesReachAllNodes();
		int[][] arr = new int[][] { { 0, 1 }, { 0, 2 }, { 2, 5 }, { 3, 4 }, { 4, 2 } };
		List<List<Integer>> li = new ArrayList<List<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			List<Integer> list = new ArrayList<>();
			list.add(arr[i][0]);
			list.add(arr[i][1]);
			li.add(list);
		}
		System.out.println(m.findSmallestSetOfVertices(6, li));
		
		arr = new int[][] { {0,1}, {2,1}, {3,1}, {1,4}, {2,4} };
				
				li = new ArrayList<List<Integer>>();
				for (int i = 0; i < arr.length; i++) {
					List<Integer> list = new ArrayList<>();
					list.add(arr[i][0]);
					list.add(arr[i][1]);
					li.add(list);
				}
				System.out.println(m.findSmallestSetOfVertices(5, li));
				
	}
}
