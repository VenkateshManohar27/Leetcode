package com.ven.leetcode.arrays;

import com.ven.utility.ArrayUtility;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order
 * red, white and blue.
 * 
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white,
 * and blue respectively.
 * 
 * Note: You are not suppose to use the library's sort function for this
 * problem.
 * 
 * Example:
 * 
 * Input: [2,0,2,1,1,0] Output: [0,0,1,1,2,2] Follow up:
 * 
 * A rather straight forward solution is a two-pass algorithm using counting
 * sort. First, iterate the array counting number of 0's, 1's, and 2's, then
 * overwrite array with total number of 0's, then 1's and followed by 2's. Could
 * you come up with a one-pass algorithm using only constant space?
 * 
 * @author Venkatesh Manohar
 *
 */
public class SortColors {
	public void sortColors(int[] nums) {
		int zeroes = 0;
		int ones = 0;
		int twos = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				zeroes++;
			} else if (nums[i] == 1) {
				ones++;
			} else {
				twos++;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (zeroes != 0) {
				nums[i] = 0;
				zeroes--;
			} else if (ones != 0) {
				nums[i] = 1;
				ones--;
			} else {
				nums[i] = 2;
				twos--;
			}
		}
	}

	public void sortColors2(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int i = 0;
		while (i <= right) {
			if (nums[i] == 0) {
				swap(nums, left, i);
				left++;
				i++;
			} else if (nums[i] == 1) {
				i++;
			} else {
				swap(nums, right, i);
				right--;
			}
		}

	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {
		SortColors sc = new SortColors();
		int[] nums = new int[] { 2, 0, 2, 1, 1, 0 };

		sc.sortColors(nums);
		ArrayUtility.print(nums);

		nums = new int[] { 2, 0, 2, 1, 1, 0 };

		sc.sortColors2(nums);
		ArrayUtility.print(nums);

	}
}
