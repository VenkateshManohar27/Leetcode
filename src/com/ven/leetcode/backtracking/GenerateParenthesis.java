package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations
 * of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * 
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class GenerateParenthesis {
	public List<String> generateParenthesis(int n) {
		List<String> combinations = new ArrayList<String>();
		if(n<=0) {
			return combinations;
		}
		generate(n,n,"", combinations);
		return combinations;
	}

	private void generate(int leftParenthesis, int rightParenthesis, String s, List<String> combinations) {
		if(leftParenthesis ==0 && rightParenthesis ==0) {
			combinations.add(s);
		}
		
		if(leftParenthesis>0) {
			generate(leftParenthesis-1, rightParenthesis, s+"(", combinations);
		}
		if(rightParenthesis>leftParenthesis) {
			generate(leftParenthesis, rightParenthesis-1, s+")", combinations);
		}
	}
	public static void main(String[] args) {
		GenerateParenthesis gp = new GenerateParenthesis();
		System.out.println(gp.generateParenthesis(1));
		System.out.println(gp.generateParenthesis(2));
		System.out.println(gp.generateParenthesis(3));
	}
}
