package com.ven.leetcode.week16A;

import java.util.Arrays;

/**
 * You are given an integer array nums and an integer target.
 * 
 * You want to build an expression out of nums by adding one of the symbols '+'
 * and '-' before each integer in nums and then concatenate all the integers.
 * 
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1
 * and concatenate them to build the expression "+2-1". Return the number of
 * different expressions that you can build, which evaluates to target.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,1,1,1,1], target = 3 Output: 5 Explanation: There are 5 ways
 * to assign symbols to make the sum of nums be target 3. -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3 +1 + 1 - 1 + 1 + 1 = 3 +1 + 1 + 1 - 1 + 1 = 3 +1 + 1 +
 * 1 + 1 - 1 = 3 Example 2:
 * 
 * Input: nums = [1], target = 1 Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 20 0 <= nums[i] <= 1000 0 <= sum(nums[i]) <= 1000 -1000
 * <= target <= 1000
 * 
 * @author Venkatesh Manohar
 *
 */
public class TargetSum {
	int count = 0;

	public int findTargetSumWays(int[] nums, int target) {
		helper(nums, 0, 0, target);
		return count;
	}

	private void helper(int[] nums, int sum, int i, int t) {
		if (i == nums.length) {
			// System.out.println(s +" , sum:"+sum);
			if (sum == t) {
				count++;
			}
			return;
		}

		helper(nums, sum + nums[i], i + 1, t);
		helper(nums, sum - nums[i], i + 1, t);
	}

	public int findTargetSumWaysOp(int[] nums, int target) {
		int[][] memo = new int[nums.length][2001];
		for (int i = 0; i < memo.length; i++) {
			Arrays.fill(memo[i], Integer.MIN_VALUE);
		}
		return helperOp(nums, 0, 0, target, memo);
	}

	private int helperOp(int[] nums, int sum, int i, int t, int[][] memo) {
		if (i == nums.length) {
			// System.out.println(s +" , sum:"+sum);
			if (sum == t) {
				return 1;
			} else {
				return 0;
			}
		}
		if (memo[i][sum + 1000] != Integer.MIN_VALUE) {
			return memo[i][sum + 1000];
		}

		int add = helperOp(nums, sum + nums[i], i + 1, t, memo);
		int sub = helperOp(nums, sum - nums[i], i + 1, t, memo);
		memo[i][sum + 1000] = add + sub;
		return memo[i][sum + 1000];
	}
	
	public static void main(String[] args) {
		TargetSum s = new TargetSum();
		System.out.println(s.findTargetSumWaysOp(new int[] {1, 1,1,1,1}, 3));
		
	}
}
