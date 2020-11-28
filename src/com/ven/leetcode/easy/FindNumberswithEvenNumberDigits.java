package com.ven.leetcode.easy;

/**
 * Given an array nums of integers, return how many of them contain an even
 * number of digits.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [12,345,2,6,7896] Output: 2 Explanation: 12 contains 2 digits
 * (even number of digits). 345 contains 3 digits (odd number of digits). 2
 * contains 1 digit (odd number of digits). 6 contains 1 digit (odd number of
 * digits). 7896 contains 4 digits (even number of digits). Therefore only 12
 * and 7896 contain an even number of digits. Example 2:
 * 
 * Input: nums = [555,901,482,1771] Output: 1 Explanation: Only 1771 contains an
 * even number of digits.
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 500 1 <= nums[i] <= 10^5
 * 
 * @author Venkatesh Manohar
 *
 */
public class FindNumberswithEvenNumberDigits {
	public int findNumbers(int[] nums) {
		int num = 0;
		for (int i = 0; i < nums.length; i++) {
			int curr = nums[i];
			int digits = 0;
			while (curr > 0) {
				curr /= 10;
				digits--;
			}
			if (digits % 2 == 0)
				num++;

		}
		return num;
	}

	public static void main(String[] args) {
		FindNumberswithEvenNumberDigits f = new FindNumberswithEvenNumberDigits();
		System.out.println(f.findNumbers(new int[] { 12, 345, 2, 6, 7896 }));
		System.out.println(f.findNumbers(new int[] { 555, 901, 482, 1771 }));
	}
}
