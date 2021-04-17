package com.ven.leetcode.apr2021.challenge;

import java.util.HashMap;

/**
 * Given a matrix and a target, return the number of non-empty submatrices that
 * sum to target.
 * 
 * A submatrix x1, y1, x2, y2 is the set of all cells matrix[x][y] with x1 <= x
 * <= x2 and y1 <= y <= y2.
 * 
 * Two submatrices (x1, y1, x2, y2) and (x1', y1', x2', y2') are different if
 * they have some coordinate that is different: for example, if x1 != x1'.
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0 Output: 4 Explanation:
 * The four 1x1 submatrices that only contain 0. Example 2:
 * 
 * Input: matrix = [[1,-1],[-1,1]], target = 0 Output: 5 Explanation: The two
 * 1x2 submatrices, plus the two 2x1 submatrices, plus the 2x2 submatrix.
 * Example 3:
 * 
 * Input: matrix = [[904]], target = 0 Output: 0
 * 
 * Constraints:
 * 
 * 1 <= matrix.length <= 100 1 <= matrix[0].length <= 100 -1000 <= matrix[i] <=
 * 1000 -10^8 <= target <= 10^8
 * 
 * @author Venkatesh Manohar
 *
 */
public class NumberofSubmatricesThatSumtoTarget {
	public int numSubmatrixSumTarget(int[][] a, int t) {
		int m = a.length, n = a[0].length;
		int[][] b = new int[a.length][n + 1];

		for (int i = 0; i < m; i++) {
			for (int j = 1; j <= n; j++) {
				b[i][j] = b[i][j - 1] + a[i][j - 1];
			}
		}

		int count = 0;
		for (int c1 = 0; c1 < n; c1++) {
			for (int c2 = 0; c2 < n; c2++) {
				int sum = 0;
				HashMap<Integer, Integer> pre = new HashMap<>();
				pre.put(0, 1);
				for (int i = 0; i < m; i++) {
					int num = b[i][c2] - b[i][c1];
					sum += num;
					count += pre.getOrDefault(sum - t, 0);
					pre.put(sum, pre.getOrDefault(sum, 0) + 1);
				}
			}
		}

		return count;
	}
}
