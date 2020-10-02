package com.ven.leetcode.sepchallenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:
 * 
 * Input: s = "leetcode", wordDict = ["leet", "code"] Output: true Explanation:
 * Return true because "leetcode" can be segmented as "leet code". Example 2:
 * 
 * Input: s = "applepenapple", wordDict = ["apple", "pen"] Output: true
 * Explanation: Return true because "applepenapple" can be segmented as "apple
 * pen apple". Note that you are allowed to reuse a dictionary word. Example 3:
 * 
 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * Output: false
 * 
 * @author Venkatesh Manohar
 *
 */
public class WordBreak {

	// This does not work as it tries to match the first substr which is in dict and
	// does not continue to find others and rather starts with the next character
	public boolean wordBreak2(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>();
		for (String st : wordDict) {
			dict.add(st);
		}
		int start = 0;
		int end = 0;
		while (end <= s.length()) {
			String substr = s.substring(start, end);
			if (dict.contains(substr)) {
				start = end;
			}
			end++;
		}
		return start + 1 == end;
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null || s.length() == 0)
			return false;

		int n = s.length();

		// dp[i] represents whether s[0...i] can be formed by dict
		boolean[] dp = new boolean[n];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				String sub = s.substring(j, i + 1);

				if (wordDict.contains(sub) && (j == 0 || dp[j - 1])) {
					dp[i] = true;
					break;
				}
			}
		}

		return dp[n - 1];
	}

	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		System.out.println(w.wordBreak("leetcode", Arrays.asList(new String[] { "leet", "code" })));
		System.out.println(w.wordBreak("applepenapple", Arrays.asList(new String[] { "apple", "pen" })));
		System.out
				.println(w.wordBreak("catsandog", Arrays.asList(new String[] { "cats", "dog", "sand", "and", "cat" })));

		System.out.println(w.wordBreak("aaaaaaa", Arrays.asList(new String[] { "aaaa", "aaa" })));
		System.out.println(w.wordBreak2("leetcode", Arrays.asList(new String[] { "leet", "code" })));
		System.out.println(w.wordBreak2("applepenapple", Arrays.asList(new String[] { "apple", "pen" })));
		System.out.println(
				w.wordBreak2("catsandog", Arrays.asList(new String[] { "cats", "dog", "sand", "and", "cat" })));
	}
}
