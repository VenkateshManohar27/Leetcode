package com.ven.leetcode.augchallenge;

import java.util.LinkedList;
import java.util.Queue;

/**
 * In a given grid, each cell can have one of three values:
 * 
 * the value 0 representing an empty cell; the value 1 representing a fresh
 * orange; the value 2 representing a rotten orange. Every minute, any fresh
 * orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1 instead.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		Queue<String> q = new LinkedList<String>();
		int fresh = 0;

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 2) {
					q.add(i + "x" + j);
				}
				if (grid[i][j] == 1) {
					fresh++;
				}
			}
		}
		if(fresh == 0) {
			return 0;
		}
		int minute = 0;
		while (!q.isEmpty() && fresh > 0) {
			int size = q.size();
			while (size > 0) {
				String rowCol = q.poll();
				int i = rowCol.charAt(0) - '0';
				int j = rowCol.charAt(2) - '0';
				// check up
				if (i > 0 && grid[i - 1][j] == 1) {
					grid[i - 1][j] = 2;
					q.add((i - 1) + "x" + j);
					fresh--;
				}
				// check down
				if (i < grid.length - 1 && grid[i + 1][j] == 1) {
					grid[i + 1][j] = 2;
					q.add((i + 1) + "x" + j);
					fresh--;
				}
				// check left
				if (j > 0 && grid[i][j - 1] == 1) {
					grid[i][j - 1] = 2;
					q.add(i + "x" + (j - 1));
					fresh--;
				}
				// check right
				if (j < grid[i].length - 1 && grid[i][j + 1] == 1) {
					grid[i][j + 1] = 2;
					q.add(i + "x" + (j + 1));
					fresh--;
				}
				size--;
			}
			minute++;
		}

		return (fresh == 0) ? minute : -1;
	}

	public static void main(String[] args) {
		int[][] arr1 = new int[][] { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
		int[][] arr2 = new int[][] { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };
		int[][] arr3 = new int[][] { { 0, 2 } };
		RottingOranges ro = new RottingOranges();
		System.out.println(ro.orangesRotting(arr1));
		System.out.println(ro.orangesRotting(arr2));
		System.out.println(ro.orangesRotting(arr3));
	}
}
