package com.ven.leetcode.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	public int countIncreasingSubsequence(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int[] arr = new int[nums.length];
		int max = 1;
		Arrays.fill(arr, 1);
		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					arr[i] = Math.max(arr[i], arr[j] + 1);
					if (arr[i] > max) {
						max = arr[i];
					}
				}
			}
		}

		return max;
	}
}
