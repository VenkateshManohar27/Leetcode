package com.ven.leetcode.may2021.challenge;

/**
 * Given a string s, return the string after replacing every uppercase letter
 * with the same lowercase letter.
 * 
 * Example 1:
 * 
 * Input: s = "Hello" Output: "hello" Example 2:
 * 
 * Input: s = "here" Output: "here" Example 3:
 * 
 * Input: s = "LOVELY" Output: "lovely"
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100 s consists of printable ASCII characters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ToLowerCase {
	public String toLowerCase(String s) {
		char[] a = s.toCharArray();

		for (int i = 0; i < a.length; i++) {
			char c = a[i];
			int indUpper = c - 'A';
			if (indUpper >= 0 && indUpper <= 26) {
				a[i] = (char) ('a' + indUpper);
			}

		}
		return new String(a);
	}
}
