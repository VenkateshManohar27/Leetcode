package com.ven.leetcode.week5;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note: The length of num is less than 10002 and will be >= k. The given num
 * does not contain any leading zero. Example 1:
 * 
 * Input: num = "1432219", k = 3 Output: "1219" Explanation: Remove the three
 * digits 4, 3, and 2 to form the new number 1219 which is the smallest. Example
 * 2:
 * 
 * Input: num = "10200", k = 1 Output: "200" Explanation: Remove the leading 1
 * and the number is 200. Note that the output must not contain leading zeroes.
 * Example 3:
 * 
 * Input: num = "10", k = 2 Output: "0" Explanation: Remove all the digits from
 * the number and it is left with nothing which is 0.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if(k == 0) return num;
        if(k == num.length()) return "0";
        
        ArrayDeque<Character> stk = new ArrayDeque<>();
        for(char c : num.toCharArray()){
            while(!stk.isEmpty() && k > 0 && stk.peek() > c){
                stk.pop();
                k--;
            }
            stk.push(c);
        }
        
        for(int i = 0; i < k; i++){
            stk.pop();
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()){
            sb.append(stk.pop());
        }
        sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
	
	public static void main(String[] args) {
		RemoveKDigits r = new RemoveKDigits();
		System.out.println(r.removeKdigits("1432219", 3));
	}
}
