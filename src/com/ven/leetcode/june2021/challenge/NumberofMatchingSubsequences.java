package com.ven.leetcode.june2021.challenge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.swing.text.StyledEditorKit.ForegroundAction;

/**
 * Given a string s and an array of strings words, return the number of words[i]
 * that is a subsequence of s.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * 
 * 
 * Example 1:
 * 
 * Input: s = "abcde", words = ["a","bb","acd","ace"] Output: 3 Explanation:
 * There are three strings in words that are a subsequence of s: "a", "acd",
 * "ace". Example 2:
 * 
 * Input: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 1 <= s.length <= 5 * 104 1 <= words.length <= 5000 1 <= words[i].length <= 50
 * s and words[i] consist of only lowercase English letters.
 * 
 * @author Venkatesh Manohar
 *
 */
public class NumberofMatchingSubsequences {

	public int numMatchingSubseq(String s, String[] words) {
		int count = 0;
		List<Integer>[] al = new ArrayList[26];
		for (int i = 0; i < s.length(); i++) {
			int chIndex = s.charAt(i) - 'a';
			if (al[chIndex] == null) {
				al[chIndex] = new ArrayList<>();
			}
			al[chIndex].add(i);
		}
		for (String word : words) {
			int curr = 0;
			for (int i = 0; i < word.length(); i++, curr++) {
				int ch = word.charAt(i) - 'a';
				curr = binSearch(al[ch], curr);
				if (curr == -1)
					break;
			}
			if (curr != -1)
				count++;
		}

		return count;
	}

	private int binSearch(List<Integer> l, int curr) {
		if (l == null)
			return -1;
		int low = 0, high = l.size() - 1;
		if (l.get(low) >= curr)
			return l.get(low);
		if (l.get(high) < curr)
			return -1;
		while (low < high) {
			int mid = (low + high) / 2;
			if (l.get(mid) == curr)
				return l.get(mid);
			if (l.get(mid) < curr)
				low = mid + 1;
			else
				high = mid;
		}

		return l.get(high);
	}

	public static void main(String[] args) {
		NumberofMatchingSubsequences n = new NumberofMatchingSubsequences();
		System.out.println(
				n.numMatchingSubseq("dsahjpjauf", new String[] { "ahjpjau", "ja", "ahbwzgqnuk", "tnmlanowax" }));
		System.out.println(n.numMatchingSubseq("abcde", new String[] { "a", "bb", "acd", "ace" }));

	}
}
