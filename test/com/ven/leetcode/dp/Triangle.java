package com.ven.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you
 * may move to adjacent numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [ [2], [3,4], [6,5,7], [4,1,8,3] ] The minimum path sum from top to bottom is
 * 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n
 * is the total number of rows in the triangle.
 * 
 * @author Venkatesh Manohar
 *
 */
public class Triangle {
	public int minimumTotal(List<List<Integer>> triangle) {
		if (triangle == null) {
			return 0;
		}
		if (triangle.size() == 1) {
			return triangle.get(0).get(0);
		}

		int[][] dp = new int[triangle.size()][triangle.size()];
		int i = 0;
		int j = 0;

		while (i < triangle.size()) {
			List<Integer> li = triangle.get(i);
			while (j < li.size()) {
				dp[i][j] = li.get(j);
				j++;
			}
			while(j< dp[i].length) {
				dp[i][j] = Integer.MAX_VALUE;
				j++;
			}
			j = 0;
			i++;
		}

		for (int k = 1; k < dp.length; k++) {
			for (int l = 0; l <= k; l++) {
				int upperLeft = (l > 0) ? (dp[k][l] + dp[k - 1][l - 1]) : Integer.MAX_VALUE;
				int upper = (Integer.MAX_VALUE != dp[k-1][l])?dp[k][l] + dp[k - 1][l]: Integer.MAX_VALUE;
				int upperRight = (l < k-1) ? (dp[k][l]+ dp[k - 1][l + 1]) : Integer.MAX_VALUE;
				int min = Math.min(Math.min(upperLeft, upper), upperRight);

				dp[k][l] = min ;

			}
		}
		int min = dp[dp.length - 1][0];
		for (int k = dp.length - 1, l = 1; l < dp[k].length; l++) {
			min = Math.min(dp[k][l], min);
		}
		return min;
	}

	public static void main(String[] args) {
		//[ [2], [3,4], [6,5,7], [4,1,8,3] ]
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		List<Integer> row0 = new ArrayList<>();
		row0.add(2);
		List<Integer> row1 = new ArrayList<>();
		row1.add(3);
		row1.add(4);
		List<Integer> row2 = new ArrayList<>();
		row2.add(6);
		row2.add(5);
		row2.add(7);
		List<Integer> row3 = new ArrayList<>();
		row3.add(4);
		row3.add(1);
		row3.add(8);
		row3.add(3);
		triangle.add(row0);
		triangle.add(row1);
		triangle.add(row2);
		triangle.add(row3);
		
		Triangle t = new Triangle();
		System.out.println(t.minimumTotal(triangle));
		triangle = new ArrayList<List<Integer>>();
		row0 = new ArrayList<>();
		row0.add(-1);
		 row1 = new ArrayList<>();
		row1.add(2);
		row1.add(3);
		row2 = new ArrayList<>();
		row2.add(1);
		row2.add(-1);
		row2.add(-3);
		triangle.add(row0);
		triangle.add(row1);
		triangle.add(row2);
		System.out.println(t.minimumTotal(triangle));
		
		triangle = new ArrayList<List<Integer>>();
		row0 = new ArrayList<>();
		row0.add(-1);
		 row1 = new ArrayList<>();
		row1.add(3);
		row1.add(2);
		row2 = new ArrayList<>();
		row2.add(-3);
		row2.add(1);
		row2.add(-1);
		triangle.add(row0);
		triangle.add(row1);
		triangle.add(row2);
		System.out.println(t.minimumTotal(triangle));
	}
}
