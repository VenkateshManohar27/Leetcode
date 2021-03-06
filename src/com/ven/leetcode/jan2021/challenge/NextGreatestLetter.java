package com.ven.leetcode.jan2021.challenge;

/**
 * Given a list of sorted characters letters containing only lowercase letters,
 * and given a target letter target, find the smallest element in the list that
 * is larger than the given target.
 * 
 * Letters also wrap around. For example, if the target is target = 'z' and
 * letters = ['a', 'b'], the answer is 'a'.
 * 
 * Examples: Input: letters = ["c", "f", "j"] target = "a" Output: "c"
 * 
 * Input: letters = ["c", "f", "j"] target = "c" Output: "f"
 * 
 * Input: letters = ["c", "f", "j"] target = "d" Output: "f"
 * 
 * Input: letters = ["c", "f", "j"] target = "g" Output: "j"
 * 
 * Input: letters = ["c", "f", "j"] target = "j" Output: "c"
 * 
 * Input: letters = ["c", "f", "j"] target = "k" Output: "c" Note: letters has a
 * length in range [2, 10000]. letters consists of lowercase letters, and
 * contains at least 2 unique letters. target is a lowercase letter.
 * 
 * @author Venkatesh Manohar
 *
 */
public class NextGreatestLetter {
	public char nextGreatestLetter(char[] letters, char target) {
		int[] ch = new int[26];
		for (int i = 0; i < letters.length; i++) {
			ch[letters[i] - 'a']++;
		}

		int j = target - 'a';
		// System.out.println("j"+j);
		int k = (j + 1) % ch.length;
		char res = '\0';
		while (k != j) {
			if (ch[k] > 0) {
				res = (char) (k + 'a');
				break;
			}
			k++;
			k = k % ch.length;
		}

		return res;

	}
}
