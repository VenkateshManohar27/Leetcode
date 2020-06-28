package com.ven.leetcode.dp;

/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product.
 * 
 * Example 1:
 * 
 * Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
 * Example 2:
 * 
 * Input: [-2,0,-1] Output: 0 Explanation: The result cannot be 2, because
 * [-2,-1] is not a subarray.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		long max = nums[0];
		long min = max;
		long maxProduct = max;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= 0) {
				max = Math.max(nums[i], max * nums[i]);
				min = Math.min(nums[i], min * nums[i]);
			} else {
				long temp = max;
				max = Math.max(nums[i], min * nums[i]);
				min = Math.min(nums[i], temp * nums[i]);
			}
			maxProduct = Math.max(maxProduct, max);

		}
		return (int) maxProduct;
	}

	
	public static void main(String[] args) {
		MaximumProductSubarray mp = new MaximumProductSubarray();
		System.out.println(mp.maxProduct(new int[] {}));
		System.out.println(mp.maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(mp.maxProduct(new int[] { -2, 0, -1 }));
		System.out.println(mp.maxProduct(new int[] { 1, 10, 10, -1, 5, 100 }));
		System.out.println(mp.maxProduct(new int[] { 1, 10, 10, -10, 10, 100 }));
		System.out.println(mp.maxProduct(new int[] { -2, 3, -4 }));
		System.out.println(mp.maxProduct(new int[] { -2, 3, -4, 5, 10, -10 }));
		System.out.println(mp.maxProduct(new int[] { -2, 3, -4, 5, 10, -10, -10 }));

	}
}
