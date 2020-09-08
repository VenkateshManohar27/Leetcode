package com.ven.leetcode.bweek34;

/**
 * Given a square matrix mat, return the sum of the matrix diagonals.
 * 
 * Only include the sum of all the elements on the primary diagonal and all the
 * elements on the secondary diagonal that are not part of the primary diagonal.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[1,2,3], [4,5,6], [7,8,9]] Output: 25 Explanation: Diagonals
 * sum: 1 + 5 + 9 + 3 + 7 = 25 Notice that element mat[1][1] = 5 is counted only
 * once. Example 2:
 * 
 * Input: mat = [[1,1,1,1], [1,1,1,1], [1,1,1,1], [1,1,1,1]] Output: 8 Example
 * 3:
 * 
 * Input: mat = [[5]] Output: 5
 * 
 * @author Venkatesh Manohar
 *
 */
public class MatrixDiagonalSum {
	public int diagonalSum(int[][] mat) {
		int sum = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				if (i == j && mat[i][j] != -1) {
					sum += mat[i][j];
					mat[i][j] =-1;
				}
			}
		}
		
		for (int i = 0, j = mat[i].length-1; i < mat.length && j >= 0; i++, j--) {
			if (mat[i][j] != -1) {
					sum += mat[i][j];
					mat[i][j] =-1;
			}
		}

		return sum;
	}

	public static void main(String[] args) {
		MatrixDiagonalSum m = new MatrixDiagonalSum();
		System.out.println(m.diagonalSum(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
		System.out.println(m.diagonalSum(new int[][] { {1,1,1,1}, { 1,1,1,1 }, { 1,1,1,1 } , { 1,1,1,1 }}));
		System.out.println(m.diagonalSum(new int[][] { { 5 } }));
		System.out.println(m.diagonalSum(new int[][] { {  } }));
	}
}
