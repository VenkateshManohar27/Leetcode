package com.ven.leetcode.jan2021.challenge;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * There are n cities. Some of them are connected, while some are not. If city a
 * is connected directly with city b, and city b is connected directly with city
 * c, then city a is connected indirectly with city c.
 * 
 * A province is a group of directly or indirectly connected cities and no other
 * cities outside of the group.
 * 
 * You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the
 * ith city and the jth city are directly connected, and isConnected[i][j] = 0
 * otherwise.
 * 
 * Return the total number of provinces.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]] Output: 2 Example 2:
 * 
 * 
 * Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]] Output: 3
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 200 n == isConnected.length n == isConnected[i].length
 * isConnected[i][j] is 1 or 0. isConnected[i][i] == 1 isConnected[i][j] ==
 * isConnected[j][i]
 * 
 * @author Venkatesh Manohar
 *
 */
public class NumberofProvinces {
	public int findCircleNum(int[][] isConnected) {
		Set<Integer>[] g = new HashSet[isConnected.length];
		int provinces = 0;
		for (int i = 0; i < isConnected.length; i++) {
			g[i] = new HashSet<>();
			for (int j = 0; j < isConnected.length; j++) {
				if (isConnected[i][j] == 1) {
					g[i].add(j);
				}
			}
		}
		boolean visited[] = new boolean[isConnected.length];
		for (int i = 0; i < g.length; i++) {
			if (!visited[i]) {
				++provinces;
				bfs(i, g, visited);
			}
		}

		return provinces;
	}

	private void bfs(int i, Set<Integer>[] g, boolean[] visited) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i);
		while (!q.isEmpty()) {
			int node = q.poll();
			visited[node] = true;
			Set<Integer> s = g[node];
			Iterator<Integer> it = s.iterator();
			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					q.add(n);
				}
			}
		}
	}

	public static void main(String[] args) {
		NumberofProvinces n = new NumberofProvinces();
		System.out.println(n.findCircleNum(new int[][] { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } }));
		System.out.println(n.findCircleNum(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } }));
	}
}
