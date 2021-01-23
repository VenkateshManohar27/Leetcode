package com.ven.leetcode.jan2021.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ven.utility.ArrayUtility;

/**
 * A matrix diagonal is a diagonal line of cells starting from some cell in
 * either the topmost row or leftmost column and going in the bottom-right
 * direction until reaching the matrix's end. For example, the matrix diagonal
 * starting from mat[2][0], where mat is a 6 x 3 matrix, includes cells
 * mat[2][0], mat[3][1], and mat[4][2].
 * 
 * Given an m x n matrix mat of integers, sort each matrix diagonal in ascending
 * order and return the resulting matrix.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]] Output:
 * [[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * 
 * 
 * Constraints:
 * 
 * m == mat.length n == mat[i].length 1 <= m, n <= 100 1 <= mat[i][j] <= 100
 * 
 * @author Venkatesh Manohar
 *
 */
public class SortMatrixDiagonally {
	int[][] mat;
	int n, m;

	// Sort the current diagonal
	public void sortDiagonal(int i, int j) {
		List<Integer> diagonal = new ArrayList<>();
		// store the current diagonal
		// in the list
		while (i < n && j < m) {
			diagonal.add(mat[i][j]);
			++i;
			++j;
		}

		// sort the diagonal values
		Collections.sort(diagonal);

		// push the sorted values
		// back into the matrix
		while (i > 0 && j > 0) {
			--i;
			--j;
			mat[i][j] = diagonal.remove(diagonal.size() - 1);
		}
	}

	public int[][] diagonalSort(int[][] mat) {
		this.mat = mat;
		n = mat.length;
		m = mat[0].length;

		// sort all diagonals
		// in the lower left corner
		for (int i = 0; i < n; ++i) {
			sortDiagonal(i, 0);
		}
		// sort all diagonals
		// in the upper right corner
		for (int j = 0; j < m; ++j) {
			sortDiagonal(0, j);
		}
		return mat;
	}

	public static void main(String[] args) {
		SortMatrixDiagonally s = new SortMatrixDiagonally();
		ArrayUtility.print(s.diagonalSort(new int[][] { { 3, 3, 1, 1 }, { 2, 2, 1, 2 }, { 1, 1, 1, 2 } }));
		ArrayUtility.print(s.diagonalSort(new int[][] { { 3, 3, 1, 1 } }));
		ArrayUtility
				.print(s.diagonalSort(new int[][] { { 4, 3, 2, 1 }, { 4, 3, 2, 1 }, { 4, 3, 2, 1 }, { 4, 3, 2, 1 } }));
	}
}
