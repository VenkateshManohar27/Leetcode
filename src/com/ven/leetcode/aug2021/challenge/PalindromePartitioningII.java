package com.ven.leetcode.aug2021.challenge;

import java.util.Arrays;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return the minimum cuts needed for a palindrome partitioning of s.
 * 
 * Example 1:
 * 
 * Input: s = "aab" Output: 1 Explanation: The palindrome partitioning
 * ["aa","b"] could be produced using 1 cut. Example 2:
 * 
 * Input: s = "a" Output: 0 Example 3:
 * 
 * Input: s = "ab" Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 2000 s consists of lower-case English letters only.
 * 
 * @author Venkatesh Manohar
 *
 */
public class PalindromePartitioningII {
	private int n;
	int[] DP;

	private boolean isPalindrome(String s, int l, int r) {
		while (l < r) {
			if (s.charAt(l) != s.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}

	private int dp(int i, String s) {
		if (DP[i] >= 0)
			return DP[i];
		DP[i] = Integer.MAX_VALUE;
		for (int j = i; j < n; j++) {
			if (isPalindrome(s, i, j)) {
				DP[i] = Math.min(DP[i], dp(j + 1, s) + 1);
			}
		}
		return DP[i];
	}

	public int minCut(String s) {
		n = s.length();
		DP = new int[n + 1];
		Arrays.fill(DP, -1);
		DP[n] = 0;
		return dp(0, s) - 1;
	}
}
