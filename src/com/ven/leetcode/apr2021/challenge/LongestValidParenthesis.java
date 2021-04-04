package com.ven.leetcode.apr2021.challenge;
// this does not work
public class LongestValidParenthesis {
	public int longestValidParentheses(String A) {
        int length = 0;
        int validParenthesis = 0;
        int max = 0;
        for(int i = 0; i< A.length(); i++){
            char c = A.charAt(i);
            if(c == '('){
            	validParenthesis++;
            }else{
            	if(validParenthesis > 0) {
            		validParenthesis--;
            		length +=2;
            		max = Math.max(max, length);
            	}
            	if(validParenthesis < 0) {
            		validParenthesis = 0;
            		length = 0;
            	}
            }
            
            
        }
        
        return max;
    }
	
	public static void main(String[] args) {
		LongestValidParenthesis l = new LongestValidParenthesis();
		System.out.println(l.longestValidParentheses("(()"));
		System.out.println(l.longestValidParentheses(""));
		System.out.println(l.longestValidParentheses(")()())"));
	}
}
