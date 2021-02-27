package com.ven.leetcode.feb2021.challenge;

/**
 * Given a string, you need to reverse the order of characters in each word
 * within a sentence while still preserving whitespace and initial word order.
 * 
 * Example 1: Input: "Let's take LeetCode contest" Output: "s'teL ekat edoCteeL
 * tsetnoc" Note: In the string, each word is separated by single space and
 * there will not be any extra space in the string.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseWordsStringIII {
	public String reverseWords(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		String[] strs = s.split(" ");

		for (int k = 0; k < strs.length; k++) {
			String st = strs[k];
			char[] a = st.toCharArray();
			int i = 0, j = a.length - 1;
			while (i < j) {
				char temp = a[j];
				a[j] = a[i];
				a[i] = temp;
				i++;
				j--;
			}
			strs[k] = new String(a);
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < strs.length; i++) {
			sb.append(strs[i]).append(" ");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	public String reverseWordsOptimized(String s) {
		if (s == null || s.length() == 0) {
			return s;
		}

		char[] a = s.toCharArray();
		int i = 0, j = 0;

		while (j < a.length) {
			while (j < a.length && a[j] != ' ') {
				j++;
			}
			reverse(a, i, j-1);
			i = j+1;
			j++;
		}

		return new String(a);
	}

	private void reverse(char[] a, int i, int j) {
		while (i < j) {
			char temp = a[j];
			a[j] = a[i];
			a[i] = temp;
			i++;
			j--;
		}
	}
}
