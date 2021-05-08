package com.ven.leetcode.may2021.challenge;

import java.util.Arrays;

/**
 * Given an array of non-negative integers nums, you are initially positioned at
 * the first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * You can assume that you can always reach the last index.
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,1,1,4] Output: 2 Explanation: The minimum number of jumps
 * to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to
 * the last index. Example 2:
 * 
 * Input: nums = [2,3,0,1,4] Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 1000 0 <= nums[i] <= 105
 * 
 * @author Venkatesh Manohar
 *
 */
public class JumpGameII {
	public int jump(int[] nums) {
		int[] dp = new int[nums.length];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			int step = dp[i] + 1;
			for (int j = i + nums[i]; j > i; j--) {
				if (j > nums.length - 1) {
					continue;
				}
				dp[j] = Math.min(step, dp[j]);
			}

		}
		// System.out.println(Arrays.toString(dp));
		return dp[nums.length - 1];
	}
}
