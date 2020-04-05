package com.ven.leetcode.greedy;

import java.util.Stack;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 * 
 * Given a balanced string s split it in the maximum amount of balanced strings.
 * 
 * Return the maximum amount of splitted balanced strings.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "RLRRLLRLRL" Output: 4 Explanation: s can be split into "RL",
 * "RRLL", "RL", "RL", each substring contains same number of 'L' and 'R'.
 * Example 2:
 * 
 * Input: s = "RLLLLRRRLR" Output: 3 Explanation: s can be split into "RL",
 * "LLLRRR", "LR", each substring contains same number of 'L' and 'R'. Example
 * 3:
 * 
 * Input: s = "LLLLRRRR" Output: 1 Explanation: s can be split into "LLLLRRRR".
 * Example 4:
 * 
 * Input: s = "RLRRRLLRLL" Output: 2 Explanation: s can be split into "RL",
 * "RRRLLRLL", since each substring contains an equal number of 'L' and 'R'
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s[i] = 'L' or 'R'
 * 
 * @author Venkatesh Manohar
 *
 */
public class SplitBalancedStrings {
	public int balancedStringSplit(String s) {
		int splits = 0;
		Stack<Character> st = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (st.isEmpty()) {
				st.add(c);
			} else {
				if (st.peek() == c) {
					st.add(c);
				} else {
					st.pop();
					if (st.isEmpty()) {
						splits++;
					}
				}
			}
		}
		return splits;
	}

	public int balancedStringSplit2(String s) {
		int R = 0;
		int L = 0;
		int count = 0;
		for (char c : s.toCharArray()) {
			if (c == 'R')
				++R;
			else
				++L;
			if (R == L) {
				++count;
				R = L = 0;
			}
		}

		return count;
	}
}
