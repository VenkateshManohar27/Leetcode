package com.ven.leetcode.june2021.challenge;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's
 * (representing land) connected 4-directionally (horizontal or vertical.) You
 * may assume all four edges of the grid are surrounded by water.
 * 
 * The area of an island is the number of cells with a value 1 in the island.
 * 
 * Return the maximum area of an island in grid. If there is no island, return
 * 0.
 * 
 * Example 1:
 * 
 * Input: grid =
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6 Explanation: The answer is not 11, because the island must be
 * connected 4-directionally. Example 2:
 * 
 * Input: grid = [[0,0,0,0,0,0,0,0]] Output: 0
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 50 grid[i][j] is either 0
 * or 1.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaxAreaofIsland {
	public int maxAreaOfIsland(int[][] grid) {
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		int max = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1 && !visited[i][j]) {
					// visited[i][j] = true;
					int res = expand(i, j, grid, visited) + 1;
					max = Math.max(max, res);
				}
			}
		}
		return max;
	}

	private int expand(int r, int c, int[][] g, boolean[][] v) {

		int res = 0;
		if (v[r][c]) {
			return res;
		}
		v[r][c] = true;
		// left
		if (c > 0 && g[r][c - 1] == 1 && !v[r][c - 1]) {
			res += expand(r, c - 1, g, v) + 1;
		}
		// right
		if (c < g[r].length - 1 && g[r][c + 1] == 1 && !v[r][c + 1]) {
			res += expand(r, c + 1, g, v) + 1;
		}
		// up
		if (r > 0 && g[r - 1][c] == 1 && !v[r - 1][c]) {
			res += expand(r - 1, c, g, v) + 1;
		}
		// down
		if (r < g.length - 1 && g[r + 1][c] == 1 && !v[r + 1][c]) {
			res += expand(r + 1, c, g, v) + 1;
		}
		return res;
	}
}
