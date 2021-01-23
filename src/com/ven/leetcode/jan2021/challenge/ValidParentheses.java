package com.ven.leetcode.jan2021.challenge;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * Open brackets must be closed by the same type of brackets. Open brackets must
 * be closed in the correct order.
 * 
 * 
 * Example 1:
 * 
 * Input: s = "()" Output: true Example 2:
 * 
 * Input: s = "()[]{}" Output: true Example 3:
 * 
 * Input: s = "(]" Output: false Example 4:
 * 
 * Input: s = "([)]" Output: false Example 5:
 * 
 * Input: s = "{[]}" Output: true
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s consists of parentheses only '()[]{}'.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ValidParentheses {
	public boolean isValid(String s) {
		if (s == null || s.trim().length() <= 1)
			return false;
		char[] ch = new char[s.length()];
		int idx = -1;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '{' || c == '[') {
				ch[++idx] = c;
			} else if (c == ')') {
				if (idx == -1 || ch[idx--] != '(') {
					return false;
				}
			} else if (c == ']') {
				if (idx == -1 || ch[idx--] != '[') {
					return false;
				}
			} else if (c == '}') {
				if (idx == -1 || ch[idx--] != '{') {
					return false;
				}
			}
		}
		if (idx != -1)
			return false;
		return true;

	}
}
