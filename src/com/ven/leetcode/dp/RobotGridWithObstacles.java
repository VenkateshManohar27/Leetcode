package com.ven.leetcode.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * 
 * 
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * Input: [ [0,0,0], [0,1,0], [0,0,0] ] Output: 2 Explanation: There is one
 * obstacle in the middle of the 3x3 grid above. There are two ways to reach the
 * bottom-right corner: 1. Right -> Right -> Down -> Down 2. Down -> Down ->
 * Right -> Right
 * 
 * @author Venkatesh Manohar
 *
 */
public class RobotGridWithObstacles {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int arr[][] = new int[m][n];
		// Count of paths to reach any cell in
		// first column is 1
		for (int i = 0; i < m; i++) {
			if (obstacleGrid[i][0] == 1) {
				break;
			}
			arr[i][0] = 1;
		}

		// Count of paths to reach any cell in
		// first column is 1
		for (int j = 0; j < n; j++) {
			if (obstacleGrid[0][j] == 1) {
				break;
			}
			arr[0][j] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {
				if (obstacleGrid[i][j] == 1) {
					continue;
				}
				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		return arr[m - 1][n - 1];
	}

	public static void main(String[] args) {
		RobotGridWithObstacles rg = new RobotGridWithObstacles();
		int arr[][] = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		System.out.println(rg.uniquePathsWithObstacles(arr));

	}
}
