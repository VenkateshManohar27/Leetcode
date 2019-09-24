package com.ven.google;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character.
 * 
 * Example 1:
 * 
 * Input: S = "ab#c", T = "ad#c" Output: true Explanation: Both S and T become
 * "ac". Example 2:
 * 
 * Input: S = "ab##", T = "c#d#" Output: true Explanation: Both S and T become
 * "". Example 3:
 * 
 * Input: S = "a##c", T = "#a#c" Output: true Explanation: Both S and T become
 * "c". Example 4:
 * 
 * Input: S = "a#c", T = "b" Output: false Explanation: S becomes "c" while T
 * becomes "b". Note:
 * 
 * 1 <= S.length <= 200 1 <= T.length <= 200 S and T only contain lowercase
 * letters and '#' characters. Follow up:
 * 
 * Can you solve it in O(N) time and O(1) space?
 * 
 * @author Venkatesh Manohar
 *
 */
public class BackspaceStringCompare {
	public boolean backspaceCompare(String S, String T) {
		if (S == null && T == null) {
			return true;
		}
		if (S == null || T == null) {
			return false;
		}

		Stack<Character> st = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '#') {
				if (!st.isEmpty()) {
					st.pop();
				}
			} else {
				st.push(c);
			}
		}

		StringBuilder sb = new StringBuilder();

		while (!st.isEmpty()) {
			sb.insert(0, st.pop());
		}

		StringBuilder sb2 = new StringBuilder();
		for (int i = 0; i < T.length(); i++) {
			char c = T.charAt(i);
			if (c == '#') {
				if (!st.isEmpty()) {
					st.pop();
				}
			} else {
				st.push(c);
			}
		}
		while (!st.isEmpty()) {
			sb2.insert(0, st.pop());
		}

		return sb.toString().equals(sb2.toString());
	}

	public boolean backspaceCompare2(String S, String T) {
		if (S == null && T == null) {
			return true;
		} else if (S == null || T == null) {
			return false;
		}
		int indexS = S.length() - 1;
		int indexT = T.length() - 1;
		while (indexS != -1 && indexT != -1) {
			indexS = findNext(S, indexS);
			indexT = findNext(T, indexT);
			if (indexS == -1 && indexT == -1) {
				return true;
			} else if (indexS == -1 || indexT == -1 || S.charAt(indexS) != T.charAt(indexT)) {
				return false;
			}
			indexS--;
			indexT--;
		}
		return findNext(S, indexS) == findNext(T, indexT);
	}

	private int findNext(String str, int index) {
		if (index < 0)
			return -1;
		int backSpace = 0;
		for (int i = index; i >= 0; i--) {
			if (str.charAt(i) == '#') {
				backSpace++;
			} else if (backSpace > 0) {
				backSpace--;
			} else {
				return i;
			}
		}
		return -1;
	}
}
