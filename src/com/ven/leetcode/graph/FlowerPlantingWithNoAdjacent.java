package com.ven.leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * You have n gardens, labeled from 1 to n, and an array paths where paths[i] =
 * [xi, yi] describes the existence of a bidirectional path from garden xi to
 * garden yi. In each garden, you want to plant one of 4 types of flowers.
 * 
 * There is no garden that has more than three paths coming into or leaving it.
 * 
 * Your task is to choose a flower type for each garden such that, for any two
 * gardens connected by a path, they have different types of flowers.
 * 
 * Return any such a choice as an array answer, where answer[i] is the type of
 * flower planted in the (i+1)th garden. The flower types are denoted 1, 2, 3,
 * or 4. It is guaranteed an answer exists.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 3, paths = [[1,2],[2,3],[3,1]] Output: [1,2,3] Example 2:
 * 
 * Input: n = 4, paths = [[1,2],[3,4]] Output: [1,2,1,2] Example 3:
 * 
 * Input: n = 4, paths = [[1,2],[2,3],[3,4],[4,1],[1,3],[2,4]] Output: [1,2,3,4]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 104 0 <= paths.length <= 2 * 104 paths[i].length == 2 1 <= xi, yi
 * <= n xi != yi No garden has four or more paths coming into or leaving it.
 * 
 * @author Venkatesh Manohar
 *
 */
public class FlowerPlantingWithNoAdjacent {
	public int[] gardenNoAdj(int n, int[][] paths) {
		int[] res = new int[n];
		HashMap<Integer, Set<Integer>> g = new HashMap<>();

		for (int i = 1; i <= n; i++) {
			g.put(i, new HashSet<Integer>());
		}

		for (int i = 0; i < paths.length; i++) {
			g.get(paths[i][0]).add(paths[i][1]);
			g.get(paths[i][1]).add(paths[i][0]);
		}

		for (int i = 1; i <= n; i++) {
			HashSet<Integer> neighborFlowers = new HashSet<Integer>();
			for (int j : g.get(i)) {
				neighborFlowers.add(res[j - 1]);
			}
			for (int k = 1; k <= 4; k++) {
				if (!neighborFlowers.contains(k)) {
					res[i - 1] = k;
					break;
				}
			}
		}
		return res;
	}
}
