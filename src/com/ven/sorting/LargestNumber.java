package com.ven.sorting;

import java.util.Arrays;

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
	public String largestNumber(int[] nums) {
		if (nums == null || nums.length == 0) {
			return "";
		}
		String[] str = new String[nums.length];
		for (int i = 0; i < nums.length; i++) {
			str[i] = "" + nums[i];
		}

		// Step 2: Sort strings according to custom comparator.
        Arrays.sort(str, (a, b) -> (b + a).compareTo(a + b));

        // Step 3: Convert string array to a single string and also handle the case when input array contains all zeros
		return str[0].equals("0") ? "0" : String.join("", str);
	}

	public static void main(String[] args) {
		LargestNumber ln = new LargestNumber();
		System.out.println(ln.largestNumber(new int[] { 10, 2 }));
		System.out.println(ln.largestNumber(new int[] { 3, 30, 34, 5, 9 }));
		System.out.println(ln.largestNumber(new int[] { 10, 2 }));

	}
}
