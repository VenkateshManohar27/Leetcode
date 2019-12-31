package com.ven.leetcode.stack;

import java.util.Stack;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string
 * concatenation. For example, "", "()", "(())()", and "(()(()))" are all valid
 * parentheses strings.
 * 
 * A valid parentheses string S is primitive if it is nonempty, and there does
 * not exist a way to split it into S = A+B, with A and B nonempty valid
 * parentheses strings.
 * 
 * Given a valid parentheses string S, consider its primitive decomposition: S =
 * P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
 * 
 * Return S after removing the outermost parentheses of every primitive string
 * in the primitive decomposition of S.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: "(()())(())" Output: "()()()" Explanation: The input string is
 * "(()())(())", with primitive decomposition "(()())" + "(())". After removing
 * outer parentheses of each part, this is "()()" + "()" = "()()()". Example 2:
 * 
 * Input: "(()())(())(()(()))" Output: "()()()()(())" Explanation: The input
 * string is "(()())(())(()(()))", with primitive decomposition "(()())" +
 * "(())" + "(()(()))". After removing outer parentheses of each part, this is
 * "()()" + "()" + "()(())" = "()()()()(())". Example 3:
 * 
 * Input: "()()" Output: "" Explanation: The input string is "()()", with
 * primitive decomposition "()" + "()". After removing outer parentheses of each
 * part, this is "" + "" = "".
 * 
 * @author Venkatesh Manohar
 *
 */
public class RemoveOutermostParentheses {
	public String removeOuterParentheses2(String S) {
		if (S == null || S.length() == 0)
			return S;

		StringBuilder sb = new StringBuilder();
		Stack<Integer> s = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			int j = 0;
			char ch = S.charAt(i);
			if (ch == '(')
				s.push(i);
			else
				j = s.pop();
			if (s.isEmpty())
				sb.append(S.substring(j + 1, i));
		}
		return sb.toString();
	}

	public String removeOuterParentheses(String S) {
		if (S == null || S.length() == 0)
			return S;

		StringBuilder sb = new StringBuilder();
		Stack<String> s = new Stack<>();
		for (int i = 0; i < S.length(); i++) {

			char ch = S.charAt(i);
			if (ch == '(') {
				s.push("(");
			} else {

				StringBuilder temp = new StringBuilder();
				boolean found = false;
				while (!s.isEmpty() && !found) {
					String top = s.pop();

					if (top.equals("(")) {
						found = true;

						if (!s.isEmpty()) {
							temp.insert(0, top);
							temp.append(")");
							s.push(temp.toString());
						}

					} else {
						temp.insert(0, top);
					}

					if (s.isEmpty()) {
						sb.append(temp);
					}
				}

			}
		}
		return sb.toString();

	}

	public static void main(String[] args) {
		RemoveOutermostParentheses rop = new RemoveOutermostParentheses();
		System.out.println(rop.removeOuterParentheses("(()())(())"));
		System.out.println(rop.removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(rop.removeOuterParentheses("()()"));
		System.out.println(rop.removeOuterParentheses("(()())(())(()(()))"));
		System.out.println(rop.removeOuterParentheses("((()())(()()))"));// "(()())(()())"
	}
}
