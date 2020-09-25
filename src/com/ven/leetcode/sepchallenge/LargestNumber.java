package com.ven.leetcode.sepchallenge;

/**
 * Given a list of non negative integers, arrange them such that they form the
 * largest number.
 * 
 * Example 1:
 * 
 * Input: [10,2] Output: "210" Example 2:
 * 
 * Input: [3,30,34,5,9] Output: "9534330" Note: The result may be very large, so
 * you need to return a string instead of an integer.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LargestNumber {
	// This approach causes TLE refer /Leetcode/src/com/ven/sorting/LargestNumber.java
	private static String result = "0";

	public String largestNumber(int[] nums) {
		result = "0";
		if (nums == null || nums.length == 0) {
			return String.valueOf(0);
		}

		helper(new StringBuilder(), 0, nums);
		return result;
	}

	private void helper(StringBuilder sb, int index, int[] nums) {
		if (index == nums.length) {

			if (sb.toString().compareTo(result) > 0) {
				result = sb.toString();
			}
		}
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == -1) {
				continue;
			}
			int temp = nums[i];
			int size = sb.length();
			sb.append(temp);
			nums[i] = -1;
			helper(sb, index + 1, nums);
			sb.delete(size, sb.length());
			nums[i] = temp;
		}

	}

	public static void main(String[] args) {
		LargestNumber l = new LargestNumber();
		System.out.println(l.largestNumber(new int[] { 10, 2 }));
		System.out.println(l.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(l.largestNumber(new int[] { 999999998, 999999997, 999999999 }));
		System.out.println(l.largestNumber(new int[] {  }));
		System.out.println(l.largestNumber(new int[] { 0 }));
		System.out.println(l.largestNumber(new int[] {9,9,9,9,9,8,8,8,8,8}));
	}
}
