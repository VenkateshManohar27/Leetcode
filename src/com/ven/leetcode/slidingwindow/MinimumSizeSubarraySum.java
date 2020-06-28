package com.ven.leetcode.slidingwindow;

/**
 * Given an array of n positive integers and a positive integer s, find the
 * minimal length of a contiguous subarray of which the sum >= s. If there isn't
 * one, return 0 instead.
 * 
 * Example:
 * 
 * Input: s = 7, nums = [2,3,1,2,4,3] Output: 2 Explanation: the subarray [4,3]
 * has the minimal length under the problem constraint. Follow up: If you have
 * figured out the O(n) solution, try coding another solution of which the time
 * complexity is O(n log n).
 * 
 * @author Venkatesh Manohar
 *
 */
public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int result = Integer.MAX_VALUE;
		int left = 0;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			while (sum >= s) {
				sum -= nums[left];
				result = Math.min(result, i + 1 - left);
				left++;
			}
		}

		return (result == Integer.MAX_VALUE) ? 0 : result;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum ms = new MinimumSizeSubarraySum();
		System.out.println(ms.minSubArrayLen(7, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(ms.minSubArrayLen(100, new int[] { 2, 3, 1, 2, 4, 3 }));
		System.out.println(ms.minSubArrayLen(100, new int[] { 2, 3, 1, 2, 4, 100 }));
	}
}
