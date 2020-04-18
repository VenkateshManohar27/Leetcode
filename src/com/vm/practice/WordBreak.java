package com.vm.practice;

import java.util.ArrayList;
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
	public boolean wordBreak(String s, List<String> wordDict) {
		if (s == null) {
			return false;
		}

		Set<String> set = new HashSet<String>();
		for (String s1 : wordDict) {
			set.add(s1);
		}
		String wordbreak = wordBreak(s.toCharArray(), 0, set);
		return wordbreak != null && wordbreak.equals(s);
	}

	private String wordBreak(char[] s, int low, Set<String> set) {
		StringBuilder sb = new StringBuilder();
		for (int j = low; j < s.length; j++) {
			sb.append(s[j]);
			if (set.contains(sb.toString())) {
				String result = wordBreak(s, j + 1, set);
				if (result != null) {
					return sb.toString() + result;
				}
			}

		}
		if (set.contains(sb.toString())) {
			return sb.toString();
		}
		return null;
	}

	public boolean wordBreakDP(String s, List<String> wordDict) {
		boolean[] T = new boolean[s.length() + 1];
		Set<String> set = new HashSet<>();
		for (String word : wordDict) {
			set.add(word);
		}
		T[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (T[j] && set.contains(s.substring(j, i))) {
					T[i] = true;
					break;
				}
			}
		}
		return T[s.length()];
	}

	public static void main(String[] args) {
		WordBreak w = new WordBreak();
		List<String> li = new ArrayList<String>();
		li.add("leet");
		li.add("code");
		System.out.println(w.wordBreak("leetcode", li));
		System.out.println(w.wordBreakDP("leetcode", li));
		li.clear();
		li.add("apple");
		li.add("pen");
		System.out.println(w.wordBreak("applepenapple", li));
		System.out.println(w.wordBreakDP("applepenapple", li));
		// "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
		li.clear();
		li.add("cats");
		li.add("dog");
		li.add("sand");
		li.add("and");
		li.add("cat");
		System.out.println(w.wordBreak("catsandog", li));

		li.clear();
		li.add("aaaa");
		li.add("aaa");
		System.out.println(w.wordBreak("aaaaaaa", li));

	}
}
