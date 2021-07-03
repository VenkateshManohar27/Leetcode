package com.ven.leetcode.jul2021.challenge;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * Given an m x n matrix matrix and an integer k, return the max sum of a
 * rectangle in the matrix such that its sum is no larger than k.
 * 
 * It is guaranteed that there will be a rectangle with a sum no larger than k.
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,0,1],[0,-2,3]], k = 2 Output: 2 Explanation: Because the
 * sum of the blue rectangle [[0, 1], [-2, 3]] is 2, and 2 is the max number no
 * larger than k (k = 2). Example 2:
 * 
 * Input: matrix = [[2,2,-1]], k = 3 Output: 3
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length n == matrix[i].length 1 <= m, n <= 100 -100 <=
 * matrix[i][j] <= 100 -105 <= k <= 105
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaxSumofRectangleNoLargerThanK {
	int result = Integer.MIN_VALUE;

	void updateResult(int[] nums, int k) {
		int sum = 0;

		// Container to store sorted prefix sums.
		TreeSet<Integer> sortedSum = new TreeSet<>();

		// Add 0 as the prefix sum for an empty sub-array.
		sortedSum.add(0);
		for (int num : nums) {
			// Running Sum.
			sum += num;

			// Get X where Running sum - X <= k such that sum - X is closest to k.
			Integer x = sortedSum.ceiling(sum - k);

			// If such X is found in the prefix sums.
			// Get the sum of that sub array and update the global maximum result.
			if (x != null)
				result = Math.max(result, sum - x);

			// Insert the current running sum to the prefix sums container.
			sortedSum.add(sum);
		}
	}

	public int maxSumSubmatrix(int[][] matrix, int k) {
		// Stores the 1D representation of the matrix.
		int[] rowSum = new int[matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			// Initialize the 1D representation with 0s.
			Arrays.fill(rowSum, 0);
			// We convert the matrix between rows i..row inclusive to 1D array
			for (int row = i; row < matrix.length; row++) {
				// Add the current row to the previous row.
				// This converts the matrix between i..row to 1D array
				for (int col = 0; col < matrix[0].length; col++)
					rowSum[col] += matrix[row][col];

				// Run the 1D algorithm for `rowSum`
				updateResult(rowSum, k);

				// If result is k, this is the best possible answer, so return.
				if (result == k)
					return result;
			}
		}
		return result;
	}
}
