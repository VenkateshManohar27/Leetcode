package com.ven.leetcode.dp;

public class LongestPalindromicSubstring {

	public static String longestPalindrome(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}
		int N = s.length();

		boolean[][] isPalindrome = new boolean[N][N];
		int left = 0;
		int right = 0;
		for (int j = 1; j < N; j++) {
			for (int i = 0; i < j; i++) {
				boolean isPalindromicWord = false;
				if (isPalindrome[i + 1][j - 1] || (j - i) <= 2) {
					isPalindromicWord = true;
				}

				if (s.charAt(i) == s.charAt(j) && isPalindromicWord) {
					isPalindrome[i][j] = true;
					if (j - i > right - left) {
						right = j;
						left = i;
					}
				}
				/*for (int k = 0; k < isPalindrome.length; k++) {
					for (int k2 = 0; k2 < isPalindrome.length; k2++) {
						System.out.print(isPalindrome[k][k2] + ",");
					}
					System.out.println();
				}
				System.out.println();*/
			}
		}

		return s.substring(left, right + 1);
	}

	public static void main(String[] args) {
		System.out.println(LongestPalindromicSubstring.longestPalindrome("babad"));
		System.out.println(LongestPalindromicSubstring.longestPalindrome("madam"));
		System.out.println(LongestPalindromicSubstring.longestPalindrome("abaabc"));
		System.out.println(LongestPalindromicSubstring.longestPalindrome("babad"));
	}
}
