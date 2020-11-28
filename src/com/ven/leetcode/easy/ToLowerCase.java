package com.ven.leetcode.easy;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns
 * the same string in lowercase.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "Hello" Output: "hello" Example 2:
 * 
 * Input: "here" Output: "here" Example 3:
 * 
 * Input: "LOVELY" Output: "lovely"
 * 
 * @author Venkatesh Manohar
 *
 */
public class ToLowerCase {
	public String toLowerCase(String str) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			int c = (str.charAt(i) - 'A');
			// System.out.println(c);
			if (c >= 0 && c < 26) {
				sb.append((char) ('a' + c));
			} else {
				sb.append(str.charAt(i));
			}
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		
	}
}
