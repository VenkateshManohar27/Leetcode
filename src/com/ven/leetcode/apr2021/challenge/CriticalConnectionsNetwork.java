package com.ven.leetcode.apr2021.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * There are n servers numbered from 0 to n-1 connected by undirected
 * server-to-server connections forming a network where connections[i] = [a, b]
 * represents a connection between servers a and b. Any server can reach any
 * other server directly or indirectly through the network.
 * 
 * A critical connection is a connection that, if removed, will make some server
 * unable to reach some other server.
 * 
 * Return all critical connections in the network in any order.
 * 
 * Example 1:
 * 
 * Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]] Output: [[1,3]]
 * Explanation: [[3,1]] is also accepted.
 * 
 * Constraints:
 * 
 * 1 <= n <= 10^5 n-1 <= connections.length <= 10^5 connections[i][0] !=
 * connections[i][1] There are no repeated connections.
 * 
 * @author Venkatesh Manohar
 *
 */
public class CriticalConnectionsNetwork {
	List<List<Integer>> cc = new ArrayList<List<Integer>>();
	int timer = 0;
	List<Integer>[] adj;
	boolean[] v = null;
	int[] timestamp;
	List<List<Integer>> ans;

	// We need a global integer to represent the timer
	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		adj = new ArrayList[n];
		v = new boolean[n];
		timestamp = new int[n];
		for(int i = 0; i < n; i++) adj[i] = new ArrayList<>();
		for(List<Integer> conn : connections) {
			adj[conn.get(0)].add(conn.get(1));
			adj[conn.get(1)].add(conn.get(0));
		}

		ans = new ArrayList<>();
		dfs(-1, 0);
		return ans;
	}

	private void dfs(int prev, int curr) {
		v[curr] = true;
		int currtime = timer;
		timestamp[curr] = currtime;
		timer++;
		
		for (int other: adj[curr]) {
			if(other == prev) continue;
			if(!v[other]) {
				dfs(curr, other);
			}
			timestamp[curr] = Math.min(timestamp[curr], timestamp[other]);
			if(currtime < timestamp[other]) ans.add(Arrays.asList(curr, other));
		}
	}
}
