package com.ven.leetcode.sepchallenge;

/**
 * Your are given an array of positive integers nums.
 * 
 * Count and print the number of (contiguous) subarrays where the product of all
 * the elements in the subarray is less than k.
 * 
 * Example 1: Input: nums = [10, 5, 2, 6], k = 100 Output: 8 Explanation: The 8
 * subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5],
 * [5, 2], [2, 6], [5, 2, 6]. Note that [10, 5, 2] is not included as the
 * product of 100 is not strictly less than k. Note:
 * 
 * 0 < nums.length <= 50000. 0 < nums[i] < 1000. 0 <= k < 10^6.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SubarrayProductLessThanK {
	public int numSubarrayProductLessThanK(int[] nums, int k) {
		int count = 0;
		int product = 1;
		for (int start = 0, end = 0; end < nums.length; end++) {
			product *= nums[end];
			while (product >= k && start <= end) {
				product /= nums[start++];
			}
			count += end - start + 1;
		}
		return count;
	}

	public static void main(String[] args) {
		SubarrayProductLessThanK s = new SubarrayProductLessThanK();
		System.out.println(s.numSubarrayProductLessThanK(new int[] { 10, 5, 2, 6 }, 100));
	}
}
