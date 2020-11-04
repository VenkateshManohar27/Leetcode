package com.ven.leetcode.nov.challenge;

/**
 * Given a string s, the power of the string is the maximum length of a
 * non-empty substring that contains only one unique character.
 * 
 * Return the power of the string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "leetcode" Output: 2 Explanation: The substring "ee" is of length
 * 2 with the character 'e' only. Example 2:
 * 
 * Input: s = "abbcccddddeeeeedcba" Output: 5 Explanation: The substring "eeeee"
 * is of length 5 with the character 'e' only. Example 3:
 * 
 * Input: s = "triplepillooooow" Output: 5 Example 4:
 * 
 * Input: s = "hooraaaaaaaaaaay" Output: 11 Example 5:
 * 
 * Input: s = "tourist" Output: 1
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 500 s contains only lowercase English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ConsecutiveCharacters {
	public int maxPower(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		// int[] power = new int[26];

		int max = 0;
		int consecutive = 1;
		for (int i = 0; i < s.length(); i++) {
			if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
				consecutive++;
				// power[s.charAt(i)-'a'] = consecutive;

			} else {
				consecutive = 1;
				// power[s.charAt(i)-'a'] = Math.max(1, power[s.charAt(i)-'a']);
				// max = Math.max(max, consecutive);
			}
			max = Math.max(max, consecutive);
		}
		return max;
	}
}
