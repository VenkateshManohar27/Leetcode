package com.ven.leetcode.easy;

public class RotateArray {
	//Runtime: 100 ms, faster than 5.61% ,Memory Usage: 36.6 MB, less than 57.76%
	public static void rotateBubble(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;

		k = k % nums.length;
		for (int i = 0; i < k; i++) {
			for (int j = nums.length - 1; j > 0; j--) {
				int temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
			}
		}
	}
	//Runtime: 0 ms, faster than 100.00%, Memory Usage: 36.4 MB, less than 58.15%
	public static void rotate(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return;
		k = k % nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);

	}

	private static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
}
