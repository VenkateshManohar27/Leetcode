package com.ven.leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Graph {

	HashMap<Integer, List<Integer>> map = null;
	int N;

	public Graph(int n) {
		super();
		this.N = n;
		map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}
	}

	public void addEdge(int i, int j) {
		map.get(i).add(j);
	}

	public boolean checkCycle() {
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				if (dfs(i, visited, -1))
					return true;
			}
		}

		return false;
	}

	private boolean dfs(int i, boolean[] visited, int parent) {
		visited[i] = true;

		for (Integer neighbor : map.get(i)) {
			if (!visited[neighbor]) {
				return dfs(neighbor, visited, i);
			} else if (parent != neighbor) {
				return true;
			}
		}
		return false;
	}
	
}
