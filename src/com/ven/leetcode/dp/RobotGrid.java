package com.ven.leetcode.dp;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * 
 * Above is a 7 x 3 grid. How many possible unique paths are there?
 * 
 * Note: m and n will be at most 100.
 * 
 * Example 1:
 * 
 * Input: m = 3, n = 2 Output: 3 Explanation: From the top-left corner, there
 * are a total of 3 ways to reach the bottom-right corner: 1. Right -> Right ->
 * Down 2. Right -> Down -> Right 3. Down -> Right -> Right Example 2:
 * 
 * Input: m = 7, n = 3 Output: 28
 * 
 * @author Venkatesh Manohar
 *
 */
public class RobotGrid {
	public int uniquePaths(int m, int n) {
		// If either given row number is first or 
        // given column number is first 
        if (m == 1 || n == 1) 
            return 1; 
  
        // If diagonal movements are allowed then 
        // the last addition is required. 
        return uniquePaths(m - 1, n) + uniquePaths(m, n - 1); 
        // + uniquePaths(m-1, n-1); 
	}

	private int paths(int row, int col) {
		if (row == 0 && col == 0) {
			return 1;
		}
		if (row < 0 || col < 0) {
			return 0;
		}
		return paths(row - 1, col) + paths(row, col - 1);
	}

	public int uniquePathsIterative(int m, int n) {
		
		int arr[][] = new int[m][n];
		 // Count of paths to reach any cell in 
        // first column is 1 
        for (int i = 0; i < m; i++) 
        	arr[i][0] = 1; 
  
        // Count of paths to reach any cell in 
        // first column is 1 
        for (int j = 0; j < n; j++) 
        	arr[0][j] = 1; 
        
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr[i].length; j++) {

				arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
			}
		}
		return arr[m - 1][n - 1];
	}

	public static void main(String[] args) {
		RobotGrid rg = new RobotGrid();
		System.out.println(rg.uniquePaths(3, 2));
		System.out.println(rg.uniquePaths(7, 3));

		System.out.println(rg.uniquePathsIterative(3, 2));
		System.out.println(rg.uniquePathsIterative(7, 3));
	}
}
