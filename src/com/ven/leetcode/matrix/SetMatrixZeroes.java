package com.ven.leetcode.matrix;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.ven.utility.ArrayUtility;

public class SetMatrixZeroes {
	public void setZeroes(int[][] matrix) {
		Set<Integer> rows = new HashSet<>();
		Set<Integer> cols = new HashSet<>();
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					rows.add(i);
					cols.add(j);
				}
			}
		}

		Iterator<Integer> it = rows.iterator();
		while (it.hasNext()) {
			Integer row = it.next();
			for (int i = 0; i < matrix[row].length; i++) {
				matrix[row][i] = 0;
			}
		}

		it = cols.iterator();
		while (it.hasNext()) {
			Integer col = it.next();
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][col] = 0;
			}
		}
	}

	public void setZeroes2(int[][] matrix) {
		boolean firstRowHasZero = false;
		boolean firstColHasZero = false;
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
					if (i == 0)
						firstRowHasZero = true;
					if (j == 0)
						firstColHasZero = true;
				}
			}
		}

		for (int i = 1; i < matrix.length; i++) {
			for (int j = 1; j < matrix[i].length; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if(firstRowHasZero) {
			for (int i = 0; i < matrix[0].length; i++) {
				matrix[0][i] = 0;
			}
		}
		if(firstColHasZero) {
			for (int i = 0; i < matrix.length; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	public static void main(String[] args) {
		SetMatrixZeroes smz = new SetMatrixZeroes();
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		smz.setZeroes(matrix);
		ArrayUtility.print(matrix);

		matrix = new int[][] { { 0, 2, 3, 4 }, { 5, 6, 7, 0 }, { 9, 10, 11, 12 } };
		smz.setZeroes(matrix);
		ArrayUtility.print(matrix);

		matrix = new int[][] { { 1 } };
		smz.setZeroes(matrix);
		ArrayUtility.print(matrix);

		matrix = new int[][] { { 0, 2, 3, 0 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		smz.setZeroes(matrix);
		ArrayUtility.print(matrix);
		
		
		matrix = new int[][] { { 1, 2, 3 }, { 4, 0, 6 }, { 7, 8, 9 } };
		smz.setZeroes2(matrix);
		ArrayUtility.print(matrix);

		matrix = new int[][] { { 0, 2, 3, 4 }, { 5, 6, 7, 0 }, { 9, 10, 11, 12 } };
		smz.setZeroes2(matrix);
		ArrayUtility.print(matrix);

		matrix = new int[][] { { 1 } };
		smz.setZeroes2(matrix);
		ArrayUtility.print(matrix);

		matrix = new int[][] { { 0, 2, 3, 0 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		smz.setZeroes2(matrix);
		ArrayUtility.print(matrix);
		
		matrix = new int[][] { { 0,1} };
		smz.setZeroes2(matrix);
		ArrayUtility.print(matrix);
	}
}
