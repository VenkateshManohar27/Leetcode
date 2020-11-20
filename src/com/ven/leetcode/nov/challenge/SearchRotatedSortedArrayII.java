package com.ven.leetcode.nov.challenge;

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
		int index = -1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i - 1] > nums[i]) {
				index = i;
				break;
			}
		}

		// System.out.println("index:"+index);
		if (index == -1) {
			// System.out.println("No rotation");
			return binSearch(nums, 0, nums.length - 1, target);
		}
		return binSearch(nums, 0, index - 1, target) || binSearch(nums, index, nums.length - 1, target);

	}

	private boolean binSearch(int[] nums, int start, int end, int target) {

		while (start <= end) {

			int mid = start + (end - start) / 2;
			// System.out.println("mid:"+mid);
			if (nums[mid] == target)
				return true;
			if (nums[mid] > target) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		SearchRotatedSortedArrayII s = new SearchRotatedSortedArrayII();
		System.out.println(s.search(new int[] {2,5,6,0,0,1,2}, 0));
		System.out.println(s.search(new int[] {2,5,6,0,0,1,2}, 3));
		
	}
}
