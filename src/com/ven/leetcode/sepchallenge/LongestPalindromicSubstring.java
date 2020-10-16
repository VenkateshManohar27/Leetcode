package com.ven.leetcode.sepchallenge;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume
 * that the maximum length of s is 1000.
 * 
 * Example 1:
 * 
 * Input: "babad" Output: "bab" Note: "aba" is also a valid answer. Example 2:
 * 
 * Input: "cbbd" Output: "bb"
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestPalindromicSubstring {
	int start = 0;
	int end = 0;
	int longest = 0;

	public String longestPalindrome(String s) {
		start = 0;
		end = 0;
		longest = 0;
		if (s == null || s.length() <= 1) {
			return s;
		}

		for (int i = 0; i < s.length(); i++) {
			expand(s, i, i);
			expand(s, i, i+1);
		}

		return s.substring(start, end + 1);
	}

	private void expand(String s, int st , int e) {
		int max = 0;
		while (st >= 0 && e < s.length()) {

			if (s.charAt(st) != s.charAt(e)) {
				break;
			}
			max = Math.max(max, e - st);
			if (max > longest) {
				longest = max;
				start = st;
				end = e;
			}
			st--;
			e++;
		}

	}

	public static void main(String[] args) {
		LongestPalindromicSubstring l = new LongestPalindromicSubstring();
		System.out.println(l.longestPalindrome("cbbd"));
		System.out.println(l.longestPalindrome("babad"));
		System.out.println(l.longestPalindrome("cabmadambam"));
		System.out.println(l.longestPalindrome("a"));
		System.out.println(l.longestPalindrome(""));
		System.out.println(l.longestPalindrome("aa"));
		System.out.println(l.longestPalindrome("ab"));
		System.out.println(l.longestPalindrome("cccc"));
		System.out.println(l.longestPalindrome("ccc"));
		System.out.println(l.longestPalindrome("madam"));
	}
}
