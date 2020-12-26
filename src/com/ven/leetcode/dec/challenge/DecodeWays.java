package com.ven.leetcode.dec.challenge;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing only
 * digits, determine the total number of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12" Output: 2 Explanation: It could be decoded as "AB" (1 2) or "L"
 * (12). Example 2:
 * 
 * Input: "226" Output: 3 Explanation: It could be decoded as "BZ" (2 26), "VF"
 * (22 6), or "BBF" (2 2 6).
 * 
 * @author Venkatesh Manohar
 *
 */
public class DecodeWays {
	public int numDecodings(String s) {
		int[] dp = new int[s.length() + 1];
		dp[0] = 1;
		dp[1] = s.charAt(0) == '0' ? 0 : 1;

		for (int i = 2; i < dp.length; i++) {
			int oneDigit = Integer.parseInt(s.substring(i - 1, i));
			int twoDigit = Integer.parseInt(s.substring(i - 2, i));

			if (oneDigit >= 1) {
				dp[i] += dp[i - 1];
			}
			if (twoDigit >= 10 && twoDigit <= 26) {
				dp[i] += dp[i - 2];
			}
		}

		return dp[s.length()];
	}

	public static void main(String[] args) {
		DecodeWays dw = new DecodeWays();
		System.out.println(dw.numDecodings("12"));
		System.out.println(dw.numDecodings("226"));
		System.out.println(dw.numDecodings("2626"));
		System.out.println(dw.numDecodings("012"));
		System.out.println(dw.numDecodings("110"));
		System.out.println(dw.numDecodings("101"));
		System.out.println(dw.numDecodings(
				"6065812287883668764831544958683283296479682877898293612168136334983851946827579555449329483852397155"));
	}
}
