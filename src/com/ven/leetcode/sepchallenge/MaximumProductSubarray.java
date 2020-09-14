package com.ven.leetcode.sepchallenge;

public class MaximumProductSubarray {
	public int maxProduct(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int min = max;
		int maxProduct = max;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] >= 0) {
				max = Math.max(nums[i], max * nums[i]);
				min = Math.min(nums[i], min * nums[i]);
			} else {
				int temp = max;
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
		System.out.println(mp.maxProduct(new int[] { 1, 2, 3, 4, -5, 6, 7, -8 }));
		System.out.println(mp.maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(mp.maxProduct(new int[] { -2, 0, -1 }));
		System.out.println(mp.maxProduct(new int[] { 1, 10, 10, -1, 5, 100 }));
		System.out.println(mp.maxProduct(new int[] { 1, 10, 10, -10, 10, 100 }));
		System.out.println(mp.maxProduct(new int[] { -2, 3, -4 }));
		System.out.println(mp.maxProduct(new int[] { -2, 3, -4, 5, 10, -10 }));
		System.out.println(mp.maxProduct(new int[] { -2, 3, -4, 5, 10, -10, -10 }));
	}
}
