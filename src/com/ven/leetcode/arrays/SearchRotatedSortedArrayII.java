package com.ven.leetcode.arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true,
 * otherwise return false.
 * 
 * Example 1:
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0 Output: true Example 2:
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3 Output: false Follow up:
 * 
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may
 * contain duplicates. Would this affect the run-time complexity? How and why?
 * 
 * @author Venkatesh Manohar
 *
 */
public class SearchRotatedSortedArrayII {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		int minIndex = findMinIndex(nums);

		if (target == nums[minIndex]) {
			return true;
		} else if (target > nums[minIndex] && target <= nums[nums.length - 1]) {
			return binarySearch(minIndex + 1, nums.length - 1, nums, target) >= 0;
		} else if (target >= nums[0] && (minIndex > 0 && target <= nums[minIndex - 1])) {
			return binarySearch(0, minIndex - 1, nums, target) >= 0;
		}
		return false;
	}

	private int binarySearch(int start, int end, int[] nums, int target) {
		if (end < start) {
			return -1;
		}

		int mid = start + (end - start) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] < target) {
			return binarySearch(mid + 1, end, nums, target);
		} else {
			return binarySearch(start, mid - 1, nums, target);
		}

	}

	private int findMinIndex(int[] nums) {
		if (nums == null)
			return -1;
		int index = 0 ;
		
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i] > nums[i+1]) {
				return i+1;
			}
		}
		return index;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 5, 6, 0, 0, 1, 2 };
		SearchRotatedSortedArrayII sa = new SearchRotatedSortedArrayII();
		System.out.println(sa.search(nums, 0));
		System.out.println(sa.search(nums, 3));
		nums = new int[] { 3, 1 };

		System.out.println(sa.search(nums, 3));

		nums = new int[] { 1 };

		System.out.println(sa.search(nums, 2));
		
		System.out.println(sa.search(nums, 1));
		
		nums = new int[] { 1,2,3,4,5 };

		System.out.println(sa.search(nums, 2));
		
		System.out.println(sa.search(nums, 1));
		
		nums = new int[] { 2,3,4,5, 1};

		System.out.println(sa.search(nums, 2));
		
		System.out.println(sa.search(nums, 1));
		
		nums = new int[] { 1, 1, 3, 1};

		System.out.println(sa.search(nums, 3));
		
	}
}
