package com.ven.leetcode.apr2021.challenge;

/**
 * Given an m x n integers matrix, return the length of the longest increasing
 * path in matrix.
 * 
 * From each cell, you can either move in four directions: left, right, up, or
 * down. You may not move diagonally or move outside the boundary (i.e.,
 * wrap-around is not allowed).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[9,9,4],[6,6,8],[2,1,1]] Output: 4 Explanation: The longest
 * increasing path is [1, 2, 6, 9]. Example 2:
 * 
 * 
 * Input: matrix = [[3,4,5],[3,2,6],[2,2,1]] Output: 4 Explanation: The longest
 * increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed. Example 3:
 * 
 * Input: matrix = [[1]] Output: 1
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length n == matrix[i].length 1 <= m, n <= 200 0 <= matrix[i][j]
 * <= 231 - 1
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestIncreasingPathMatrix {
	Integer[][] dp = null;

	public int longestIncreasingPath(int[][] a) {
		if (a.length == 0)
			return 0;
		int m = a.length, n = a[0].length;
		dp = new Integer[m][n];
		int max = 0;
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				max = Math.max(max, dfs(a, i, j, -Integer.MAX_VALUE));
		return max;
	}

	// dp[i][j] = longest from this node
	private int dfs(int[][] a, int i, int j, int prev) {
		if (i < 0 || j < 0 || i == a.length || j == a[0].length || prev >= a[i][j])
			return 0;
		if (dp[i][j] != null)
			return dp[i][j];

		dp[i][j] = Math.max(1, 1 + dfs(a, i + 1, j, a[i][j]));
		dp[i][j] = Math.max(dp[i][j], 1 + dfs(a, i - 1, j, a[i][j]));
		dp[i][j] = Math.max(dp[i][j], 1 + dfs(a, i, j - 1, a[i][j]));
		dp[i][j] = Math.max(dp[i][j], 1 + dfs(a, i, j + 1, a[i][j]));
		return dp[i][j];
	}
}
