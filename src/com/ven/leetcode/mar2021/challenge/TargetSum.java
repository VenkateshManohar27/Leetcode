package com.ven.leetcode.mar2021.challenge;

/**
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target,
 * S. Now you have 2 symbols + and -. For each integer, you should choose one
 * from + and - as its new symbol.
 * 
 * Find out how many ways to assign symbols to make sum of integers equal to
 * target S.
 * 
 * Example 1:
 * 
 * Input: nums is [1, 1, 1, 1, 1], S is 3. Output: 5 Explanation:
 * 
 * -1+1+1+1+1 = 3 +1-1+1+1+1 = 3 +1+1-1+1+1 = 3 +1+1+1-1+1 = 3 +1+1+1+1-1 = 3
 * 
 * There are 5 ways to assign symbols to make the sum of nums be target 3.
 * 
 * 
 * Constraints:
 * 
 * The length of the given array is positive and will not exceed 20. The sum of
 * elements in the given array will not exceed 1000. Your output answer is
 * guaranteed to be fitted in a 32-bit integer.
 * 
 * 
 * @author Venkatesh Manohar
 *
 */
public class TargetSum {

	private int res;

	public int findTargetSumWays(int[] nums, int S) {
		res = 0;
		helper(nums, 0, 0, S);
		return res;
	}

	private void helper(int[] nums, int i, int sum, int target) {
		if (i == nums.length) {
			if (sum == target) {
				res++;
			}
			return;
		}
		helper(nums, i + 1, sum + nums[i], target);
		helper(nums, i + 1, sum - nums[i], target);
	}
}
