package com.ven.leetcode.arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * Input: [3,4,5,1,2] Output: 1 Example 2:
 * 
 * Input: [4,5,6,7,0,1,2] Output: 0
 * 
 * @author Venkatesh Manohar
 *
 */
public class MinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums == null)
			return -1;
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int m = start + (end - start) / 2;
			if (nums[m] > nums[end])
				start = m + 1;
			else
				end = m;
		}
		return nums[start];
	}

	public static void main(String[] args) {
		MinimumInRotatedSortedArray m = new MinimumInRotatedSortedArray();
		System.out.println("Min is: " + m.findMin(new int[] { 4, 5, 6, 7, 0, 1, 2 }));
		System.out.println("Min is: " + m.findMin(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println("Min is: " + m.findMin(new int[] { 9, 1, 2, 3, 4, 5, 6, 7, 8 }));
		System.out.println("Min is: " + m.findMin(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }));
		System.out.println("Min is: " + m.findMin(new int[] { 2, 1 }));
		// System.out.println("Min is: " + m.findMin(nums));
	}
}
