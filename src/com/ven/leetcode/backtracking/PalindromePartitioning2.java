package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * Example:
 * 
 * Input: "aab" Output: [ ["aa","b"], ["a","a","b"] ]
 * 
 * @author Venkatesh Manohar
 *
 */
class Result {
	int min = Integer.MAX_VALUE;
}

public class PalindromePartitioning2 {
	public int minCut(String s) {
		// List<List<String>> partitions = new ArrayList<>();
		if (s == null || s.length() == 0) {
			return 0;
		}
		Result r = new Result();
		helper(s.toCharArray(), 0, 0, r);

		return r.min;
	}

	private void helper(char[] chars, int pos, int min, Result res) {
		if (pos == chars.length) {
			if(res.min > min) {
				res.min = min;
			}
			return;
		}

		for (int i = pos; i < chars.length; i++) {
			if (isPalindrome(chars, pos, i)) {
				helper(chars, i + 1, min+1, res);
			}
		}

	}

	public boolean isPalindrome(char[] chr, int start, int end) {
		while (start < end) {
			if (chr[start++] != chr[end--]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartitioning2 pp = new PalindromePartitioning2();

		System.out.println(pp.minCut("aab"));
		System.out.println(pp.minCut("ababababababababababababcbabababababababababababa"));
	}
}
