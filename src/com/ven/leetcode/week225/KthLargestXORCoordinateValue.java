package com.ven.leetcode.week225;

import java.util.PriorityQueue;

/**
 * You are given a 2D matrix of size m x n, consisting of non-negative integers.
 * You are also given an integer k.
 * 
 * The value of coordinate (a, b) of the matrix is the XOR of all matrix[i][j]
 * where 0 <= i <= a < m and 0 <= j <= b < n (0-indexed).
 * 
 * Find the kth largest value (1-indexed) of all the coordinates of matrix.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[5,2],[1,6]], k = 1 Output: 7 Explanation: The value of
 * coordinate (0,1) is 5 XOR 2 = 7, which is the largest value. Example 2:
 * 
 * Input: matrix = [[5,2],[1,6]], k = 2 Output: 5 Explanation: The value of
 * coordinate (0,0) is 5 = 5, which is the 2nd largest value. Example 3:
 * 
 * Input: matrix = [[5,2],[1,6]], k = 3 Output: 4 Explanation: The value of
 * coordinate (1,0) is 5 XOR 1 = 4, which is the 3rd largest value. Example 4:
 * 
 * Input: matrix = [[5,2],[1,6]], k = 4 Output: 0 Explanation: The value of
 * coordinate (1,1) is 5 XOR 2 XOR 1 XOR 6 = 0, which is the 4th largest value.
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length n == matrix[i].length 1 <= m, n <= 1000 0 <= matrix[i][j]
 * <= 106 1 <= k <= m * n
 * 
 * @author Venkatesh Manohar
 *
 */
public class KthLargestXORCoordinateValue {
	public int kthLargestValue(int[][] matrix, int k) {
		int M = matrix.length, N = matrix[0].length;
		int[][] dp = new int[M][N];

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < M; ++i) {
			for (int j = 0; j < N; ++j) {

				int x = (i - 1 < 0 ? 0 : dp[i - 1][j]);
				int y = (j - 1 < 0 ? 0 : dp[i][j - 1]);
				int z = (i - 1 < 0 || j - 1 < 0 ? 0 : dp[i - 1][j - 1]);

				dp[i][j] = (x ^ y ^ z ^ matrix[i][j]);

				pq.add(dp[i][j]);
				if (pq.size() > k)
					pq.poll();
			}
		}

		return pq.poll();
	}
}
