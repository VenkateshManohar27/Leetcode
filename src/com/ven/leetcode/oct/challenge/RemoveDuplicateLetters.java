package com.ven.leetcode.oct.challenge;

/**
 * Given a string s, remove duplicate letters so that every letter appears once
 * and only once. You must make sure your result is the smallest in
 * lexicographical order among all possible results.
 * 
 * Note: This question is the same as 1081:
 * https://leetcode.com/problems/smallest-subsequence-of-distinct-characters/
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "bcabc" Output: "abc" Example 2:
 * 
 * Input: s = "cbacdcbc" Output: "acdb"
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s consists of lowercase English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RemoveDuplicateLetters {
	public String removeDuplicateLetters(String s) {
		int[] count = new int[26];
		for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
		StringBuilder sb = new StringBuilder();
		boolean[] visited = new boolean[26];
		for (char c : s.toCharArray()) {
			count[c - 'a']--;
			if (visited[c - 'a']) {
				continue;
			}
			while (sb.length() > 0 && c <= sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
				visited[sb.charAt(sb.length() - 1) - 'a'] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
			visited[c - 'a'] = true;
			sb.append(c);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		RemoveDuplicateLetters r = new RemoveDuplicateLetters();
		System.out.println(r.removeDuplicateLetters("bcabc"));
		System.out.println(r.removeDuplicateLetters("cbacdcbc"));
	}
}
