package com.ven.leetcode.feb2021.challenge;

import java.util.HashSet;
import java.util.Set;

public class NumberofIslands {
	public int numIslands(char[][] grid) {
		Set<String> visited = new HashSet<>();
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == '1' && !visited.contains(i + "*" + j)) {
					visited.add(i + "*" + j);
					dfs(grid, i, j, visited);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int row, int col, Set<String> visited) {
		if (row > grid.length || col > grid[row].length) {
			return;
		}

		if (row - 1 >= 0 && grid[row - 1][col] == '1' && !visited.contains((row - 1) + "*" + col)) {
			visited.add((row - 1) + "*" + col);
			dfs(grid, row - 1, col, visited);
		}

		if (col - 1 >= 0 && grid[row][col - 1] == '1' && !visited.contains(row + "*" + (col - 1))) {
			visited.add(row + "*" + (col - 1));
			dfs(grid, row, col - 1, visited);
		}
		if (row + 1 < grid.length && grid[row + 1][col] == '1' && !visited.contains((row + 1) + "*" + col)) {
			visited.add((row + 1) + "*" + col);
			dfs(grid, row + 1, col, visited);
		}

		if (col + 1 < grid[row].length && grid[row][col + 1] == '1' && !visited.contains(row + "*" + (col + 1))) {
			visited.add(row + "*" + (col + 1));
			dfs(grid, row, col + 1, visited);
		}
	}

	private int n;
	private int m;

	public int numIslandsWithoutExtraSpace(char[][] grid) {
		int count = 0;
		n = grid.length;
		if (n == 0)
			return 0;
		m = grid[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				if (grid[i][j] == '1') {
					DFSMarking(grid, i, j);
					++count;
				}
		}
		return count;
	}

	private void DFSMarking(char[][] grid, int i, int j) {
		if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1')
			return;
		grid[i][j] = '0';
		DFSMarking(grid, i + 1, j);
		DFSMarking(grid, i - 1, j);
		DFSMarking(grid, i, j + 1);
		DFSMarking(grid, i, j - 1);
	}

	public static void main(String[] args) {
		NumberofIslands n = new NumberofIslands();
		System.out.println(n.numIslands(new char[][] { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } }));
		System.out.println(n.numIslands(new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } }));
		System.out.println(n.numIslands(new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '1', '0', '0' }, { '0', '0', '0', '1', '1' } }));
		System.out.println(n.numIslands(new char[][] { { '1' }, { '1' } }));
	}
}
