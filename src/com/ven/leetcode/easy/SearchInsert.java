package com.ven.leetcode.easy;

public class SearchInsert {
	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0 || nums[0] == target) {
			return 0;
		}
		if (target == nums[nums.length - 1]) {
			return nums.length - 1;
		}
		if (target > nums[nums.length - 1]) {
			return nums.length;
		}
		int low = 0;
		int high = nums.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (nums[mid] > target) {
				high = mid - 1;
			} else if (nums[mid] < target) {
				low = mid + 1;
			}
		}
		return high + 1;
	}
}
