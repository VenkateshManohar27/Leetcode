package com.ven.leetcode.week210;

/**
 * A string is a valid parentheses string (denoted VPS) if it meets one of the
 * following:
 * 
 * It is an empty string "", or a single character not equal to "(" or ")", It
 * can be written as AB (A concatenated with B), where A and B are VPS's, or It
 * can be written as (A), where A is a VPS. We can similarly define the nesting
 * depth depth(S) of any VPS S as follows:
 * 
 * depth("") = 0 depth(A + B) = max(depth(A), depth(B)), where A and B are VPS's
 * depth("(" + A + ")") = 1 + depth(A), where A is a VPS. For example, "",
 * "()()", and "()(()())" are VPS's (with nesting depths 0, 1, and 2), and ")("
 * and "(()" are not VPS's.
 * 
 * Given a VPS represented as string s, return the nesting depth of s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "(1+(2*3)+((8)/4))+1" Output: 3 Explanation: Digit 8 is inside of
 * 3 nested parentheses in the string. Example 2:
 * 
 * Input: s = "(1)+((2))+(((3)))" Output: 3 Example 3:
 * 
 * Input: s = "1+(2*3)/(2-1)" Output: 1 Example 4:
 * 
 * Input: s = "1" Output: 0
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 100 s consists of digits 0-9 and characters '+', '-', '*',
 * '/', '(', and ')'. It is guaranteed that parentheses expression s is a VPS.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximumNestingDepthParentheses {
	public int maxDepth(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		int parenthesis = 0;
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '(') {
				parenthesis++;
			}else if(s.charAt(i) == ')'){
				parenthesis--;
			}
			max = Math.max(parenthesis, max);
		}
		return max;
	}

	public static void main(String[] args) {
		MaximumNestingDepthParentheses m = new MaximumNestingDepthParentheses();
		System.out.println(m.maxDepth(""));
		System.out.println(m.maxDepth("(1+(2*3)+((8)/4))+1"));
		System.out.println(m.maxDepth("1+(2*3)/(2-1)"));
		System.out.println(m.maxDepth("1"));
	}
}
