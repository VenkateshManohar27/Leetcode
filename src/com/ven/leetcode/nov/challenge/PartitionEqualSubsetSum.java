package com.ven.leetcode.nov.challenge;

/**
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,5,11,5] Output: true Explanation: The array can be
 * partitioned as [1, 5, 5] and [11]. Example 2:
 * 
 * Input: nums = [1,2,3,5] Output: false Explanation: The array cannot be
 * partitioned into equal sum subsets.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200 1 <= nums[i] <= 100
 * 
 * @author Venkatesh Manohar
 *
 */
public class PartitionEqualSubsetSum {
	Boolean[][] memo = null;

	public boolean canPartition(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum % 2 != 0)
			return false;
		memo = new Boolean[nums.length + 1][sum / 2 + 1];
		return isSubset(nums, sum / 2, nums.length - 1);
	}

	private boolean isSubset(int[] nums, int target, int end) {
		if (target == 0) {
			return true;
		}

		if (end == 0 || target < 0)
			return false;

		// check if subSetSum for given n is already computed and stored in memo
		if (memo[end][target] != null)
			return memo[end][target];

		if (nums[end - 1] > target) {
			return isSubset(nums, target, end - 1);
		}

		boolean result = isSubset(nums, target, end - 1) || isSubset(nums, target - nums[end], end - 1);
		memo[end][target] = result;
		return result;
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
		System.out.println(p.canPartition(new int[] { 1, 2, 3, 4 }));
		System.out.println(p.canPartition(new int[] { 1, 2, 5 }));
		System.out.println(p.canPartition(new int[] { 1, 2, 3, 10 }));
	}
}
