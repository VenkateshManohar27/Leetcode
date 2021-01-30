package com.ven.leetcode.jan2021.challenge;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * You are a hiker preparing for an upcoming hike. You are given heights, a 2D
 * array of size rows x columns, where heights[row][col] represents the height
 * of cell (row, col). You are situated in the top-left cell, (0, 0), and you
 * hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e.,
 * 0-indexed). You can move up, down, left, or right, and you wish to find a
 * route that requires the minimum effort.
 * 
 * A route's effort is the maximum absolute difference in heights between two
 * consecutive cells of the route.
 * 
 * Return the minimum effort required to travel from the top-left cell to the
 * bottom-right cell.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: heights = [[1,2,2],[3,8,2],[5,3,5]] Output: 2 Explanation: The route
 * of [1,3,5,3,5] has a maximum absolute difference of 2 in consecutive cells.
 * This is better than the route of [1,2,2,2,5], where the maximum absolute
 * difference is 3. Example 2:
 * 
 * 
 * 
 * Input: heights = [[1,2,3],[3,8,4],[5,3,5]] Output: 1 Explanation: The route
 * of [1,2,3,4,5] has a maximum absolute difference of 1 in consecutive cells,
 * which is better than route [1,3,5,3,5]. Example 3:
 * 
 * 
 * Input: heights =
 * [[1,2,1,1,1],[1,2,1,2,1],[1,2,1,2,1],[1,2,1,2,1],[1,1,1,2,1]] Output: 0
 * Explanation: This route does not require any effort.
 * 
 * 
 * Constraints:
 * 
 * rows == heights.length columns == heights[i].length 1 <= rows, columns <= 100
 * 1 <= heights[i][j] <= 106
 * 
 * @author Venkatesh Manohar
 *
 */
public class MinimumEffortPath {
	public int minimumEffortPath(int[][] heights) {
		int m = heights.length;
		int n = heights[0].length;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
		int[][] effort = new int[m][n];
		for (int i = 0; i < effort.length; i++) {
			Arrays.fill(effort[i], Integer.MAX_VALUE);
		}
		effort[0][0] = 0;
		pq.add(new int[] { 0, 0, 0 });
		int[][] dirs = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
		while (!pq.isEmpty()) {
			int[] top = pq.poll();
			if (top[0] == m - 1 && top[1] == n - 1) {
				return top[2];
			}
			for (int[] dir : dirs) {
				int nx = top[0] + dir[0];
				int ny = top[1] + dir[1];
				if (nx >= 0 && nx < m && ny >= 0 && ny < n) {
					int diff = Math.max(top[2], Math.abs(heights[nx][ny] - heights[top[0]][top[1]]));
					if (diff < effort[nx][ny]) {
						effort[nx][ny] = diff;
						pq.add(new int[] { nx, ny, diff });
					}
				}
			}

		}
		return -1;
	}

	public static void main(String[] args) {
		MinimumEffortPath m = new MinimumEffortPath();
		System.out.println(m.minimumEffortPath(new int[][] { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } }));

		System.out.println(m.minimumEffortPath(new int[][] { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 },
				{ 1, 2, 1, 2, 1 }, { 1, 1, 1, 2, 1 } }));
	}
}
