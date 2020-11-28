package com.ven.leetcode.nov.challenge;

/**
 * Given a string s and an integer k, return the length of the longest substring
 * of s such that the frequency of each character in this substring is greater
 * than or equal to k.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "aaabb", k = 3 Output: 3 Explanation: The longest substring is
 * "aaa", as 'a' is repeated 3 times. Example 2:
 * 
 * Input: s = "ababbc", k = 2 Output: 5 Explanation: The longest substring is
 * "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s consists of only lowercase English letters. 1 <= k <=
 * 105
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public int longestSubstring(String s, int k) {
		return helper(s, 0, s.length() - 1, k);
	}

	private int helper(String s, int start, int end, int k) {
		int[] count = new int[26];
		for (int i = start; i <= end; i++) {
			count[s.charAt(i) - 'a']++;
		}
		boolean hasChar = false;
		for (int i = 0; i < 26; i++) {
			if (count[i] >= k) {
				hasChar = true;
			}
		}
		if (!hasChar) {
			return 0;
		}

		int max = 0;
		int index = -1;
		for (int i = start; i <= end; i++) {
			if (count[s.charAt(i) - 'a'] < k) {
				index = i;
			}
		}
		if (index >= 0) {
			max = Math.max(helper(s, start, index - 1, k), helper(s, index + 1, end, k));
		} else {
			max = end - start + 1;
		}

		return max;
	}
}
