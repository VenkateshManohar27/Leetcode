package com.ven.leetcode.arrays;

/**
 * You are given a map in form of a two-dimensional integer grid where 1
 * represents land and 0 represents water.
 * 
 * Grid cells are connected horizontally/vertically (not diagonally). The grid
 * is completely surrounded by water, and there is exactly one island (i.e., one
 * or more connected land cells).
 * 
 * The island doesn't have "lakes" (water inside that isn't connected to the
 * water around the island). One cell is a square with side length 1. The grid
 * is rectangular, width and height don't exceed 100. Determine the perimeter of
 * the island.
 * 
 * 
 * 
 * Example:
 * 
 * Input: [[0,1,0,0], [1,1,1,0], [0,1,0,0], [1,1,0,0]]
 * 
 * Output: 16
 * 
 * @author Venkatesh Manohar
 *
 */
public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		int perimeter = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 0) {
					continue;
				}
				// Check up
				if (i == 0 || (i > 0 && grid[i - 1][j] == 0)) {
					perimeter += 1;
				}
				
				//check down
				if (i == grid.length-1 || grid[i+1][j] == 0) {
					perimeter += 1;
				}
				//check left
				if (j == 0 || (j > 0 && grid[i][j-1] == 0)) {
					perimeter += 1;
				}
				//check right
				if (j == grid[i].length -1 ||  grid[i][j+1] == 0) {
					perimeter += 1;
				}
			}
		}

		return perimeter;
	}

	public static void main(String[] args) {
		IslandPerimeter ip = new IslandPerimeter();
		int[][] grid = new int[][] { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0 } };
		System.out.println(ip.islandPerimeter(grid));
		
		grid = new int[][] { { 0, 1, 1, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 } };
		System.out.println(ip.islandPerimeter(grid));
		
		grid = new int[][] { { 0, 1} };
		System.out.println(ip.islandPerimeter(grid));

	}
}
