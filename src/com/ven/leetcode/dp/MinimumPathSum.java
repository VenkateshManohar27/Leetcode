package com.ven.leetcode.dp;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top
 * left to bottom right which minimizes the sum of all numbers along its path.
 * 
 * Note: You can only move either down or right at any point in time.
 * 
 * Example:
 * 
 * Input: [ [1,3,1], [1,5,1], [4,2,1] ] Output: 7 Explanation: Because the path
 * 1→3→1→1→1 minimizes the sum.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		int row = grid.length;
		int col = grid[0].length;
		int[][] arr = new int[row][col];
		arr[0][0] = grid[0][0];
		// Fill first row as all cell can only be reached from their left cell
		for (int i = 1; i < grid[0].length; i++) {
			arr[0][i] = grid[0][i] + arr[0][i - 1];
		}

		// Fill first column as all cell can only be reached from their top cell
		for (int i = 1; i < row; i++) {
			arr[i][0] = grid[i][0] + arr[i - 1][0];
		}

		for (int i = 1; i < row; i++) {
			for (int j = 1; j < col; j++) {
				arr[i][j] = Math.min(arr[i][j - 1] + grid[i][j], arr[i - 1][j] + grid[i][j]);
			}
		}

		return arr[row - 1][col - 1];
	}

	public static void main(String[] args) {
		int arr[][] = new int[][] { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		MinimumPathSum mps = new MinimumPathSum();
		System.out.println(mps.minPathSum(arr));
	}
}
