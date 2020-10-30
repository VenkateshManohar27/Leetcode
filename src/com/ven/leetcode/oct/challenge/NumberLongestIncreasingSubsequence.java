package com.ven.leetcode.oct.challenge;

/**
 * Given an integer array nums, return the number of longest increasing
 * subsequences.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,5,4,7] Output: 2 Explanation: The two longest increasing
 * subsequences are [1, 3, 4, 7] and [1, 3, 5, 7]. Example 2:
 * 
 * Input: nums = [2,2,2,2,2] Output: 5 Explanation: The length of longest
 * continuous increasing subsequence is 1, and there are 5 subsequences' length
 * is 1, so output 5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 0 <= nums.length <= 2000 -106 <= nums[i] <= 106
 * 
 * @author Venkatesh Manohar
 *
 */
public class NumberLongestIncreasingSubsequence {
	public int findNumberOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}

		int[][] dp = new int[nums.length][2];
		dp[0][0] = 1;
		dp[0][1] = 1;

		int max_len = 1;
		for (int i = 1; i < nums.length; i++) {
			dp[i][0] = 1;
			dp[i][1] = 1;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					if (1 + dp[j][0] > dp[i][0]) {
						dp[i][0] = 1 + dp[j][0];
						dp[i][1] = dp[j][1];
					} else if (1 + dp[j][0] == dp[i][0]) {
						dp[i][1] += dp[j][1];
					}
				}
			}

			max_len = Math.max(max_len, dp[i][0]);
		}

		int sum = 0;
		for (int[] ele : dp) {
			if (ele[0] == max_len) {
				sum += ele[1];
			}
		}

		return sum;
	}
}
