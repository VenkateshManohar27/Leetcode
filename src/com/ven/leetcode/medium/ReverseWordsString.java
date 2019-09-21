package com.ven.leetcode.medium;

/**
 * Given an input string, reverse the string word by word.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "the sky is blue" Output: "blue is sky the" Example 2:
 * 
 * Input: " hello world! " Output: "world! hello" Explanation: Your reversed
 * string should not contain leading or trailing spaces. Example 3:
 * 
 * Input: "a good example" Output: "example good a" Explanation: You need to
 * reduce multiple spaces between two words to a single space in the reversed
 * string.
 * 
 * 
 * Note:
 * 
 * A word is defined as a sequence of non-space characters. Input string may
 * contain leading or trailing spaces. However, your reversed string should not
 * contain leading or trailing spaces. You need to reduce multiple spaces
 * between two words to a single space in the reversed string.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseWordsString {
	/**
	 * Runtime: 6 ms, faster than 53.93% of Java online submissions for Reverse
	 * Words in a String. Memory Usage: 37.9 MB, less than 58.06% of Java online
	 * submissions for Reverse Words in a String.
	 * 
	 * @param s
	 * @return
	 */
	public String reverseWords(String s) {
		if (s == null) {
			return null;
		}
		s = s.trim();
		String[] strs = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			sb.append(strs[i] + " ");
		}

		return sb.toString().trim();
	}
	
	public String reverseWords2(String s) {
		if (s == null) {
			return null;
		}
		s = s.trim();
		String[] strs = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = strs.length - 1; i >= 0; i--) {
			sb.append(strs[i] + " ");
		}

		return sb.toString().trim();
	}
	
	
}
