package com.ven.leetcode.trie;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in
 * the board.
 * 
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring. The
 * same letter cell may not be used more than once in a word.
 * 
 * 
 * 
 * Example:
 * 
 * Input: board = [ ['o','a','a','n'], ['e','t','a','e'], ['i','h','k','r'],
 * ['i','f','l','v'] ] words = ["oath","pea","eat","rain"]
 * 
 * Output: ["eat","oath"]
 * 
 * 
 * Note:
 * 
 * All inputs are consist of lowercase letters a-z. The values of words are
 * distinct.
 * 
 * @author Venkatesh Manohar
 *
 */

class TrieNode {
	TrieNode[] next = null;
	boolean isEnd = false;

	public TrieNode() {
		super();
		this.next = new TrieNode[27];
	}

}

public class WordSearchII {
	TrieNode root = new TrieNode();

	public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<>();
		if (board == null || board.length == 0 || words == null || words.length == 0) {
			return res;
		}
		constructTrie(words);
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				search(board, i, j, root.next[board[i][j] - 'a'], sb, res);
			}
		}
		return res;
	}

	private void search(char[][] board, int row, int col, TrieNode trie, StringBuilder sb, List<String> res) {
		if (trie != null) {
			char c = board[row][col];
			sb.append(c);
			if (trie.isEnd) {
				res.add(sb.toString());
				trie.isEnd = false; // To avoid repetition
			}

			board[row][col] = '{';

			// Below cell
			if (row + 1 < board.length) {
				search(board, row + 1, col, trie.next[board[row + 1][col] - 'a'], sb, res);
			}

			// Upper cell
			if (row - 1 >= 0) {
				search(board, row - 1, col, trie.next[board[row - 1][col] - 'a'], sb, res);
			}

			// left cell
			if (col - 1 >= 0) {
				search(board, row, col - 1, trie.next[board[row][col - 1] - 'a'], sb, res);
			}

			// Upper cell
			if (col + 1 < board[row].length) {
				search(board, row, col + 1, trie.next[board[row][col + 1] - 'a'], sb, res);
			}

			board[row][col] = c;
			sb.deleteCharAt(sb.length() - 1);
		}
	}

	private void constructTrie(String[] words) {

		for (int i = 0; i < words.length; i++) {
			TrieNode node = root;
			for (char c : words[i].toCharArray()) {
				if (node.next[c - 'a'] == null) {
					node.next[c - 'a'] = new TrieNode();

				}
				node = node.next[c - 'a'];

			}
			node.isEnd = true;
		}
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = new String[] { "oath", "pea", "eat", "rain" };
		WordSearchII ws = new WordSearchII();
		System.out.println(ws.findWords(board, words));
	}
}
