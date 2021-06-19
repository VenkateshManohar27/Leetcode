package com.ven.leetcode.june2021.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * Example 1:
 * 
 * Input: n = 3 Output: ["((()))","(()())","(())()","()(())","()()()"] Example
 * 2:
 * 
 * Input: n = 1 Output: ["()"]
 * 
 * Constraints:
 * 
 * 1 <= n <= 8
 * 
 * @author Venkatesh Manohar
 *
 */
public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> l = new ArrayList<>();
		generate(0, 0, n, new StringBuilder(), l);
		return l;
	}

	private void generate(int left, int right, int n, StringBuilder s, List<String> l) {
		// System.out.println("left:"+left+", right:"+right+", s:"+s);
		if (left > n || right > n) {
			return;
		}
		if (left == n && right == n) {
			l.add(s.toString());
			return;
		}

		if (left >= right) {
			s.append("(");
			generate(left + 1, right, n, s, l);
			s.deleteCharAt(s.length() - 1);
		}

		if (right < left) {
			s.append(")");
			generate(left, right + 1, n, s, l);
			s.deleteCharAt(s.length() - 1);
		}
	}
}
