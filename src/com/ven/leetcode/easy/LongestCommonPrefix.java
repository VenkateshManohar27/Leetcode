package com.ven.leetcode.easy;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		int length = strs[0].length();
		char c;
		for (int i = 0; i < length; i++) {
			c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() - 1 < i || strs[j].charAt(i) != c) {
					return sb.toString();
				}
			}

			sb.append(c);
		}

		return sb.toString();
	}
}
