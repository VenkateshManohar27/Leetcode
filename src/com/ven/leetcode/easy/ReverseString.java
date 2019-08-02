package com.ven.leetcode.easy;

/**
 * Write a function that reverses a string. The input string is given as an
 * array of characters char[].
 * 
 * Do not allocate extra space for another array, you must do this by modifying
 * the input array in-place with O(1) extra memory.
 * 
 * You may assume all the characters consist of printable ascii characters.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"] Example 2:
 * 
 * Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseString {
	public void reverseString(char[] s) {
		int i = 0, j = s.length - 1;

		while (i < j) {
			char temp = s[j];
			s[j--] = s[i];
			s[i++] = temp;
		}
	}

	public void reverseString2(char[] s) {
		String str = s.toString();
		s = str.toCharArray();
	}

}
