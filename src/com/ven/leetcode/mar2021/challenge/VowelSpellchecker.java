package com.ven.leetcode.mar2021.challenge;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a wordlist, we want to implement a spellchecker that converts a query
 * word into a correct word.
 * 
 * For a given query word, the spell checker handles two categories of spelling
 * mistakes:
 * 
 * Capitalization: If the query matches a word in the wordlist
 * (case-insensitive), then the query word is returned with the same case as the
 * case in the wordlist. Example: wordlist = ["yellow"], query = "YellOw":
 * correct = "yellow" Example: wordlist = ["Yellow"], query = "yellow": correct
 * = "Yellow" Example: wordlist = ["yellow"], query = "yellow": correct =
 * "yellow" Vowel Errors: If after replacing the vowels ('a', 'e', 'i', 'o',
 * 'u') of the query word with any vowel individually, it matches a word in the
 * wordlist (case-insensitive), then the query word is returned with the same
 * case as the match in the wordlist. Example: wordlist = ["YellOw"], query =
 * "yollow": correct = "YellOw" Example: wordlist = ["YellOw"], query =
 * "yeellow": correct = "" (no match) Example: wordlist = ["YellOw"], query =
 * "yllw": correct = "" (no match) In addition, the spell checker operates under
 * the following precedence rules:
 * 
 * When the query exactly matches a word in the wordlist (case-sensitive), you
 * should return the same word back. When the query matches a word up to
 * capitlization, you should return the first such match in the wordlist. When
 * the query matches a word up to vowel errors, you should return the first such
 * match in the wordlist. If the query has no matches in the wordlist, you
 * should return the empty string. Given some queries, return a list of words
 * answer, where answer[i] is the correct word for query = queries[i].
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: wordlist = ["KiTe","kite","hare","Hare"], queries =
 * ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
 * Output: ["kite","KiTe","KiTe","Hare","hare","","","KiTe","","KiTe"] Example
 * 2:
 * 
 * Input: wordlist = ["yellow"], queries = ["YellOw"] Output: ["yellow"]
 * 
 * 
 * Constraints:
 * 
 * 1 <= wordlist.length, queries.length <= 5000 1 <= wordlist[i].length,
 * queries[i].length <= 7 wordlist[i] and queries[i] consist only of only
 * English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class VowelSpellchecker {
	Set<String> perfect = null;
	HashMap<String, String> mapLo = null;
	HashMap<String, String> mapDV = null;

	public String[] spellchecker(String[] wordlist, String[] queries) {
		perfect = new HashSet<>();
		mapLo = new HashMap<>();
		mapDV = new HashMap<>();
		for (int i = 0; i < wordlist.length; i++) {
			String s = wordlist[i];
			perfect.add(s);

			String sLo = s.toLowerCase();
			mapLo.putIfAbsent(sLo, s);

			String sDv = devowel(sLo);
			mapDV.putIfAbsent(sDv, s);
		}

		String[] ans = new String[queries.length];
		int t = 0;
		for (String q : queries) {
			ans[t++] = solve(q);
		}

		return ans;
	}

	public String solve(String query) {
		// System.out.print(perfect);
		if (perfect.contains(query))
			return query;

		String queryL = query.toLowerCase();
		if (mapLo.containsKey(queryL))
			return mapLo.get(queryL);

		String queryLV = devowel(queryL);
		if (mapDV.containsKey(queryLV))
			return mapDV.get(queryLV);

		return "";
	}

	private String devowel(String s) {
		StringBuilder sb = new StringBuilder();
		for (char c : s.toCharArray()) {
			sb.append(isVowel(c) ? '*' : c);
		}
		return sb.toString();
	}

	private boolean isVowel(char c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
}
