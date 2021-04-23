package com.ven.leetcode.apr2021.challenge;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a triangle array, return the minimum path sum from top to bottom.
 * 
 * For each step, you may move to an adjacent number of the row below. More
 * formally, if you are on index i on the current row, you may move to either
 * index i or index i + 1 on the next row.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]] Output: 11 Explanation: The
 * triangle looks like: 2 3 4 6 5 7 4 1 8 3 The minimum path sum from top to
 * bottom is 2 + 3 + 5 + 1 = 11 (underlined above). Example 2:
 * 
 * Input: triangle = [[-10]] Output: -10
 * 
 * 
 * Constraints:
 * 
 * 1 <= triangle.length <= 200 triangle[0].length == 1 triangle[i].length ==
 * triangle[i - 1].length + 1 -104 <= triangle[i][j] <= 104
 * 
 * @author Venkatesh Manohar
 *
 */
public class Triangle {
	private Map<String, Integer> memoTable;
	private List<List<Integer>> triangle;

	private int minPath(int row, int col) {
		String params = row + ":" + col;
		if (memoTable.containsKey(params)) {
			return memoTable.get(params);
		}
		int path = triangle.get(row).get(col);
		if (row < triangle.size() - 1) {
			path += Math.min(minPath(row + 1, col), minPath(row + 1, col + 1));
		}
		memoTable.put(params, path);
		return path;
	}

	public int minimumTotal(List<List<Integer>> triangle) {
		this.triangle = triangle;
		memoTable = new HashMap<>();
		return minPath(0, 0);
	}
}
