package com.ven.leetcode.feb2021.challenge;

public class RomanToInt {
	public int romanToInt(String s) {
		int res = 0;
		for (int i = s.length() - 1; i >= 0; i--) {
			if (i + 1 < s.length() && getInt(s.charAt(i)) < getInt(s.charAt(i + 1))) {
				res = res - getInt(s.charAt(i));
			} else {
				res += getInt(s.charAt(i));
			}
		}
		return res;
	}

	private int getInt(char c) {
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		}
		return 0;
	}

	public static void main(String[] args) {
		RomanToInt r = new RomanToInt();
		System.out.println(r.romanToInt("III"));
		System.out.println(r.romanToInt("IV"));
		System.out.println(r.romanToInt("IX"));
		System.out.println(r.romanToInt("LVIII"));
		System.out.println(r.romanToInt("MCMXCIV"));
	}
}
