package com.ven.leetcode.may2021.challenge;

import java.util.HashSet;
import java.util.Set;

/**
 * Design a special dictionary which has some words and allows you to search the
 * words in it by a prefix and a suffix.
 * 
 * Implement the WordFilter class:
 * 
 * WordFilter(string[] words) Initializes the object with the words in the
 * dictionary. f(string prefix, string suffix) Returns the index of the word in
 * the dictionary which has the prefix prefix and the suffix suffix. If there is
 * more than one valid index, return the largest of them. If there is no such
 * word in the dictionary, return -1.
 * 
 * 
 * Example 1:
 * 
 * Input ["WordFilter", "f"] [[["apple"]], ["a", "e"]] Output [null, 0]
 * 
 * Explanation WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // return 0, because the word at index 0 has prefix =
 * "a" and suffix = 'e".
 * 
 * 
 * Constraints:
 * 
 * 1 <= words.length <= 15000 1 <= words[i].length <= 10 1 <= prefix.length,
 * suffix.length <= 10 words[i], prefix and suffix consist of lower-case English
 * letters only. At most 15000 calls will be made to the function f.
 * 
 * @author Venkatesh Manohar
 *
 */
public class WordFilter {
	TrieNode root = null;

	public WordFilter(String[] words) {
		root = new TrieNode();
		for (int weight = 0; weight < words.length; weight++) {
			String word = words[weight] + "{";
			for (int i = 0; i < word.length(); i++) {
				TrieNode curr = root;
				for (int j = i; j < 2 * word.length() - 1; j++) {
					int k = word.charAt(j % word.length()) - 'a';
					if (curr.children[k] == null) {
						curr.children[k] = new TrieNode();
					}
					curr = curr.children[k];
					curr.weight = weight;
				}
			}
		}
	}

	public int f(String prefix, String suffix) {
		String word = suffix + "{" + prefix;
		TrieNode curr = root;
		int weight = 0;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null) {
				return -1;
			}
			curr = curr.children[c - 'a'];
		}
		return curr.weight;
	}

	public static void main(String[] args) {
		WordFilter wordFilter = new WordFilter(new String[] { "apple" });
		System.out.println(wordFilter.f("a", "e"));
	}

}

class TrieNode {
	TrieNode[] children = null;
	int weight = 0;

	public TrieNode() {
		children = new TrieNode[27];
	}

}
