package com.ven.leetcode.dp;

import java.util.Arrays;

/**
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * 
 * Example:
 * 
 * nums = [1, 2, 3] target = 4
 * 
 * The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3)
 * (2, 1, 1) (2, 2) (3, 1)
 * 
 * Note that different sequences are counted as different combinations.
 * 
 * Therefore the output is 7.
 * 
 * 
 * Follow up: What if negative numbers are allowed in the given array? How does
 * it change the problem? What limitation we need to add to the question to
 * allow negative numbers?
 * 
 * @author Venkatesh Manohar
 *
 */
public class CombinationSumIV {

	public int combinationSum4(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		Arrays.fill(dp, -1);
		dp[0] = 1;
		helper(nums, dp, target);

		return dp[target];
	}

	private int helper(int[] nums, int[] dp, int target) {
		if (dp[target] >= 0)
			return dp[target];
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (target >= nums[i])
				res += helper(nums, dp, target - nums[i]);
		}

		dp[target] = res;

		return res;
	}

	public int combinationSum4BottomUp(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] <= i)
					dp[i] += dp[i - nums[j]];
			}
		}
		return dp[target];
	}

	public static void main(String[] args) {
		CombinationSumIV cs = new CombinationSumIV();
		System.out.println(cs.combinationSum4(new int[] { 1, 2, 3 }, 4));

		System.out.println(cs.combinationSum4(new int[] { 1, 2, 3 }, 100));

		System.out.println(cs.combinationSum4BottomUp(new int[] { 1, 2, 3 }, 4));

		System.out.println(cs.combinationSum4BottomUp(new int[] { 1, 2, 3 }, 100));
	}
}
