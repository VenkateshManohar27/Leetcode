package com.ven.leetcode.matrix;

import java.util.Arrays;

import com.ven.utility.ArrayUtility;

/**
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * Example:
 * 
 * Input: 3 Output: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 * 
 * @author Venkatesh Manohar
 *
 */

class State {
	int row = 0;
	int col = 0;
	int value = 0;
}

public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int FINAL = n * n;
		if (n <= 0) {
			return matrix;
		}
		for (int i = 0; i < matrix.length; i++) {
			Arrays.fill(matrix[i], -1);
		}
		State st = new State();
		while (true) {
			if (moveRight(matrix, st).value == FINAL)
				break;
			if (st.row < matrix.length - 1) {
				st.row++;
			}
			if (moveDown(matrix, st).value == FINAL)
				break;
			if (st.col > 0) {
				st.col--;
			}
			if (moveLeft(matrix, st).value == FINAL)
				break;
			if (st.row > 0) {
				st.row--;
			}
			if (moveUp(matrix, st).value == FINAL)
				break;
			if (st.col < n) {
				st.col++;
			}
		}

		return matrix;
	}

	private State moveRight(int[][] matrix, State state) {
		for (int i = state.col; i < matrix[state.row].length; i++) {
			if (matrix[state.row][i] != -1) {
				break;
			}
			state.col = i;
			matrix[state.row][state.col] = ++state.value;
		}
		return state;
	}

	private State moveDown(int[][] matrix, State state) {
		for (int i = state.row; i < matrix.length; i++) {
			if (matrix[i][state.col] != -1) {
				break;
			}
			state.row = i;
			matrix[state.row][state.col] = ++state.value;
		}
		return state;
	}

	private State moveLeft(int[][] matrix, State state) {
		for (int i = state.col; i >= 0; i--) {
			if (matrix[state.row][i] != -1) {
				break;
			}
			state.col = i;
			matrix[state.row][state.col] = ++state.value;
		}
		return state;
	}

	private State moveUp(int[][] matrix, State state) {
		for (int i = state.row; i >= 0; i--) {
			if (matrix[i][state.col] != -1) {
				break;
			}
			state.row = i;
			matrix[state.row][state.col] = ++state.value;
		}
		return state;
	}

	public static void main(String[] args) {
		SpiralMatrixII sp = new SpiralMatrixII();
		ArrayUtility.print(sp.generateMatrix(0));
		ArrayUtility.print(sp.generateMatrix(1));
		ArrayUtility.print(sp.generateMatrix(2));
		ArrayUtility.print(sp.generateMatrix(3));
		
		ArrayUtility.print(sp.generateMatrix(4));
	}
}