package com.ven.leetcode.apr2021.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in any
 * order.
 * 
 * A mapping of digit to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * Example 1:
 * 
 * Input: digits = "23" Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * Example 2:
 * 
 * Input: digits = "" Output: [] Example 3:
 * 
 * Input: digits = "2" Output: ["a","b","c"]
 * 
 * 
 * Constraints:
 * 
 * 0 <= digits.length <= 4 digits[i] is a digit in the range ['2', '9'].
 * 
 * @author Venkatesh Manohar
 *
 */
public class LetterCombinationsofPhoneNumber {
	String[] map = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

	public List<String> letterCombinations(String digits) {

		List<String> li = new ArrayList<>();
		if (digits == null || digits.equals(""))
			return li;
		helper(digits, new StringBuilder(), 0, li);
		return li;
	}

	private void helper(String digits, StringBuilder s, int ind, List<String> li) {
		if (digits.length() == ind) {
			li.add(s.toString());
			return;
		}
		String mapStr = map[digits.charAt(ind) - '0'];

		for (int i = 0; i < mapStr.length(); i++) {
			s.append(mapStr.charAt(i));
			helper(digits, s, ind + 1, li);
			s.deleteCharAt(s.length() - 1);
		}

	}
}
