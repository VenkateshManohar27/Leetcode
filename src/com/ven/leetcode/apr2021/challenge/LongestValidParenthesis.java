package com.ven.leetcode.apr2021.challenge;

import java.util.Stack;

// this does not work
public class LongestValidParenthesis {
	public int longestValidParentheses(String s) {
		int maxans = 0;
		Stack<Integer> stack = new Stack<>();
		stack.push(-1);
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(i);
			} else {
				stack.pop();
				if (stack.empty()) {
					stack.push(i);
				} else {
					maxans = Math.max(maxans, i - stack.peek());
				}
			}
		}
		return maxans;
    }
	
	public static void main(String[] args) {
		LongestValidParenthesis l = new LongestValidParenthesis();
		System.out.println(l.longestValidParentheses("(()"));
		System.out.println(l.longestValidParentheses(""));
		System.out.println(l.longestValidParentheses(")()())"));
	}
}
