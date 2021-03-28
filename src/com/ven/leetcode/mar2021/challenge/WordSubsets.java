package com.ven.leetcode.mar2021.challenge;

import java.util.ArrayList;
import java.util.List;

public class WordSubsets {
	public List<String> wordSubsets(String[] A, String[] B) {
		int[] bmax = new int[26];

		for (int i = 0; i < B.length; i++) {
			int[] chrs = new int[26];
			for (char c : B[i].toCharArray()) {
				chrs[c - 'a']++;
			}
			for (int j = 0; j < 26; ++j)
				bmax[j] = Math.max(bmax[j], chrs[j]);
		}

		List<String> l = new ArrayList<>();
		for (int i = 0; i < A.length; i++) {
			String s = A[i];
			int[] ch = new int[26];
			for (char c : s.toCharArray()) {
				ch[c - 'a']++;
			}
			boolean res = true;

			for (int j = 0; j < 26; j++) {
				if (ch[j] < bmax[j]) {
					res = false;
					break;
				}
			}
			
			if (res)
				l.add(s);
		}
		return l;
	}

	public static void main(String[] args) {
		WordSubsets w = new WordSubsets();
		w.wordSubsets(new String[] { "amazon", "apple", "facebook", "google", "leetcode" }, new String[] { "e", "o" });

	}
}
