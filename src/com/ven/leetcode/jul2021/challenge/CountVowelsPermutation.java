package com.ven.leetcode.jul2021.challenge;

/**
 * Given an integer n, your task is to count how many strings of length n can be
 * formed under the following rules:
 * 
 * Each character is a lower case vowel ('a', 'e', 'i', 'o', 'u') Each vowel 'a'
 * may only be followed by an 'e'. Each vowel 'e' may only be followed by an 'a'
 * or an 'i'. Each vowel 'i' may not be followed by another 'i'. Each vowel 'o'
 * may only be followed by an 'i' or a 'u'. Each vowel 'u' may only be followed
 * by an 'a'. Since the answer may be too large, return it modulo 10^9 + 7.
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: 5 Explanation: All possible strings are: "a", "e", "i" ,
 * "o" and "u". Example 2:
 * 
 * Input: n = 2 Output: 10 Explanation: All possible strings are: "ae", "ea",
 * "ei", "ia", "ie", "io", "iu", "oi", "ou" and "ua". Example 3:
 * 
 * Input: n = 5 Output: 68
 * 
 * Constraints:
 * 
 * 1 <= n <= 2 * 10^4
 * 
 * @author Venkatesh Manohar
 *
 */
public class CountVowelsPermutation {
	public int countVowelPermutation(int n) {
		long a = 1L, e = 1L, i = 1L, o = 1L, u = 1l;
		int MOD = 1_000_000_007;
		for (int j = 1; j < n; j++) {
			long an = (e + i + u) % MOD;
			long en = (a + i) % MOD;
			long in = (e + o) % MOD;
			long on = (i) % MOD;
			long un = (i + o) % MOD;
			a = an;
			e = en;
			i = in;
			o = on;
			u = un;
		}

		return (int) ((a + e + i + o + u) % MOD);
	}
}
