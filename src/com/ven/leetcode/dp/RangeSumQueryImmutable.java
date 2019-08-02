package com.ven.leetcode.dp;

public class RangeSumQueryImmutable {
	int[] cache = null;

	public RangeSumQueryImmutable(int[] nums) {
		cache = new int[nums.length + 1];
		for (int i = 0; i < nums.length; i++) {
			cache[i + 1] = nums[i] + cache[i];
		}

	}

	public int sumRange(int i, int j) {
		return cache[j + 1] - cache[i];
	}
}
