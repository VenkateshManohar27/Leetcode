package com.ven.leetcode.oct2021.challenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an m x n board of characters and a list of strings words, return all
 * words on the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once in a word.
 * 
 * Example 1:
 * 
 * Input: board =
 * [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"] Output: ["eat","oath"] Example 2:
 * 
 * Input: board = [["a","b"],["c","d"]], words = ["abcb"] Output: []
 * 
 * Constraints:
 * 
 * m == board.length n == board[i].length 1 <= m, n <= 12 board[i][j] is a
 * lowercase English letter. 1 <= words.length <= 3 * 104 1 <= words[i].length
 * <= 10 words[i] consists of lowercase English letters. All the strings of
 * words are unique.
 * 
 * @author Venkatesh Manohar
 *
 */

class TrieNode {
	TrieNode[] children = new TrieNode[27];
	boolean end = false;
}

public class WordSearchII {
	TrieNode root = new TrieNode();

	public List<String> findWords(char[][] board, String[] words) {
		List<String> l = new ArrayList<>();
		constructTrie(words);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				sb.setLength(0);
				search(board, i, j, root.children[board[i][j] - 'a'], l, sb);
			}
		}

		return l;
	}

	private void search(char[][] board, int i, int j, TrieNode node, List<String> l, StringBuilder sb) {
		if (node != null) {
			char c = board[i][j];
			sb.append(c);
			if (node.end) {
				l.add(sb.toString());
				node.end = false;
				return;
			}

			board[i][j] = '{';
			// right
			if (j + 1 < board[i].length)
				search(board, i, j + 1, node.children[board[i][j + 1] - 'a'], l, sb);
			// go left
			if (j - 1 >= 0)
				search(board, i, j - 1, node.children[board[i][j - 1] - 'a'], l, sb);
			// up
			if (i - 1 >= 0)
				search(board, i - 1, j, node.children[board[i - 1][j] - 'a'], l, sb);
			// down
			if (i + 1 < board.length)
				search(board, i + 1, j, node.children[board[i + 1][j] - 'a'], l, sb);

			board[i][j] = c;
			sb.deleteCharAt(sb.length()-1);
		}

	}

	public void constructTrie(String[] words) {
		for (String word : words) {
			TrieNode node = root;
			for (int i = 0; i < word.length(); i++) {
				int ch = word.charAt(i) - 'a';
				if (node.children[ch] == null) {
					node.children[ch] = new TrieNode();
				}
				node = node.children[ch];

			}
			node.end = true;
		}
	}
	
	public static void main(String[] args) {
		WordSearchII ws = new WordSearchII();
		char[][] board = new char[][] 
		{{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = new String[]	{"oath","pea","eat","rain"};
		System.out.println(ws.findWords(board, words));
	}
}
