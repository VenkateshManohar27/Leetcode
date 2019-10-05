package com.ven.amazon;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cell, where
 * "adjacent" cells are those horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * 
 * Example:
 * 
 * board = [ ['A','B','C','E'], ['S','F','C','S'], ['A','D','E','E'] ]
 * 
 * Given word = "ABCCED", return true. Given word = "SEE", return true. Given
 * word = "ABCB", return false.
 * 
 * @author Venkatesh Manohar
 *
 */
public class WordSearch {

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null) {
			return false;
		}
		char firstChar = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (firstChar == board[i][j]) {
					if (search2(i, j, board, 0, word)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean search(int row, int col, char[][] board, int index, String word) {
		if (index == word.length()) {
			return true;
		}

		if (row < 0 || row >= board.length || col < 0 || col >= board[row].length
				|| board[row][col] != word.charAt(index)) {
			return false;
		}

		char temp = board[row][col];
		board[row][col] = ' ';
		boolean found = search(row - 1, col, board, index + 1, word) || search(row + 1, col, board, index + 1, word)
				|| search(row, col - 1, board, index + 1, word) || search(row, col + 1, board, index + 1, word);
		board[row][col] = temp;
		return found;
	}

	// Causes TLE
	public boolean exist2(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null) {
			return false;
		}
		char firstChar = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (firstChar == board[i][j]) {
					if (search(i, j, board, 1, word)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * TLE is caused since we continue to check other options even if the search
	 * returns true
	 * 
	 * @param row
	 * @param col
	 * @param board
	 * @param index
	 * @param word
	 * @return
	 */
	private boolean search2(int row, int col, char[][] board, int index, String word) {
		if (index == word.length()) {
			return true;
		}

		char temp = board[row][col];
		board[row][col] = ' ';
		boolean found = false;
		if (row > 0) {
			if (word.charAt(index) == board[row - 1][col]) {
				found |= search(row - 1, col, board, index + 1, word);
			}
		}

		if (row < board.length - 1) {
			if (word.charAt(index) == board[row + 1][col]) {
				found |= search(row + 1, col, board, index + 1, word);
			}
		}

		if (col > 0) {
			if (word.charAt(index) == board[row][col - 1]) {
				found |= search(row, col - 1, board, index + 1, word);
			}
		}

		if (col < board[row].length - 1) {
			if (word.charAt(index) == board[row][col + 1]) {
				found |= search(row, col + 1, board, index + 1, word);
			}
		}
		board[row][col] = temp;
		return found;
	}

	public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println("\"ABCCED\" exists:" + ws.exist(board, "ABCCED"));
		System.out.println("\"SEE\" exists:" + ws.exist(board, "SEE"));
		System.out.println("\"ABCB\" exists:" + ws.exist(board, "ABCB"));
	}
}
