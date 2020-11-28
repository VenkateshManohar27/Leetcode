package com.ven.leetcode.nov.challenge;

import java.util.ArrayDeque;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * 
 * The expression string contains only non-negative integers, +, -, *, /
 * operators and empty spaces . The integer division should truncate toward
 * zero.
 * 
 * Example 1:
 * 
 * Input: "3+2*2" Output: 7 Example 2:
 * 
 * Input: " 3/2 " Output: 1 Example 3:
 * 
 * Input: " 3+5 / 2 " Output: 5 Note:
 * 
 * You may assume that the given expression is always valid. Do not use the eval
 * built-in library function.
 * 
 * @author Venkatesh Manohar
 *
 */
public class BasicCalculatorII {
	public int calculate(String s) {
		if(s == null || s.length() == 0) {
			return 0;
		}
		
		ArrayDeque<Integer> st = new ArrayDeque<>();
		int number = 0;
		char operation = '+';
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(Character.isDigit(c)) {
				number = number * 10 + c-'0';
			}
			if(!Character.isDigit(c) && !Character.isWhitespace(c) || i == s.length()-1) {
				if(operation == '-') {
					st.push(-number);
				}
				if(operation == '+') {
					st.push(number);
				}
				if(operation == '*') {
					st.push(st.pop() * number);
				}
				if(operation == '/') {
					st.push(st.pop() / number);
				}
				number = 0;
				operation = c;
			}
			
		}
		/*if(number > 0) {
			st.push(number);
		}*/
		int res = 0;
		while(!st.isEmpty()) {
			res += st.pop();
		}
		return res;
	}
	
	public static void main(String[] args) {
		BasicCalculatorII c = new BasicCalculatorII();
		System.out.println(c.calculate("33+2*5"));
	}
}
