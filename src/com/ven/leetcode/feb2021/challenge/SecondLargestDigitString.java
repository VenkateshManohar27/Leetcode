package com.ven.leetcode.feb2021.challenge;

/**
 * Given an alphanumeric string s, return the second largest numerical digit
 * that appears in s, or -1 if it does not exist.
 * 
 * An alphanumeric string is a string consisting of lowercase English letters
 * and digits.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "dfa12321afd" Output: 2 Explanation: The digits that appear in s
 * are [1, 2, 3]. The second largest digit is 2. Example 2:
 * 
 * Input: s = "abc1111" Output: -1 Explanation: The digits that appear in s are
 * [1]. There is no second largest digit.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500 s consists of only lowercase English letters and/or
 * digits.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SecondLargestDigitString {
	public int secondHighest(String s) {
		int first = -1, second = -1;
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				int cur = s.charAt(i) - '0';
				if (first == -1) {
					first = cur;
				} else if (cur > first) {
					second = first;
					first = cur;
				} else if (cur < first) {
					second = Math.max(second, cur);
				}
			}
		}
		return second;
	}
}
