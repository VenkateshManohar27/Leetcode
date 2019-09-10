package com.ven.amazon;

import java.util.ArrayList;
import java.util.List;

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
public class LetterCombinationPhoneNumbers {

	public static void main(String[] args) {
		LetterCombinationPhoneNumbers lpn = new LetterCombinationPhoneNumbers();
		System.out.println(lpn.letterCombinations("23"));
		
		System.out.println(lpn.letterCombinations("2345"));

	}

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		if(digits == null || digits.length() == 0) {
			return result;
		}
		String[] mappings = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
		generate("", digits,result, mappings);
		
		return result;
	}

	private void generate(String combination, String digits, List<String> result, String[] mappings) {
		if(combination.length() == digits.length()) {
			result.add(combination);
			return;
		}
		String value = mappings[digits.charAt(combination.length()) - '0'];
		for (int i = 0; i < value.length(); i++) {
			generate(combination+value.charAt(i), digits, result, mappings);
		}
		
	}
}
		
