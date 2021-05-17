package com.ven.leetcode.may2021.challenge;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given a list of words, each word consists of English lowercase letters.
 * 
 * Let's say word1 is a predecessor of word2 if and only if we can add exactly
 * one letter anywhere in word1 to make it equal to word2. For example, "abc" is
 * a predecessor of "abac".
 * 
 * A word chain is a sequence of words [word_1, word_2, ..., word_k] with k >=
 * 1, where word_1 is a predecessor of word_2, word_2 is a predecessor of
 * word_3, and so on.
 * 
 * Return the longest possible length of a word chain with words chosen from the
 * given list of words.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: words = ["a","b","ba","bca","bda","bdca"] Output: 4 Explanation: One
 * of the longest word chain is "a","ba","bda","bdca". Example 2:
 * 
 * Input: words = ["xbc","pcxbcf","xb","cxbc","pcxbc"] Output: 5
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 1000 1 <= words[i].length <= 16 words[i] only consists
 * of English lowercase letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestStringChain {
	public int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> b.length() - a.length());
		// System.out.println(Arrays.toString(words));
		HashMap<String, Integer> s = new HashMap<>();
		HashMap<String, Integer> memo = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			s.put(words[i], i);
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < words.length; i++) {
			max = Math.max(max, helper(words[i], words, s, memo, 1));
		}
		return max;
	}

	private int helper(String w, String[] words, HashMap<String, Integer> s, HashMap<String, Integer> memo, int l) {
		if (memo.containsKey(w)) {
			return memo.get(w);
		}

		int maxlen = l;

		for (int j = 0; j < w.length(); j++) {
			String sub = w.substring(0, j) + w.substring(j + 1);
			if (s.containsKey(sub)) {
				maxlen = Math.max(maxlen, helper(sub, words, s, memo, l + 1));
			}

		}
		memo.put(w, maxlen);
		return maxlen;
	}
}
