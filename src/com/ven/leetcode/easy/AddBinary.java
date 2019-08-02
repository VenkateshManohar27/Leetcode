package com.ven.leetcode.easy;

public class AddBinary {
	public String addBinary(String a, String b) {
		int i = a.length() - 1, j = b.length() - 1, c = 0;
		StringBuilder sb = new StringBuilder();

		while (i >= 0 || j >= 0 || c == 1) {
			int aVal = (i < 0) ? 0 : a.charAt(i--) - '0';
			int bVal = (j < 0) ? 0 : b.charAt(j--) - '0';

			sb.insert(0,  (char) ('0' + aVal ^ bVal ^ c));
			c = (aVal + bVal + c) >> 1;
		}

		return sb.toString();
	}
}
