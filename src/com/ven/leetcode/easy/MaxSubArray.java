package com.ven.leetcode.easy;

public class MaxSubArray {
	public static int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			sum = Math.max(nums[i], sum+nums[i]);
			maxSum = Math.max(maxSum, sum);
		}
		return maxSum;
	}

	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 }));
	}
}
