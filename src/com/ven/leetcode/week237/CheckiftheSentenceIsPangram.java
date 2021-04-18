package com.ven.leetcode.week237;

/**
 * A pangram is a sentence where every letter of the English alphabet appears at
 * least once.
 * 
 * Given a string sentence containing only lowercase English letters, return
 * true if sentence is a pangram, or false otherwise.
 * 
 * Example 1:
 * 
 * Input: sentence = "thequickbrownfoxjumpsoverthelazydog" Output: true
 * Explanation: sentence contains at least one of every letter of the English
 * alphabet. Example 2:
 * 
 * Input: sentence = "leetcode" Output: false
 * 
 * Constraints:
 * 
 * 1 <= sentence.length <= 1000 sentence consists of lowercase English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class CheckiftheSentenceIsPangram {
	public boolean checkIfPangram(String s) {
		int[] c = new int[26];

		for (int i = 0; i < s.length(); i++) {
			c[s.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			if (c[i] == 0) {
				return false;
			}
		}

		return true;
	}

	public boolean checkIfPangramOptimized(String s) {
		int[] c = new int[26];

		for (int i = 0, pan = 0; i < s.length(); i++) {
			if (++c[s.charAt(i) - 'a'] == 1 && ++pan == 26) {
				return true;
			}
		}

		return false;
	}
}
