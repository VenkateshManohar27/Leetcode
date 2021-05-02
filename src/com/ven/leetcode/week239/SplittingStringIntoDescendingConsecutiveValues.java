package com.ven.leetcode.week239;

/**
 * You are given a string s that consists of only digits.
 * 
 * Check if we can split s into two or more non-empty substrings such that the
 * numerical values of the substrings are in descending order and the difference
 * between numerical values of every two adjacent substrings is equal to 1.
 * 
 * For example, the string s = "0090089" can be split into ["0090", "089"] with
 * numerical values [90,89]. The values are in descending order and adjacent
 * values differ by 1, so this way is valid. Another example, the string s =
 * "001" can be split into ["0", "01"], ["00", "1"], or ["0", "0", "1"]. However
 * all the ways are invalid because they have numerical values [0,1], [0,1], and
 * [0,0,1] respectively, all of which are not in descending order. Return true
 * if it is possible to split s as described above, or false otherwise.
 * 
 * A substring is a contiguous sequence of characters in a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "1234" Output: false Explanation: There is no valid way to split
 * s. Example 2:
 * 
 * Input: s = "050043" Output: true Explanation: s can be split into ["05",
 * "004", "3"] with numerical values [5,4,3]. The values are in descending order
 * with adjacent values differing by 1. Example 3:
 * 
 * Input: s = "9080701" Output: false Explanation: There is no valid way to
 * split s. Example 4:
 * 
 * Input: s = "10009998" Output: true Explanation: s can be split into ["100",
 * "099", "98"] with numerical values [100,99,98]. The values are in descending
 * order with adjacent values differing by 1.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SplittingStringIntoDescendingConsecutiveValues {
	public boolean splitString(String s) {
		return helper(s, 0, -1, 0);
	}

	private boolean helper(String s, int start, long prev, int split) {
		if (start == s.length()) {
			if (split > 1) {
				System.out.println(prev);
				return true;
			}
			return false;
		}

		for (int i = start; i < s.length(); i++) {
			String sub = s.substring(start, i + 1);
			long num = -1;
			try {
				// the String to int conversion happens here
				num = Long.parseLong(sub);
			} catch (NumberFormatException nfe) {
				return false;
			}
			if (prev != -1) {
				if (num > prev) {
					return false;
				}
				if (!(prev - num == 1)) {
					continue;
				}
			}
			boolean res = helper(s, i + 1, num, split + 1);
			if (res) {
				System.out.println(prev);
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		SplittingStringIntoDescendingConsecutiveValues b = new SplittingStringIntoDescendingConsecutiveValues();
		System.out.println(b.splitString("99999999999999999998"));
		// System.out.println(b.splitString("010000000000000000"));
		/*
		 * System.out.println(b.splitString("1234"));
		 * System.out.println(b.splitString("050043"));
		 * System.out.println(b.splitString("9080701"));
		 * System.out.println(b.splitString("10009998"));
		 * System.out.println(b.splitString("21474836482147483647"));
		 */

	}
}
