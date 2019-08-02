package com.ven.leetcode.easy;

import java.util.HashMap;

/**
 * Given a string which consists of lowercase or uppercase letters, find the
 * length of the longest palindromes that can be built with those letters.
 * 
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * 
 * Note: Assume the length of given string will not exceed 1,010.
 * 
 * Example:
 * 
 * Input: "abccccdd"
 * 
 * Output: 7
 * 
 * Explanation: One longest palindrome that can be built is "dccaccd", whose
 * length is 7.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		int[] count = new int[52];
		for (char c : s.toCharArray()) {
			if (Character.isLowerCase(c)) {
				count[c - 'a']++;
			} else {
				count[c - 'A' + 26]++;
			}
		}
		int result = 0;
		boolean flag = false;
		/*
		 * For a string to be palindrome it should have even num of chars with only one
		 * odd num chars
		 */
		for (int i : count) {
			if (i % 2 == 0) {
				result += i;
			} else {
				result += i - 1;
				flag = true;
			}
		}
		if (flag)
			result++;

		return result;
	}

	/*
	 * Runtime: 5 ms, faster than 45.69% of Java online submissions for Longest
	 * Palindrome. Memory Usage: 35.5 MB, less than 99.19% of Java online
	 * submissions for Longest Palindrome.
	 */
	public int longestPalindromeHashMap(String s) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}

		int result = 0;
		boolean flag = false;
		/*
		 * For a string to be palindrome it should have even num of chars with only one
		 * odd num chars
		 */
		for (int i : map.values()) {
			if (i % 2 == 0) {
				result += i;
			} else {
				result += i - 1;
				flag = true;
			}
		}
		if (flag)
			result++;

		return result;
	}
}
