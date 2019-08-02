package com.ven.leetcode.easy;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			char opposite = getOpposite(c);
			if (opposite != '0') {
				if (st.isEmpty())
					return false;
				char top = st.pop();
				if (top != opposite) {
					return false;
				}

			} else {
				st.push(c);
			}
		}
		return st.isEmpty();
	}

	private char getOpposite(char c) {
		switch (c) {
		case ')':
			return '(';
		case '}':
			return '{';
		case ']':
			return '[';
		default:
			return '0';
		}
	}

	public static void main(String[] args) {
		ValidParentheses vp = new ValidParentheses();
		System.out.println(vp.isValid("()"));
	}
}
