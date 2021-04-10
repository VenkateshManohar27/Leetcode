package com.ven.leetcode.apr2021.challenge;

/**
 * You are given an array of binary strings strs and two integers m and n.
 * 
 * Return the size of the largest subset of strs such that there are at most m
 * 0's and n 1's in the subset.
 * 
 * A set x is a subset of a set y if all elements of x are also elements of y.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: strs = ["10","0001","111001","1","0"], m = 5, n = 3 Output: 4
 * Explanation: The largest subset with at most 5 0's and 3 1's is {"10",
 * "0001", "1", "0"}, so the answer is 4. Other valid but smaller subsets
 * include {"0001", "1"} and {"10", "1", "0"}. {"111001"} is an invalid subset
 * because it contains 4 1's, greater than the maximum of 3. Example 2:
 * 
 * Input: strs = ["10","0","1"], m = 1, n = 1 Output: 2 Explanation: The largest
 * subset is {"0", "1"}, so the answer is 2.
 * 
 * 
 * Constraints:
 * 
 * 1 <= strs.length <= 600 1 <= strs[i].length <= 100 strs[i] consists only of
 * digits '0' and '1'. 1 <= m, n <= 100
 * 
 * @author Venkatesh Manohar
 *
 */
public class OnesandZeroes {
	public int findMaxForm(String[] strs, int m, int n) {
		int[] ms = new int[strs.length];
		int[] ns = new int[strs.length];
		for (int i = 0; i < strs.length; ++i) {
			String s = strs[i];
			for (int j = 0; j < s.length(); ++j) {
				char c = s.charAt(j);
				if (c == '0')
					++ms[i];
				else
					++ns[i];
			}
		}
		int[][] dp = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 0; i < ms.length; ++i) {
			for (int mm = m; mm >= ms[i]; --mm) {
				for (int nn = n; nn >= ns[i]; --nn) {
					dp[mm][nn] = Math.max(dp[mm][nn], dp[mm - ms[i]][nn - ns[i]] + 1);
				}
			}
		}
		return dp[m][n];
	}
}
