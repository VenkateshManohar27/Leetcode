package com.ven.leetcode.easy;

public class RemoveDuplicatesSortedArray {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		// The pointer to non duplicate array
		int length = 0;
		for (int j = 0; j < nums.length; j++) {
			/*
			 * if pointer to non duplicate array and the current index j is not equal then
			 * swap the next element of the non duplicate array with current index j
			 */
			if (nums[j] != nums[length]) {
				nums[++length] = nums[j];
			}
		}
		// length is 1 greater as it started with zero index
		return ++length;
	}

	public int removeElement(int[] nums, int val) {
		int i = 0;
		int n = nums.length;
		while (i < n) {
			if (nums[i] == val) {
				nums[i] = nums[n - 1];
				// reduce array size by one
				n--;
			} else {
				i++;
			}
		}
		return n;
	}

	public static void main(String[] args) {
		int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4 };
		int len = removeDuplicates(nums);
		for (int i = 0; i < len; i++) {
			System.out.print(nums[i]);
		}
	}

}
