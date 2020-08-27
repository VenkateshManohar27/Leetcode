package com.ven.leetcode.augchallenge;

class TrieNode {
	TrieNode[] childrens = new TrieNode[26];
	public boolean isEnd = false;

	public TrieNode() {
		super();
	}
}

public class StreamChecker {
	TrieNode root = new TrieNode();
	TrieNode ptr = root;
	int max;
	StringBuilder sb = new StringBuilder();

	public StreamChecker(String[] words) {
		for (int i = 0; i < words.length; i++) {
			TrieNode curr = root;
			String wd = words[i];
			max = Math.max(max, wd.length());
			for (int j = wd.length() - 1; j >= 0; j--) {
				char c = wd.charAt(j);
				if (curr.childrens[c - 'a'] == null) {
					curr.childrens[c - 'a'] = new TrieNode();
				}
				curr = curr.childrens[c - 'a'];
			}
			curr.isEnd = true;
		}
	}

	public boolean query(char letter) {
		sb.append(letter);
		int l = sb.length();
		TrieNode curr = root;
		for (int i = 0; i < Math.min(l, max); i++) {
			char c = sb.charAt(l - i - 1);
			curr = curr.childrens[c - 'a'];
			if (curr == null)
				return false;
			if (curr.isEnd)
				return true;
		}
		return false;
	}

	public static void main(String[] args) {
		StreamChecker streamChecker = new StreamChecker(new String[] { "cd", "f", "kl" }); // init the dictionary.
		System.out.println(streamChecker.query('a')); // return false
		System.out.println(streamChecker.query('b')); // return false
		System.out.println(streamChecker.query('c')); // return false
		System.out.println(streamChecker.query('d')); // return true, because 'cd' is in the wordlist
		System.out.println(streamChecker.query('e')); // return false
		System.out.println(streamChecker.query('f')); // return true, because 'f' is in the wordlist
		System.out.println(streamChecker.query('g')); // return false
		System.out.println(streamChecker.query('h')); // return false
		System.out.println(streamChecker.query('i')); // return false
		System.out.println(streamChecker.query('j')); // return false
		System.out.println(streamChecker.query('k')); // return false
		System.out.println(streamChecker.query('l')); // return true, because 'kl' is in the wordlist

		System.out.println("***************************************************************************");

		streamChecker = new StreamChecker(new String[] { "ab", "ba", "aaab", "abab", "baa" });

		String[] queries = new String[] { "a", "a", "a", "a", "a", "b", "a", "b", "a", "b", "b", "b", "a", "b", "a",
				"b", "b", "b", "b", "a", "b", "a", "b", "a", "a", "a", "b", "a", "a", "a" };
		boolean[] bools = new boolean[] { false, false, false, false, false, true, true, true, true, true, false, false,
				true, true, true, true, false, false, false, true, true, true, true, true, true, false, true, true,
				true, false };
		for (int i = 0; i < queries.length; i++) {
			// System.out.println(streamChecker.query(queries[i].charAt(0)));
			System.out.println(i + ": " + (bools[i] == streamChecker.query(queries[i].charAt(0))));
		}
	}
}
