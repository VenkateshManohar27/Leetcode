package com.ven.google;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * Input: "23" Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * 
 * Although the above answer is in lexicographical order, your answer could be
 * in any order you want.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LetterCombinationPhoneNumber {

	private List<String> letterCombinations(String digits) {
		List<String> combinations = new ArrayList<String>();
		if (digits == null || digits.length() == 0) {
			return combinations;
		}
		String[] mappings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		generate("", digits, mappings, combinations);
		return combinations;
	}

	private void generate(String combination, String digits, String[] mappings, List<String> combinations) {
		if (combination.length() == digits.length()) {
			combinations.add(combination);
			return;
		}
		String mapping = mappings[digits.charAt(combination.length()) - '0'];
		for (int i = 0; i < mapping.length(); i++) {
			generate(combination + mapping.charAt(i), digits, mappings, combinations);
		}

	}

	public static void main(String[] args) {
		LetterCombinationPhoneNumber lpn = new LetterCombinationPhoneNumber();
		System.out.println(lpn.letterCombinations("23"));
		System.out.println(lpn.letterCombinations("2345"));
	}
}
