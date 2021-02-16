package com.ven.leetcode.feb2021.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string S, we can transform every letter individually to be lowercase
 * or uppercase to create another string.
 * 
 * Return a list of all possible strings we could create. You can return the
 * output in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: S = "a1b2" Output: ["a1b2","a1B2","A1b2","A1B2"] Example 2:
 * 
 * Input: S = "3z4" Output: ["3z4","3Z4"] Example 3:
 * 
 * Input: S = "12345" Output: ["12345"] Example 4:
 * 
 * Input: S = "0" Output: ["0"]
 * 
 * 
 * Constraints:
 * 
 * S will be a string with length between 1 and 12. S will consist only of
 * letters or digits.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LetterCasePermutation {
	public List<String> letterCasePermutation(String S) {
		List<String> l = new ArrayList<>();

		helper(0, l, S.toCharArray());

		return l;
	}

	private void helper(int index, List<String> l, char[] chrs) {
		if (index == chrs.length) {
			l.add(new String(chrs));
			return;
		}
		char c = chrs[index];
		if (Character.isAlphabetic(c)) {
			chrs[index] = Character.toLowerCase(c);
			helper(index + 1, l, chrs);
			chrs[index] = Character.toUpperCase(c);
			helper(index + 1, l, chrs);
		} else {
			helper(index + 1, l, chrs);
		}

	}
}
