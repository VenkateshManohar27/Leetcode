package com.ven.leetcode.trie;

import java.util.HashMap;

public class Trie {
	Trie root = null;
	char c;
	HashMap<Character, Trie> childrens = new HashMap<>();
	boolean isEnd = false;
	
	public Trie(char c) {
		this.c = c;
	}
	/** Initialize your data structure here. */
	public Trie() {
		root = new Trie('*');
	}

	/** Inserts a word into the trie. */
	public void insert(String word) {
		if (word == null || word.length() == 0) {
			return;
		}
		Trie curr = this;
		char[] chars = word.toCharArray();
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			if (curr.childrens.containsKey(c)) {
				curr = curr.childrens.get(c);
			} else {
				Trie node = new Trie(c);
				curr.childrens.put(c, node);
				curr = node;
			}
		}
		curr.isEnd = true;
	}

	/** Returns if the word is in the trie. */
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		Trie res = searchLastNode(this, word, 0);
		return (res == null)? false: res.isEnd;
	}

	private Trie searchLastNode(Trie curr, String word, int index) {
		if (index == word.length()) {
			return curr;
		}
		if (curr == null) {
			return null;
		}

		char c = word.charAt(index);
		if (curr.childrens.containsKey(c)) {
			curr = curr.childrens.get(c);
			return searchLastNode(curr, word, index + 1);
		} 

		return null;
	}

	/**
	 * Returns if there is any word in the trie that starts with the given prefix.
	 */
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return false;
		}
		return searchLastNode(this, prefix, 0) != null;
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
