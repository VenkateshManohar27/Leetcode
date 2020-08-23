package com.ven.leetcode.augchallenge;

public class DetectCycles2DGrid {

	static int N = 0;
	static int M = 0;

	static int directionInX[] = new int[] { -1, 0, 1, 0 };
	static int directionInY[] = new int[] { 0, 1, 0, -1 };

	private boolean isValid(int x, int y) {
		if (x < N && x >= 0 && y < M && y >= 0)
			return true;
		else
			return false;
	}

	private boolean isCycle(int x, int y, char arr[][], boolean visited[][], int parentX, int parentY) {

		visited[x][y] = true;
		for (int k = 0; k < 4; k++) {
			int newX = x + directionInX[k];
			int newY = y + directionInY[k];

			if (isValid(newX, newY) == true && arr[newX][newY] == arr[x][y] && !(parentX == newX && parentY == newY)) {

				if (visited[newX][newY] == true) {
					return true;
				}

				else {
					boolean check = isCycle(newX, newY, arr, visited, x, y);

					if (check == true)
						return true;
				}
			}
		}
		return false;
	}

	public boolean containsCycle(char[][] grid) {
		N = grid.length;
		M = grid[0].length;
		// To store the visited cell
		boolean[][] visited = new boolean[N][M];

		for (int i = 0; i < N; i++)
			for (int j = 0; j < M; j++)
				visited[i][j] = false;

		boolean cycle = false;

		for (int i = 0; i < N; i++) {

			if (cycle == true)
				break;

			for (int j = 0; j < M; j++) {

				if (visited[i][j] == false) {
					cycle = isCycle(i, j, grid, visited, -1, -1);
				}

				if (cycle == true)
					break;
			}
		}

		return cycle;
	}

	public static void main(String[] args) {
		// Given grid arr[][]
		char arr[][] = { { 'A', 'A', 'A', 'A' }, { 'A', 'B', 'C', 'A' }, { 'A', 'D', 'D', 'A' } };
		DetectCycles2DGrid d = new DetectCycles2DGrid();
		// Function call
		System.out.println(d.containsCycle(arr));

		arr = new char[][] { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
				{ 'a', 'a', 'a', 'a' } };
		System.out.println(d.containsCycle(arr));

		arr = new char[][] { { 'c', 'c', 'c', 'a' }, { 'c', 'd', 'c', 'c' }, { 'c', 'c', 'e', 'c' },
				{ 'f', 'c', 'c', 'c' } };
		System.out.println(d.containsCycle(arr));

		arr = new char[][] { { 'a', 'b', 'b' }, { 'b', 'z', 'b' }, { 'b', 'b', 'a' } };
		System.out.println(d.containsCycle(arr));
	}

}
