package com.ven.leetcode.binarysearch;

public class SearchRotatedSortedArray {
	public int search(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		int pivot = findIndex(nums, start, end);
		if (pivot == -1)
			return binarySearch(start, end, target, nums);
		if (nums[pivot] == target) {
			return pivot;
		}

		if (nums[0] <= target)
			return binarySearch(0, pivot - 1, target, nums);

		return binarySearch(pivot + 1, end, target, nums);
	}

	public int findIndex(int[] nums, int start, int end) {
		if (start > end) {
			return -1;
		}

		int mid = start + (end - start) / 2;

		if (mid < end && nums[mid] > nums[mid + 1])
			return mid;
		if (mid > start && nums[mid] < nums[mid - 1])
			return (mid - 1);

		if (nums[start] > nums[mid]) {
			return findIndex(nums, start, mid - 1);
		} else {
			return findIndex(nums, mid + 1, end);
		}

	}

	public int binarySearch(int start, int end, int target, int[] nums) {

		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (nums[mid] == target) {
				return mid;
			} else if (target < nums[mid]) {
				return binarySearch(start, mid - 1, target, nums);
			} else {
				return binarySearch(mid + 1, end, target, nums);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		SearchRotatedSortedArray sr = new SearchRotatedSortedArray();

		System.out.println(sr.findIndex(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0, 6));
	}
}
