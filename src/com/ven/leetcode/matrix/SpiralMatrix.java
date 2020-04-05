package com.ven.leetcode.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	class Index {
		int row = 0;
		int col = 0;
	}

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> li = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0) {
			return li;
		}
		boolean[][] visited = new boolean[matrix.length][matrix[0].length];
		boolean isAllCellsVisited = true;
		Index index = new Index();
		while (isAllCellsVisited) {
			isAllCellsVisited = moveRight(index, matrix, visited, li) | moveDown(index, matrix, visited, li)
					| moveLeft(index, matrix, visited, li) | moveUp(index, matrix, visited, li);
		}
		return li;
	}

	private boolean moveRight(Index index, int[][] matrix, boolean[][] visited, List<Integer> li) {
		boolean result = false;
		int row = index.row;
		for (int i = 0; i < matrix[row].length; i++) {
			if (!visited[row][i]) {
				visited[row][i] = !visited[row][i];
				li.add(matrix[row][i]);
				if (!result) {
					result = true;
				}
				index.col = i;
			}
		}
		return result;
	}

	private boolean moveDown(Index index, int[][] matrix, boolean[][] visited, List<Integer> li) {
		boolean result = false;
		int col = index.col;
		for (int i = 0; i < matrix.length; i++) {
			if (!visited[i][col]) {
				visited[i][col] = !visited[i][col];
				li.add(matrix[i][col]);
				if (!result) {
					result = true;
				}
				index.row = i;
			}
		}
		return result;
	}

	private boolean moveLeft(Index index, int[][] matrix, boolean[][] visited, List<Integer> li) {
		boolean result = false;
		int row = index.row;
		for (int i = matrix[row].length - 1; i >= 0; i--) {
			if (!visited[row][i]) {
				visited[row][i] = !visited[row][i];
				li.add(matrix[row][i]);
				if (!result) {
					result = true;
				}
				index.col = i;
			}
		}
		return result;
	}

	private boolean moveUp(Index index, int[][] matrix, boolean[][] visited, List<Integer> li) {
		boolean result = false;
		int col = index.col;
		for (int i = matrix.length - 1; i >= 0; i--) {
			if (!visited[i][col]) {
				visited[i][col] = !visited[i][col];
				li.add(matrix[i][col]);
				if (!result) {
					result = true;
				}
				index.row = i;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		SpiralMatrix sm = new SpiralMatrix();
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		System.out.println(sm.spiralOrder(matrix));

		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		System.out.println(sm.spiralOrder(matrix));

		System.out.println(sm.spiralOrder(new int[][] { { 1 } }));

		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		System.out.println(sm.spiralOrder(matrix));
	}
}
