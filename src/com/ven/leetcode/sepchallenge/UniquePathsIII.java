package com.ven.leetcode.sepchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * On a 2-dimensional grid, there are 4 types of squares:
 * 
 * 1 represents the starting square. There is exactly one starting square. 2
 * represents the ending square. There is exactly one ending square. 0
 * represents empty squares we can walk over. -1 represents obstacles that we
 * cannot walk over. Return the number of 4-directional walks from the starting
 * square to the ending square, that walk over every non-obstacle square exactly
 * once.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,2,-1]] Output: 2 Explanation: We have the
 * following two paths: 1.
 * (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2) 2.
 * (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2) Example 2:
 * 
 * Input: [[1,0,0,0],[0,0,0,0],[0,0,0,2]] Output: 4 Explanation: We have the
 * following four paths: 1.
 * (0,0),(0,1),(0,2),(0,3),(1,3),(1,2),(1,1),(1,0),(2,0),(2,1),(2,2),(2,3) 2.
 * (0,0),(0,1),(1,1),(1,0),(2,0),(2,1),(2,2),(1,2),(0,2),(0,3),(1,3),(2,3) 3.
 * (0,0),(1,0),(2,0),(2,1),(2,2),(1,2),(1,1),(0,1),(0,2),(0,3),(1,3),(2,3) 4.
 * (0,0),(1,0),(2,0),(2,1),(1,1),(0,1),(0,2),(0,3),(1,3),(1,2),(2,2),(2,3)
 * Example 3:
 * 
 * Input: [[0,1],[2,0]] Output: 0 Explanation: There is no path that walks over
 * every empty square exactly once. Note that the starting and ending square can
 * be anywhere in the grid.
 * 
 * 
 * Note:
 * 
 * 1 <= grid.length * grid[0].length <= 20
 * 
 * @author Venkatesh Manohar
 *
 */

class Index {
	int x;
	int y;

	public Index(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}

class Result {
	int paths = 0;
}

public class UniquePathsIII {
	int res = 0;

	public int uniquePathsIII(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}
		res = 0;
		int count = 0;
		int startx = 0;
		int starty = 0;
		// boolean[][] visited = new boolean[grid.length][grid[0].length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) {
					count++;
				} else if (grid[i][j] == 1) {
					startx = i;
					starty = j;
					// visited[i][j] = true;
				} /*
					 * else if (grid[i][j] == -1) { visited[i][j] = true; }
					 */
			}
		}
		// List<Index> li = new ArrayList<>();
		// helper(startx, starty, count+1, paths, li, grid, visited);
		// helper(startx, starty, count + 1, paths, grid, visited);
		helper(startx, starty, count + 1, grid);
		return res;
	}

	private void helper(int i, int j, int count, int[][] grid) {
		if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] < 0)
			return;
		if (count == 0) {
			// System.out.println(li);
			if (grid[i][j] == 2) {
				res++;
			}
			return;
		}

		if (grid[i][j] == 2) {
			if (count == 0)
				res++;
			return;
		}
		grid[i][j] = -2;
		count--;
		helper(i - 1, j, count, grid);
		helper(i + 1, j, count, grid);
		helper(i, j - 1, count, grid);
		helper(i, j + 1, count, grid);
		grid[i][j] = 0;
		count++;
	}

	// private void helper(int i, int j, int count, Result paths, List<Index> li,
	// int[][] grid, boolean[][] v) {
	private void helper1(int i, int j, int count, Result paths, int[][] grid, boolean[][] v) {
		if (count == 0) {
			// System.out.println(li);
			if (grid[i][j] == 2) {
				paths.paths += 1;
			}
			return;
		}

		// move up
		if (i > 0 && !v[i - 1][j]) {
			v[i - 1][j] = true;
			// li.add(new Index(i - 1, j));
			// helper(i - 1, j, count - 1, paths, li, grid, v);
			// li.remove(li.size() - 1);
			helper1(i - 1, j, count - 1, paths, grid, v);
			v[i - 1][j] = false;
		}
		// move down
		if (i < grid.length - 1 && !v[i + 1][j]) {
			v[i + 1][j] = true;
			// li.add(new Index(i + 1, j));
			helper1(i + 1, j, count - 1, paths, grid, v);
			// li.remove(li.size() - 1);
			v[i + 1][j] = false;
		}
		// move right
		if (j < grid[i].length - 1 && !v[i][j + 1]) {
			v[i][j + 1] = true;
			// li.add(new Index(i, j + 1));
			helper1(i, j + 1, count - 1, paths, grid, v);
			// li.remove(li.size() - 1);
			v[i][j + 1] = false;
		}

		// move left
		if (j > 0 && !v[i][j - 1]) {
			v[i][j - 1] = true;
			// li.add(new Index(i, j - 1));
			helper1(i, j - 1, count - 1, paths, grid, v);
			// li.remove(li.size() - 1);
			v[i][j - 1] = false;
		}
	}

	private void helper2(int i, int j, int count, Result paths, List<Index> li, int[][] grid) {
		if (count == 0) {
			System.out.println(li);
			if (grid[i][j] == 2) {
				paths.paths += 1;
			}
			return;
		}

		// move up
		if (i > 0 && (grid[i - 1][j] == 0 || grid[i - 1][j] == 2)) {
			grid[i - 1][j] = 3;
			li.add(new Index(i - 1, j));
			helper2(i - 1, j, count - 1, paths, li, grid);
			li.remove(li.size() - 1);
			grid[i - 1][j] = 0;
		}
		// move down
		if (i < grid.length - 1 && (grid[i + 1][j] == 0 || grid[i + 1][j] == 2)) {
			grid[i + 1][j] = 3;
			li.add(new Index(i + 1, j));
			helper2(i + 1, j, count - 1, paths, li, grid);
			li.remove(li.size() - 1);
			grid[i + 1][j] = 0;
		}
		// move right
		if (j < grid[i].length - 1 && (grid[i][j + 1] == 0 || grid[i][j + 1] == 2)) {
			grid[i][j + 1] = 3;
			li.add(new Index(i, j + 1));
			helper2(i, j + 1, count - 1, paths, li, grid);
			li.remove(li.size() - 1);
			grid[i][j + 1] = 0;
		}

		// move left
		if (j > 0 && (grid[i][j - 1] == 0 || grid[i][j - 1] == 2)) {
			grid[i][j - 1] = 3;
			li.add(new Index(i, j - 1));
			helper2(i, j - 1, count - 1, paths, li, grid);
			li.remove(li.size() - 1);
			grid[i][j - 1] = 0;
		}
	}

	public static void main(String[] args) {
		UniquePathsIII u = new UniquePathsIII();
		System.out.println(u.uniquePathsIII(new int[][] { { 0, 1 }, { 2, 0 } }));
		System.out.println(u.uniquePathsIII(new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } }));
		System.out.println(u.uniquePathsIII(new int[][] { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 2 } }));
	}
}
