package com.ven.leetcode.week211;

/**
 * Given an integer n, return the number of strings of length n that consist
 * only of vowels (a, e, i, o, u) and are lexicographically sorted.
 * 
 * A string s is lexicographically sorted if for all valid i, s[i] is the same
 * as or comes before s[i+1] in the alphabet.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: 5 Explanation: The 5 sorted strings that consist of
 * vowels only are ["a","e","i","o","u"]. Example 2:
 * 
 * Input: n = 2 Output: 15 Explanation: The 15 sorted strings that consist of
 * vowels only are
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"].
 * Note that "ea" is not a valid string since 'e' comes after 'a' in the
 * alphabet. Example 3:
 * 
 * Input: n = 33 Output: 66045
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 50
 * 
 * @author Venkatesh Manohar
 *
 */
public class CountSortedVowelStrings {
	public int countVowelStrings(int n) {
		int MOD = 1000_000_007;

		long[][] dp = new long[n + 1][5]; // dp[i][j] := a string of length 'i' ends with a vowel represented by index
											// 'j'

		// vowel & index mapping
		// a: 0
		// e: 1
		// i: 2
		// o: 3
		// u: 4

		// Initialize dp
		// 'a': dp[1][0] = 1
		// 'e': dp[1][1] = 1
		// 'i': dp[1][2] = 1
		// 'o': dp[1][3] = 1
		// 'u': dp[1][4] = 1
		for (int i = 0; i < 5; i++) {
			dp[1][i] = 1;
		}

		// State transition
		for (int i = 2; i <= n; i++) {
			dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % MOD; // 'a' can
																											// follow
																											// {'a','e',
																											// 'i','o',
																											// 'u'}
			dp[i][1] = (dp[i - 1][1] + dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % MOD; // 'e' can follow {'e',
																							// 'i','o', 'u'}
			dp[i][2] = (dp[i - 1][2] + dp[i - 1][3] + dp[i - 1][4]) % MOD; // 'i' can follow {'i', 'o','u'}
			dp[i][3] = (dp[i - 1][3] + dp[i - 1][4]) % MOD; // 'o' can follow {'o','u'}
			dp[i][4] = (dp[i - 1][4]) % MOD; // 'u' can follow {'u'}
		}

		long count = 0;

		for (long d : dp[n]) {
			count += d;
			count %= MOD;
		}

		return (int) count;
	}
}
