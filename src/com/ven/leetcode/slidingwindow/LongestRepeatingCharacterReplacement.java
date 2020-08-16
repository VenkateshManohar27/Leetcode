package com.ven.leetcode.slidingwindow;

/**
 * Given a string s that consists of only uppercase English letters, you can
 * perform at most k operations on that string.
 * 
 * In one operation, you can choose any character of the string and change it to
 * any other uppercase English character.
 * 
 * Find the length of the longest sub-string containing all repeating letters
 * you can get after performing the above operations.
 * 
 * Note: Both the string's length and k will not exceed 104.
 * 
 * Example 1:
 * 
 * Input: s = "ABAB", k = 2
 * 
 * Output: 4
 * 
 * Explanation: Replace the two 'A's with two 'B's or vice versa.
 * 
 * 
 * Example 2:
 * 
 * Input: s = "AABABBA", k = 1
 * 
 * Output: 4
 * 
 * Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
 * The substring "BBBB" has the longest repeating letters, which is 4.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestRepeatingCharacterReplacement {
	public int characterReplacement(String s, int k) {
		int[] charCounts = new int[26];
		int maxLength = 0;
		int start = 0;
		int maxCount = 0;
		for (int end = 0; end < s.length(); end++) {
			charCounts[s.charAt(end) - 'A']++;
			maxCount = Math.max(maxCount, charCounts[s.charAt(end) - 'A']);

			while (end - start - maxCount + 1 > k) {
				charCounts[s.charAt(start) - 'A']--;
				start++;
			}
			maxLength = Math.max(maxLength, end - start + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
		System.out.println(l.characterReplacement("ABAB", 2));
		System.out.println(l.characterReplacement("AABABBA", 2));
		System.out.println(l.characterReplacement("AABABBAAABAABA", 2));
	}
}
