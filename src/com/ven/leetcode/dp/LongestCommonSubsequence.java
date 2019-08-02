package com.ven.leetcode.dp;

public class LongestCommonSubsequence {
	public int longestCommonSubsequence(String str1, String str2) {
		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();
		int[][] arr = new int[chars1.length + 1][chars2.length + 1];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (i == 0 || j == 0) {
					arr[i][j] = 0;
				} else if (chars1[i - 1] == chars2[j - 1]) {
					arr[i][j] = arr[i - 1][j - 1] + 1;
				} else {
					arr[i][j] = Math.max(arr[i][j - 1], arr[i - 1][j]);
				}

			}
		}

		return arr[chars1.length][chars2.length];
	}
}
