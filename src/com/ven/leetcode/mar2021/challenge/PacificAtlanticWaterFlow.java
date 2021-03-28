package com.ven.leetcode.mar2021.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an m x n integer matrix heights representing the height of each
 * unit cell in a continent. The Pacific ocean touches the continent's left and
 * top edges, and the Atlantic ocean touches the continent's right and bottom
 * edges.
 * 
 * Water can only flow in four directions: up, down, left, and right. Water
 * flows from a cell to an adjacent one with an equal or lower height.
 * 
 * Return a list of grid coordinates where water can flow to both the Pacific
 * and Atlantic oceans.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: heights =
 * [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]] Output:
 * [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]] Example 2:
 * 
 * Input: heights = [[2,1],[1,2]] Output: [[0,0],[0,1],[1,0],[1,1]]
 * 
 * 
 * Constraints:
 * 
 * m == heights.length n == heights[i].length 1 <= m, n <= 200 1 <=
 * heights[i][j] <= 105
 * 
 * @author Venkatesh Manohar
 *
 */
public class PacificAtlanticWaterFlow {
	List<List<Integer>> ans = new ArrayList<>();
	boolean checker[][][];

	public List<List<Integer>> pacificAtlantic(int[][] matrix) {
		// 4
		if (matrix.length == 0) {
			return ans;
		}
		checker = new boolean[matrix.length][matrix[0].length][2]; // 0:pacific 1:alantic
		for (int col = 0; col < matrix[0].length; col++) {
			// checker[0][col][0]=true;
			dfsToAlantic(matrix, 0, col);
		}
		for (int row = 0; row < matrix.length; row++) {
			// checker[row][0][0]=true;
			dfsToAlantic(matrix, row, 0);
		}
		for (int col = 0; col < matrix[0].length; col++) {
			// checker[matrix.length-1][col][1]=true;
			dfsToPacific(matrix, matrix.length - 1, col);
		}
		for (int row = 0; row < matrix.length; row++) {
			// checker[row][matrix[0].length-1][1]=true;
			dfsToPacific(matrix, row, matrix[0].length - 1);
		}

		// answer
		for (int r = 0; r < checker.length; r++) {
			for (int c = 0; c < checker[0].length; c++) {
				if (checker[r][c][0] && checker[r][c][1]) {
					List<Integer> list = new ArrayList<>();
					list.add(r);
					list.add(c);
					ans.add(list);
				}
			}
		}
		return ans;
	}

	public void dfsToAlantic(int matrix[][], int row, int col) {
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
			return;
		}
		// visited
		if (checker[row][col][0] == true) {
			return;
		}
		checker[row][col][0] = true;

		if (check(matrix, row + 1, col)) {
			if (matrix[row][col] <= matrix[row + 1][col]) {
				dfsToAlantic(matrix, row + 1, col);
			}
		}
		if (check(matrix, row - 1, col)) {
			if (matrix[row][col] <= matrix[row - 1][col]) {
				dfsToAlantic(matrix, row - 1, col);
			}
		}
		if (check(matrix, row, col + 1)) {
			if (matrix[row][col] <= matrix[row][col + 1]) {
				dfsToAlantic(matrix, row, col + 1);
			}
		}
		if (check(matrix, row, col - 1)) {
			if (matrix[row][col] <= matrix[row][col - 1]) {
				dfsToAlantic(matrix, row, col - 1);
			}
		}
	}

	public void dfsToPacific(int matrix[][], int row, int col) {
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
			return;
		}
		// visited
		if (checker[row][col][1] == true) {
			return;
		}
		checker[row][col][1] = true;

		if (check(matrix, row + 1, col)) {
			if (matrix[row][col] <= matrix[row + 1][col]) {
				dfsToPacific(matrix, row + 1, col);
			}
		}
		if (check(matrix, row - 1, col)) {
			if (matrix[row][col] <= matrix[row - 1][col]) {
				dfsToPacific(matrix, row - 1, col);
			}
		}
		if (check(matrix, row, col + 1)) {
			if (matrix[row][col] <= matrix[row][col + 1]) {
				dfsToPacific(matrix, row, col + 1);
			}
		}
		if (check(matrix, row, col - 1)) {
			if (matrix[row][col] <= matrix[row][col - 1]) {
				dfsToPacific(matrix, row, col - 1);
			}
		}
	}

	public boolean check(int matrix[][], int row, int col) {
		if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length) {
			return false;
		}
		return true;
	}
}
