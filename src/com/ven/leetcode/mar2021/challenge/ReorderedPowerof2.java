package com.ven.leetcode.mar2021.challenge;

import java.util.Arrays;

/**
 * You are given an integer n. We reorder the digits in any order (including the
 * original order) such that the leading digit is not zero.
 * 
 * Return true if and only if we can do this so that the resulting number is a
 * power of two.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: n = 1 Output: true Example 2:
 * 
 * Input: n = 10 Output: false Example 3:
 * 
 * Input: n = 16 Output: true Example 4:
 * 
 * Input: n = 24 Output: false Example 5:
 * 
 * Input: n = 46 Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= n <= 109
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReorderedPowerof2 {
	public boolean reorderedPowerOf2(int N) {
		int[] A = count(N);
		for (int i = 0; i < 31; ++i)
			if (Arrays.equals(A, count(1 << i)))
				return true;
		return false;
	}

	// Returns the count of digits of N
	// Eg. N = 112223334, returns [0,2,3,3,1,0,0,0,0,0]
	public int[] count(int N) {
		int[] ans = new int[10];
		while (N > 0) {
			ans[N % 10]++;
			N /= 10;
		}
		return ans;
	}
}
