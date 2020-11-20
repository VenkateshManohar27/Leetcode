package com.ven.leetcode.week3;

/**
 * Find the length of the longest substring T of a given string (consists of
 * lowercase letters only) such that every character in T appears no less than k
 * times.
 * 
 * Example 1:
 * 
 * Input: s = "aaabb", k = 3
 * 
 * Output: 3
 * 
 * The longest substring is "aaa", as 'a' is repeated 3 times. Example 2:
 * 
 * Input: s = "ababbc", k = 2
 * 
 * Output: 5
 * 
 * The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is
 * repeated 3 times.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestSubstringAtLeastKRepeatingCharacters {
	//Optimized
	public int longestSubstring2(String s, int k) {
		if (s == null || s.length() == 0)
			return 0;
		int length = s.length();
		int start = 0;
		int end = 0;
		boolean IslongestSubstring = true;
		int[] chars = new int[26];
		for (char current : s.toCharArray()) {
			chars[current - 'a'] = chars[current - 'a'] + 1;
		}
		for (char current : s.toCharArray()) {
			int currentCount = chars[current - 'a'];
			if (currentCount < k && currentCount > 0) {
				IslongestSubstring = false;
				break;
			}
		}

		// then the logngest substring will be the string
		if (IslongestSubstring) {
			return length;
		}
		int result = Integer.MIN_VALUE;
		while (end < length) {
			if (chars[s.charAt(end) - 'a'] < k) {
				// compare the result with the longest substring from start to end substring
				result = Math.max(result, longestSubstring(s.substring(start, end), k));
				// rest the start to end +1 after the longest substring from start to end
				start = end + 1;
			}

			end++;
		}
		// find the longest substring from the start+1 and end
		result = Math.max(result, longestSubstring(s.substring(start), k));
		return result;
	}

	public int longestSubstring(String s, int k) {
		if (k > s.length()) {
			return 0;
		}
		if (k == 0 || k == 1) {
			return s.length();
		}
		return longestSubstring(s, k, 0, s.length() - 1);
	}

	private int longestSubstring(String s, int k, int start, int end) {
		if (start > end) {
			return 0;
		}
		if (end - start + 1 < k) {
			return 0;
		}
		int[] charCount = new int[26];
		for (int i = start; i <= end; i++) {
			charCount[s.charAt(i) - 'a']++;
		}

		int maxLength = 0;
		int length = 0;
		for (int i = start; i <= end; i++) {
			char c = s.charAt(i);
			int count = charCount[c - 'a'];
			if (count < k) {
				length = 0;
				if (i > start) {
					length = Math.max(length, longestSubstring(s, k, start, i - 1));
				}
				length = Math.max(length, longestSubstring(s, k, i + 1, end));
				break;
			} else {
				length++;
			}
		}
		maxLength = Math.max(length, maxLength);
		return maxLength;
	}

	public static void main(String[] args) {
		LongestSubstringAtLeastKRepeatingCharacters l = new LongestSubstringAtLeastKRepeatingCharacters();
		System.out.println(l.longestSubstring2("bbaaacbd", 3));
		System.out.println(l.longestSubstring2("ababbc", 2));
		System.out.println(l.longestSubstring2("aaabb", 3));
		System.out.println(l.longestSubstring2("abaacdcddbeee", 3));

		System.out.println(l.longestSubstring2("bbaaaccccbd", 3));

		System.out.println(l.longestSubstring2("bbaaaccccbd", 1));

	}
}
