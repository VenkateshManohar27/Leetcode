package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

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

	private void generate(String letters, String digits, String[] mappings, List<String> result) {
		if (letters.length() == digits.length()) {
			result.add(letters);
			return;
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
