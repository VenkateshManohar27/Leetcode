package com.ven.leetcode.sepchallenge;

import java.util.Stack;

/**
 * Given a non-empty string check if it can be constructed by taking a substring
 * of it and appending multiple copies of the substring together. You may assume
 * the given string consists of lowercase English letters only and its length
 * will not exceed 10000.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "abab" Output: True Explanation: It's the substring "ab" twice.
 * Example 2:
 * 
 * Input: "aba" Output: False Example 3:
 * 
 * Input: "abcabcabcabc" Output: True Explanation: It's the substring "abc" four
 * times. (And the substring "abcabc" twice.)
 * 
 * @author Venkatesh Manohar
 *
 */
public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String s) {
		return (s + s).indexOf(s, 1) < s.length();
	}

	public static void main(String[] args) {
		RepeatedSubstringPattern r = new RepeatedSubstringPattern();
		System.out.println(r.repeatedSubstringPattern("abab"));
		System.out.println(r.repeatedSubstringPattern("aba"));
		System.out.println(r.repeatedSubstringPattern("abcabcabcabc"));
		System.out.println(r.repeatedSubstringPattern("abcaabcaabcaabca"));
	}
}
