package com.ven.leetcode.week238;

/**
 * A string is considered beautiful if it satisfies the following conditions:
 * 
 * Each of the 5 English vowels ('a', 'e', 'i', 'o', 'u') must appear at least
 * once in it. The letters must be sorted in alphabetical order (i.e. all 'a's
 * before 'e's, all 'e's before 'i's, etc.). For example, strings "aeiou" and
 * "aaaaaaeiiiioou" are considered beautiful, but "uaeio", "aeoiu", and
 * "aaaeeeooo" are not beautiful.
 * 
 * Given a string word consisting of English vowels, return the length of the
 * longest beautiful substring of word. If no such substring exists, return 0.
 * 
 * A substring is a contiguous sequence of characters in a string.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu" Output: 13 Explanation: The
 * longest beautiful substring in word is "aaaaeiiiiouuu" of length 13. Example
 * 2:
 * 
 * Input: word = "aeeeiiiioooauuuaeiou" Output: 5 Explanation: The longest
 * beautiful substring in word is "aeiou" of length 5. Example 3:
 * 
 * Input: word = "a" Output: 0 Explanation: There is no beautiful substring, so
 * return 0.
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length <= 5 * 105 word consists of characters 'a', 'e', 'i', 'o',
 * and 'u'.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestSubstringOfAllVowelsOrder {
	public int longestBeautifulSubstring(String word) {
		int max = 0;
		int start = 0;
		int end = 0;
		int len = 0;
		boolean a = false, e = false, i = false, o = false, u = false;
		while (start <= end && end < word.length()) {
			while (end < word.length() && word.charAt(end) != 'a') {
				start++;
				end++;
			}
			while (end < word.length() && word.charAt(end) == 'a') {
				end++;
				len++;
				a = true;
			}
			while (a && end < word.length() && word.charAt(end) == 'e') {
				end++;
				len++;
				e = true;
			}
			while (a && e && end < word.length() && word.charAt(end) == 'i') {
				end++;
				len++;
				i = true;
			}
			while (a && e && i && end < word.length() && word.charAt(end) == 'o') {
				end++;
				len++;
				o = true;
			}
			while (a && e && i && o && end < word.length() && word.charAt(end) == 'u') {
				end++;
				len++;
				u = true;
			}
			start = end;
			if (a && e && i && o && u)
				max = Math.max(max, len);
			len = 0;
			a = false;
			e = false;
			i = false;
			o = false;
			u = false;
		}

		return max;
	}

	public int longestBeautifulSubstringOp(String word) {
		if (word.length() < 5)
			return 0;
		char[] ch = word.toCharArray();
		int len = 0;
		for (int i = 1; i < ch.length; i++) {
			if (ch[i - 1] == 'a') {
				int val = 1;
				while (i < word.length()
						&& (((ch[i] - 'a') - (ch[i - 1] - 'a')) <= 6 && ((ch[i] - 'a') - (ch[i - 1] - 'a')) >= 0)) {
					val++;
					i++;
				}
				if (ch[i - 1] == 'u')
					len = Math.max(len, val);
			}
		}
		return len;
	}
}
