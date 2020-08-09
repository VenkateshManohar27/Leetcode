package com.ven.leetcode.augchallenge;

public class Trie {
	Trie root = null;
	char c;
	Trie[] childrens = new Trie[27];
	boolean isEnd = false;
	
	public Trie(char c) {
		this.c = c;
	}
	/** Initialize your data structure here. */
	public Trie() {
		root = new Trie('*');
	}
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
