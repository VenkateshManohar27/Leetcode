package com.ven.leetcode.easy;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * Example:
 * 
 * Input: [0,1,0,3,12] Output: [1,3,12,0,0] Note:
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				continue;
			} else {
				for (int j = i; j < nums.length; j++) {
					if (nums[j] != 0) {
						nums[i] = nums[j];
						nums[j] = 0;
						break;
					}
				}
			}

		}

	}

	public void moveZeroesOptimized(int[] nums) {
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 0) {
				if (index != i) {
					nums[index] = nums[i];
					nums[i] = 0;
				}
				index++;
			}
		}
	}

	public static void main(String[] args) {
		MoveZeroes mz = new MoveZeroes();
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		mz.moveZeroes(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
		nums = new int[] { 1, 3, 2, 0, 0 };
		mz.moveZeroes(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();

		nums = new int[] { 0, 0, 1, 3, 2, 0, 0 };
		mz.moveZeroes(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();

		nums = new int[] { 0, 1, 0, 3, 12 };
		mz.moveZeroesOptimized(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
		nums = new int[] { 1, 3, 2, 0, 0 };
		mz.moveZeroesOptimized(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();

		nums = new int[] { 0, 0, 1, 3, 2, 0, 0 };
		mz.moveZeroesOptimized(nums);

		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + ",");
		}
		System.out.println();
	}
}
