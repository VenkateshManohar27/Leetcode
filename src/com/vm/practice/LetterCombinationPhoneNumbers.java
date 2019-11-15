package com.vm.practice;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationPhoneNumbers {
	public List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return combinations;
		}
		String[] mappings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		generate("", digits, mappings, combinations);

		return combinations;
	}

	private void generate(String letters, String digits, String[] mappings, List<String> combinations) {
		if(letters.length() == digits.length()) {
			combinations.add(letters);
			return;
		}
		String value = mappings[digits.charAt(letters.length())-'0'];
		for (int i = 0; i < value.length(); i++) {
			generate(letters+value.charAt(i), digits, mappings, combinations);
		}
		
	}

	public static void main(String[] args) {
		LetterCombinationPhoneNumbers lcpn = new LetterCombinationPhoneNumbers();
		System.out.println(lcpn.letterCombinations("23"));
	}
}
