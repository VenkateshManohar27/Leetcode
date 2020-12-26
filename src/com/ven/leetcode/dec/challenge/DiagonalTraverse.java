package com.ven.leetcode.dec.challenge;

import com.ven.utility.ArrayUtility;

/**
 * Given a matrix of M x N elements (M rows, N columns), return all elements of
 * the matrix in diagonal order as shown in the below image.
 * 
 * Example:
 * 
 * Input: [ [ 1, 2, 3 ], [ 4, 5, 6 ], [ 7, 8, 9 ] ]
 * 
 * Output: [1,2,4,7,5,3,6,8,9]
 * 
 * Explanation:
 * 
 * Note:
 * 
 * The total number of elements of the given matrix will not exceed 10,000.
 * 
 * @author Venkatesh Manohar
 *
 */
public class DiagonalTraverse {
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return new int[] {};
		}
		int m = matrix.length;
		int n = matrix[0].length;

		int[] res = new int[m * n];
		int count = m * n;
		int row = 0;
		int col = 0;
		int i = 0;
		while (count > 0) {
			int r = row;
			int c = col;
			while (r >= 0 && c < n) {
				System.out.println("r:" + r + " , c:" + c);
				res[i++] = matrix[r][c];
				System.out.println(res[i - 1]);
				r--;
				c++;
				count--;
			}
			if (row < m - 1) {
				row++;
			} else if (col < n - 1) {
				col++;
			}

		}
		return res;
	}

	public static void main(String[] args) {
		DiagonalTraverse d = new DiagonalTraverse();
		ArrayUtility.print(d.findDiagonalOrder(new int[][] {{1,2,3}}));
	}
}
