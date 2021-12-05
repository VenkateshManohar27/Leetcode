package com.ven.leetcode.oct2021.challenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given an m x n grid where each cell can have one of three values:
 * 
 * 0 representing an empty cell, 1 representing a fresh orange, or 2
 * representing a rotten orange. Every minute, any fresh orange that is
 * 4-directionally adjacent to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1.
 * 
 * Example 1:
 * 
 * Input: grid = [[2,1,1],[1,1,0],[0,1,1]] Output: 4 Example 2:
 * 
 * Input: grid = [[2,1,1],[0,1,1],[1,0,1]] Output: -1 Explanation: The orange in
 * the bottom left corner (row 2, column 0) is never rotten, because rotting
 * only happens 4-directionally. Example 3:
 * 
 * Input: grid = [[0,2]] Output: 0 Explanation: Since there are already no fresh
 * oranges at minute 0, the answer is just 0.
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 10 grid[i][j] is 0, 1, or
 * 2.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RottingOranges {

	public int orangesRotting(int[][] grid) {
		int fresh = 0;
		int min = 0;
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					fresh++;
				}
				if (grid[i][j] == 2) {
					q.add(new int[] { i, j });
				}
			}
		}

		if(fresh == 0) return 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				int[] e = q.poll();
				int r = e[0];
				int c = e[1];
				//check up
				if(r > 0 && grid[r-1][c] == 1) {
					grid[r-1][c] = 2;
					q.add(new int[] {r-1, c});
					fresh--;
					if(fresh == 0) break;
				}
				//check left
				if(c > 0 && grid[r][c-1] == 1) {
					grid[r][c-1] = 2;
					q.add(new int[] {r, c-1});
					fresh--;
					if(fresh == 0) break;
				}
				//check right
				if(c < grid[0].length-1 && grid[r][c+1] == 1) {
					grid[r][c+1] = 2;
					q.add(new int[] {r, c+1});
					fresh--;
					if(fresh == 0) break;
				}
				//check down
				if(r < grid.length-1 && grid[r+1][c] == 1) {
					grid[r+1][c] = 2;
					q.add(new int[] {r+1, c});
					fresh--;
					if(fresh == 0) break;
				}
				size--;
			}
			
			min++;
			if(fresh == 0) break;
		}

		return (fresh == 0) ? min : -1;
	}

	public static void main(String[] args) {
		RottingOranges r = new RottingOranges();
		System.out.println(r.orangesRotting(new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } }));
		System.out.println(r.orangesRotting(new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } }));
		System.out.println(r.orangesRotting(new int[][] { { 0, 2} }));
		System.out.println(r.orangesRotting(new int[][] { { 0, 1} }));
	}
}
