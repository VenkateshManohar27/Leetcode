package com.ven.leetcode.medium;

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
		List<String> list = new ArrayList<>();
		if (n <= 0) {
			return list;
		}

		generateParenthesis(n, n, "", list);
		return list;

	}

	private void generateParenthesis(int numOfLeftParenthesis, int numOfRightParenthesis, String parenString,
			List<String> list) {
		if (numOfLeftParenthesis == 0 && numOfRightParenthesis == 0) {
			list.add(parenString);
			return;
		}

		if (numOfLeftParenthesis > 0) {
			generateParenthesis(numOfLeftParenthesis - 1, numOfRightParenthesis, parenString + "(", list);
		}
		if (numOfRightParenthesis > numOfLeftParenthesis) {
			generateParenthesis(numOfLeftParenthesis, numOfRightParenthesis - 1, parenString + ")", list);
		}
	}

	public static void main(String[] args) {
		GenerateParenthesis gp = new GenerateParenthesis();
		List<String> list = gp.generateParenthesis(1);
		for (String s : list) {
			System.out.println(s);
		}
		System.out.println("When n = 2");
		list = gp.generateParenthesis(2);
		for (String s : list) {
			System.out.println(s);
		}
		
		System.out.println("When n = 3");
		list = gp.generateParenthesis(3);
		for (String s : list) {
			System.out.println(s);
		}
	}
}
