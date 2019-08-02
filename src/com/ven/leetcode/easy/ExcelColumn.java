package com.ven.leetcode.easy;

public class ExcelColumn {
	public String convertToTitle(int n) {
		StringBuilder sb = new StringBuilder();
		while (n > 0) {
			n--;
			sb.insert(0, (char) ((n % 26) + 'A'));
			n /= 26;
		}
		return sb.toString();
	}

	public int convertToColumnNumber(String s) {
		int result = 0;

		char[] chars = s.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			result *= 26;
			result += (chars[i] - 'A') + 1;
		}

		return result;
	}
	
	public int convertToColumnNumber2(String s) {
		int result = 0;
		for (int i = 0; i < s.length(); i++) {
			result *= 26;
			result += (s.charAt(i) - 'A') + 1;
		}
		return result;
	}
}
