package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LetterCombinationOfPhoneNumbers {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if (digits == null || digits.length() == 0) {
			return result;
		}
		String[] mappings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		// generate(digits, mappings, result);
		generate("", digits, mappings, result);
		return result;
	}

	private void generate(String digits, String[] mappings, List<String> result) {
		Queue<String> q = new LinkedList<String>();
		q.add("");

		while (!q.isEmpty()) {
			String s = q.remove();
			if (s.length() == digits.length()) {
				result.add(s);
			} else {
				String value = mappings[digits.charAt(s.length()) - '0'];
				for (int i = 0; i < value.length(); i++) {
					q.add(s + value.charAt(i));
				}
			}
		}
	}

	private void generate(String letters, String digits, String[] mappings, List<String> result) {
		if (letters.length() == digits.length()) {
			result.add(letters);
		} else {
			String value = mappings[digits.charAt(letters.length()) - '0'];
			for (int i = 0; i < value.length(); i++) {
				generate(letters + value.charAt(i), digits, mappings, result);
			}
		}
	}

	public static void main(String[] args) {
		LetterCombinationOfPhoneNumbers lpn = new LetterCombinationOfPhoneNumbers();
		System.out.println(lpn.letterCombinations("23"));

	}
}
