package com.ven.leetcode.medium;

import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 * 
 * Input: "abcabcbb" Output: 3 Explanation: The answer is "abc", with the length
 * of 3. Example 2:
 * 
 * Input: "bbbbb" Output: 1 Explanation: The answer is "b", with the length of
 * 1. Example 3:
 * 
 * Input: "pwwkew" Output: 3 Explanation: The answer is "wke", with the length
 * of 3. Note that the answer must be a substring, "pwke" is a subsequence and
 * not a substring.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int length = 0, i = 0, j = 0;
		HashSet<Character> chars = new HashSet<>();
		while (i < s.length()) {
			char c = s.charAt(i);
			if (chars.contains(c)) {
				chars.remove(s.charAt(j++));
			} else {
				chars.add(c);
				i++;
				length = Math.max(length, chars.size());
			}

		}

		return length;
	}
}
