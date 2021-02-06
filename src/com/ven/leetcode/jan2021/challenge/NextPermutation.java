package com.ven.leetcode.jan2021.challenge;

import java.util.Arrays;

import com.ven.utility.ArrayUtility;

/**
 * Implement next permutation, which rearranges numbers into the
 * lexicographically next greater permutation of numbers.
 * 
 * If such an arrangement is not possible, it must rearrange it as the lowest
 * possible order (i.e., sorted in ascending order).
 * 
 * The replacement must be in place and use only constant extra memory.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3] Output: [1,3,2] Example 2:
 * 
 * Input: nums = [3,2,1] Output: [1,2,3] Example 3:
 * 
 * Input: nums = [1,1,5] Output: [1,5,1] Example 4:
 * 
 * Input: nums = [1] Output: [1]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 100 0 <= nums[i] <= 100
 * 
 * @author Venkatesh Manohar
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int high = 0;
		int nexthigh = -1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[high] <= nums[i]) {
				nexthigh = high;
				high = i;
			}
		}

		if (nexthigh == -1) {
			Arrays.sort(nums);
		} else {
			int temp = nums[high];
			nums[high] = nums[nexthigh];
			nums[nexthigh] = temp;
		}
	}

	public static void main(String[] args) {
		NextPermutation p = new NextPermutation();
		int[] nums = new int[] { 1, 2, 3 };
		p.nextPermutation(nums);
		ArrayUtility.print(nums);

		nums = new int[] { 3, 2, 1 };
		p.nextPermutation(nums);
		ArrayUtility.print(nums);

		nums = new int[] { 1, 1, 5 };
		p.nextPermutation(nums);
		ArrayUtility.print(nums);

		nums = new int[] { 1 };
		p.nextPermutation(nums);
		ArrayUtility.print(nums);
		
		nums = new int[] { 1, 1, 1 };
		p.nextPermutation(nums);
		ArrayUtility.print(nums);
		
		nums = new int[] { 1, 2 };
		p.nextPermutation(nums);
		ArrayUtility.print(nums);
		
		nums = new int[] { 1, 2, 3, 4, 5 };
		p.nextPermutation(nums);
		ArrayUtility.print(nums);
	}
}
