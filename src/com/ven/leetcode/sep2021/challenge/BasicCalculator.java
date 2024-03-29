package com.ven.leetcode.sep2021.challenge;

import java.util.Stack;

/**
 * Given a string s representing a valid expression, implement a basic
 * calculator to evaluate it, and return the result of the evaluation.
 * 
 * Note: You are not allowed to use any built-in function which evaluates
 * strings as mathematical expressions, such as eval().
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "1 + 1" Output: 2 Example 2:
 * 
 * Input: s = " 2-1 + 2 " Output: 3 Example 3:
 * 
 * Input: s = "(1+(4+5+2)-3)+(6+8)" Output: 23
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 3 * 105 s consists of digits, '+', '-', '(', ')', and ' '. s
 * represents a valid expression. '+' is not used as a unary operation. '-'
 * could be used as a unary operation but it has to be inside parentheses. There
 * will be no two consecutive operators in the input. Every number and running
 * calculation will fit in a signed 32-bit integer.
 * 
 * @author Venkatesh Manohar
 *
 */
public class BasicCalculator {
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
        int result = 0, sign = 1;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == ' ') continue;
            if (Character.isDigit(c)) {
                int number = Character.getNumericValue(c);
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    number = number * 10 + Character.getNumericValue(s.charAt(i + 1));
                    i++;
                }
                result += sign * number;
            } 
            else if (c == '+') sign = 1;
            else if (c == '-') sign = -1;
            else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                int prevSign = stack.pop();
                int prevRes = stack.pop();
                result = prevSign * result + prevRes;
            }
        }
        
        return result;
	}
	
	public static void main(String[] args) {
		BasicCalculator c = new BasicCalculator();
		System.out.println(c.calculate("1 + 1"));
		System.out.println(c.calculate(" 2-1 + 2 "));
		System.out.println(c.calculate("(1+(4+5+2)-3)+(6+8)"));
		System.out.println(c.calculate("-2+ 1"));
		System.out.println(c.calculate("- (3 + (4 + 5))"));
	}
}
