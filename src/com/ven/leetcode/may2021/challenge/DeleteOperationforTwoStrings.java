package com.ven.leetcode.may2021.challenge;

import java.util.Arrays;

import com.ven.utility.ArrayUtility;

/**
 * Given two strings word1 and word2, return the minimum number of steps
 * required to make word1 and word2 the same.
 * 
 * In one step, you can delete exactly one character in either string.
 * 
 * Example 1:
 * 
 * Input: word1 = "sea", word2 = "eat" Output: 2 Explanation: You need one step
 * to make "sea" to "ea" and another step to make "eat" to "ea". Example 2:
 * 
 * Input: word1 = "leetcode", word2 = "etco" Output: 4
 * 
 * Constraints:
 * 
 * 1 <= word1.length, word2.length <= 500 word1 and word2 consist of only
 * lowercase English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class DeleteOperationforTwoStrings {
	public int minDistance(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0)
					continue;
				if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		ArrayUtility.print(dp);
		return (m + n) - 2 * dp[m][n];
	}

	public int minDistance2(String word1, String word2) {
		int m = word1.length();
		int n = word2.length();
		int[][] dp = new int[m + 1][n + 1];
		return m + n - 2 * lcs(word1, word2, m, n, dp);

	}

	private int lcs(String w1, String w2, int m, int n, int[][] dp) {
		if (m == 0 || n == 0) {
			return 0;
		}
		if (dp[m][n] > 0)
			return dp[m][n];
		if (w1.charAt(m - 1) == w2.charAt(n - 1)) {
			dp[m][n] = 1 + lcs(w1, w2, m - 1, n - 1, dp);
		} else {
			dp[m][n] = Math.max(lcs(w1, w2, m, n - 1, dp), lcs(w1, w2, m - 1, n, dp));
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		DeleteOperationforTwoStrings d = new DeleteOperationforTwoStrings();
		System.out.println(d.minDistance("sea", "eat"));
		System.out.println(d.minDistance("sea", "eeat"));

		System.out.println(d.minDistance2("sea", "eat"));
		System.out.println(d.minDistance2("sea", "eeat"));
	}
}
