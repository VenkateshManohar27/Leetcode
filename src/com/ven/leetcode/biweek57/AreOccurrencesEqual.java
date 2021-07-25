package com.ven.leetcode.biweek57;

/**
 * Check if All Characters Have Equal Number of Occurrences Easy
 * 
 * 
 * Add to List
 * 
 * Share Given a string s, return true if s is a good string, or false
 * otherwise.
 * 
 * A string s is good if all the characters that appear in s have the same
 * number of occurrences (i.e., the same frequency).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abacbc" Output: true Explanation: The characters that appear in s
 * are 'a', 'b', and 'c'. All characters occur 2 times in s. Example 2:
 * 
 * Input: s = "aaabb" Output: false Explanation: The characters that appear in s
 * are 'a' and 'b'. 'a' occurs 3 times while 'b' occurs 2 times, which is not
 * the same number of times.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 1000 s consists of lowercase English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class AreOccurrencesEqual {
	public boolean areOccurrencesEqual(String s) {
		int[] freq = new int[26];

		for (int i = 0; i < s.length(); i++) {
			freq[s.charAt(i) - 'a']++;
		}
		int count = 0;
		for (int i = 0; i < 26; i++) {
			if (freq[i] != 0) {
				if (count == 0) {
					count = freq[i];
				} else {
					if (count != freq[i]) {
						return false;
					}
				}
			}
		}

		return true;
	}
}
