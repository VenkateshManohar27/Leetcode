package com.ven.leetcode.feb2021.challenge;

public class MinimumChangesToMakeAlternatingBinaryString {
	public static char flip(char ch) {
		return (ch == '0') ? '1' : '0';
	}

	public static int getFlipWithStartingCharcter(String str, char expected) {
		int flipCount = 0;
		for (int i = 0; i < str.length(); i++) {

			if (str.charAt(i) != expected)
				flipCount++;

			expected = flip(expected);
		}
		return flipCount;
	}

	public static int minOperations(String s) {
		return Math.min(getFlipWithStartingCharcter(s, '0'), getFlipWithStartingCharcter(s, '1'));
	}
}
