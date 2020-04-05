package com.ven.leetcode.binarysearch;

public class BinarySearch {
	public int search(int[] nums, int target) {
		int res = -1;
		res = binarySearch(0, nums.length - 1, nums, target);
		return res;
	}

	private int binarySearch(int start, int end, int[] nums, int target) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return binarySearch(start, mid - 1, nums, target);
		} else {
			return binarySearch(mid + 1, end, nums, target);
		}
	}
	
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.search(new int[] {-1,0,3,5,9,12}, 9));
		System.out.println(bs.search(new int[] {-1,0,3,5,9,12}, 2));
	}
}
