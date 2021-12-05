package com.ven.leetcode.oct2021.challenge;

/**
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to
 * efficiently store and retrieve keys in a dataset of strings. There are
 * various applications of this data structure, such as autocomplete and
 * spellchecker.
 * 
 * Implement the Trie class:
 * 
 * Trie() Initializes the trie object. void insert(String word) Inserts the
 * string word into the trie. boolean search(String word) Returns true if the
 * string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously
 * inserted string word that has the prefix prefix, and false otherwise.
 * 
 * 
 * Example 1:
 * 
 * Input ["Trie", "insert", "search", "search", "startsWith", "insert",
 * "search"] [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output [null, null, true, false, true, null, true]
 * 
 * Explanation Trie trie = new Trie(); trie.insert("apple");
 * trie.search("apple"); // return True trie.search("app"); // return False
 * trie.startsWith("app"); // return True trie.insert("app");
 * trie.search("app"); // return True
 * 
 * 
 * Constraints:
 * 
 * 1 <= word.length, prefix.length <= 2000 word and prefix consist only of
 * lowercase English letters. At most 3 * 104 calls in total will be made to
 * insert, search, and startsWith.
 * 
 * @author Venkatesh Manohar
 *
 */
class Node {
	Node[] children = new Node[26];
	boolean end = false;
}

public class PrefixTree {
	Node root = null;

	public PrefixTree() {
		root = new Node();
	}

	public void insert(String word) {
		Node node = root;

		for (int i = 0; i < word.length(); i++) {
			int ch = word.charAt(i) - 'a';
			if (node.children[ch] == null) {
				node.children[ch] = new Node();
			}
			node = node.children[ch];

		}
		node.end = true;

	}

	public boolean search(String word) {
		Node n = search(word, root);
		return (n != null && n.end);
	}

	private Node search(String word, Node node) {
		for (int i = 0; i < word.length(); i++) {
			int ch = word.charAt(i) - 'a';
			if (node.children[ch] == null) {
				return null;
			}
			node = node.children[ch];

		}
		return node;
	}

	// private boolean startswith(String word, Node node, int i){
	// int ch = word.charAt(i) - 'a';
	// if(node.children[ch] == null)
	// return false;
	// node = node.children[ch];
	// if(word.length()-1 == i){
	// return true;
	// }
	// return startswith(word, node, i+1);
	// }
	public boolean startsWith(String prefix) {
		Node n = search(prefix, root);
		return n != null;
	}
}