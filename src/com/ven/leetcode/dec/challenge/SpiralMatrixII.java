package com.ven.leetcode.dec.challenge;

/**
 * Given a positive integer n, generate an n x n matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: [[1,2,3],[8,9,4],[7,6,5]] Example 2:
 * 
 * Input: n = 1 Output: [[1]]
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 20
 * 
 * @author Venkatesh Manohar
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int count = n * n;
		int[][] m = new int[n][n];
		int colstart = 0, colend = n - 1;
		int rowstart = 0, rowend = n - 1;
		int num = 1;
		while (num <= count) {
			// go right
			for (int row = rowstart, col = colstart; col <= colend; col++) {
				m[row][col] = num++;
			}
			rowstart += 1;
			if (num > count)
				break;
			// go down
			for (int row = rowstart, col = colend; row <= rowend; row++) {
				m[row][col] = num++;
			}
			colend -= 1;
			if (num > count)
				break;
			// go left
			for (int row = rowend, col = colend; col >= colstart; col--) {
				m[row][col] = num++;
			}
			rowend -= 1;
			if (num > count)
				break;

			// go up
			for (int row = rowend, col = colstart; row >= rowstart; row--) {
				m[row][col] = num++;
			}
			colstart += 1;

			if (num > count)
				break;
		}
		return m;
	}
}
