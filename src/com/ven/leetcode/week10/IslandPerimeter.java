package com.ven.leetcode.week10;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int p = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 1) {
					int peri = 4;
					// Up is land
					if (i > 0 && grid[i - 1][j] == 1) {
						peri--;
					}
					// down
					if (i < grid.length - 1 && grid[i + 1][j] == 1) {
						peri--;
					}
					// left
					if (j > 0 && grid[i][j - 1] == 1) {
						peri--;
					}
					// right
					if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
						peri--;
					}

					p += peri;
				}
			}
		}

		return p;
	}

	public static void main(String[] args) {

	}
}
