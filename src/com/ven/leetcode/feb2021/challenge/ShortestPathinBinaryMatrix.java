package com.ven.leetcode.feb2021.challenge;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import com.ven.utility.ArrayUtility;

public class ShortestPathinBinaryMatrix {
	// DP does not work DP doesn't work because you will not calculate all 8 paths
	// before calculating a path. Let see 1,1 now all the 8 paths are valid but not
	// all 8 paths are available to you. That's the difference between this and
	// other DP problems.

	public int shortestPathBinaryMatrixDP(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		if (grid[0][0] == 1) {
			return -1;
		}
		for (int i = 0; i < m; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0)
					continue;
				if (grid[i][j] == 1) {
					continue;
				}
				int min = Integer.MAX_VALUE;
				// check up
				if (i > 0 && grid[i - 1][j] == 0 && dp[i - 1][j] != Integer.MAX_VALUE) {
					min = Math.min(min, dp[i - 1][j] + 1);
				}

				// check diagonal upper left
				if (i > 0 && j > 0 && grid[i - 1][j - 1] == 0 && dp[i - 1][j - 1] != Integer.MAX_VALUE) {
					min = Math.min(min, dp[i - 1][j - 1] + 1);
				}
				// check diagnonal upper right
				if (i > 0 && j < n - 2 && grid[i - 1][j + 1] == 0 && dp[i - 1][j + 1] != Integer.MAX_VALUE) {
					min = Math.min(min, dp[i - 1][j + 1] + 1);
				}
				// check left
				if (j > 0 && grid[i][j - 1] == 0 && dp[i][j - 1] != Integer.MAX_VALUE) {
					min = Math.min(min, dp[i][j - 1] + 1);
				}
				// check right
				if (j < n - 1 && grid[i][j + 1] == 0 && dp[i][j + 1] != Integer.MAX_VALUE) {
					min = Math.min(min, dp[i][j + 1] + 1);
				}
				// check diagonal lower left
				if (i < m - 1 && j > 0 && grid[i + 1][j - 1] == 0 && dp[i + 1][j - 1] != Integer.MAX_VALUE) {
					min = Math.min(min, dp[i + 1][j - 1] + 1);
				}
				// check down
				if (i < m - 1 && grid[i + 1][j] == 0 && dp[i + 1][j] != Integer.MAX_VALUE) {
					min = Math.min(min, dp[i + 1][j] + 1);
				}
				// check diagonal lower right
				if (i < m - 1 && j < n - 1 && grid[i + 1][j + 1] == 0 && dp[i + 1][j + 1] != Integer.MAX_VALUE) {
					min = Math.min(min, dp[i + 1][j + 1] + 1);
				}

				dp[i][j] = min;
			}
		}

		ArrayUtility.print(dp);
		return (dp[m - 1][n - 1] == Integer.MAX_VALUE) ? -1 : dp[m - 1][n - 1];
	}

	public int shortestPathBinaryMatrix(int[][] grid) {
		int[] DIRS = { 1, -1, 0 };
		int m = grid.length - 1;
		int n = grid[0].length - 1;
		if (grid[0][0] == 1 || grid[m][n] == 1) {
			return -1;
		}

		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { 0, 0 });
		grid[0][0] = 1;
		int len = 0;

		while (!q.isEmpty()) {
			len++;
			int size = q.size();
			while (size > 0) {
				int[] cell = q.poll();
				int r = cell[0];
				int c = cell[1];
				if (r == m && c == n) {
					return len;
				}
				for (int rd : DIRS) {
					for (int cd : DIRS) {
						if (rd == 0 && cd == 0)
							continue;
						int newR = r + rd, newC = c + cd;
						if (newR >= 0 && newR <= m && newC >= 0 && newC <= n && grid[newR][newC] == 0) {
							q.add(new int[] { newR, newC });
							grid[newR][newC] = 1;
						}
					}
				}

				size--;
			}

		}

		return -1;
	}

	public static void main(String[] args) {
		ShortestPathinBinaryMatrix s = new ShortestPathinBinaryMatrix();
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0, 1 }, { 1, 0 } }));
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0 } }));
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 1 } }));
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 0 } }));
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 1 }, { 1, 1, 0 } }));
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 0, 0 }, { 1, 1, 0 } }));
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 0 } }));
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0, 0, 0 }, { 1, 1, 0 }, { 1, 1, 1 } }));
		System.out.println(s.shortestPathBinaryMatrix(new int[][] { { 0, 0, 1, 0, 0, 0, 0 }, { 0, 1, 0, 0, 0, 0, 1 },
				{ 0, 0, 1, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1, 1, 0 }, { 1, 0, 0, 1, 1, 0, 0 }, { 1, 1, 1, 1, 1, 0, 1 },
				{ 0, 0, 1, 0, 0, 0, 0 } }));
	}
}
