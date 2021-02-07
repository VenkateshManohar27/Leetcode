package com.ven.leetcode.feb2021.challenge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * You are given a string s and an array of strings words of the same length.
 * Return all starting indices of substring(s) in s that is a concatenation of
 * each word in words exactly once, in any order, and without any intervening
 * characters.
 * 
 * You can return the answer in any order.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: s = "barfoothefoobarman", words = ["foo","bar"] Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar"
 * respectively. The output order does not matter, returning [9,0] is fine too.
 * Example 2:
 * 
 * Input: s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
 * Output: [] Example 3:
 * 
 * Input: s = "barfoofoobarthefoobarman", words = ["bar","foo","the"] Output:
 * [6,9,12]
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 104 s consists of lower-case English letters. 1 <=
 * words.length <= 5000 1 <= words[i].length <= 30 words[i] consists of
 * lower-case English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> l = new ArrayList<Integer>();
		if (s == null || words == null || s.length() == 0 || words.length == 0) {
			return l;
		}

		HashMap<String, Integer> map = new HashMap<>();
		for (String word : words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}
		int len = words[0].length();
		int subStrLen = words.length * len;
		for (int i = 0; i <= s.length() - subStrLen; i++) {
			String sub = s.substring(i, i + subStrLen);
			HashMap<String, Integer> clone = new HashMap<>(map);
			if (isSubStr(clone, sub, len)) {
				l.add(i);
			}
		}
		return l;
	}

	private boolean isSubStr(HashMap<String, Integer> map, String s, int len) {
		while (s.length() >= len) {
			String temp = s.substring(0, len);
			if (map.containsKey(temp) && map.get(temp) > 0) {
				map.put(temp, map.get(temp) - 1);
			} else {
				return false;
			}
			s = s.substring(len);
		}
		return true;
	}

	public static void main(String[] args) {
		SubstringwithConcatenationofAllWords s = new SubstringwithConcatenationofAllWords();
		System.out.println(s.findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));

		System.out
				.println(s.findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "good" }));
	}
}
