package com.ven.leetcode.oct2021.challenge;

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || word == null) {
			return false;
		}
		char firstChar = word.charAt(0);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (firstChar == board[i][j]) {
					if (backtrack(i, j, board, 0, word)) {
						return true;
					}
				}
			}
		}
		return false;
	
    }
    
    private boolean backtrack(int row, int col, char[][] board, int index, String word) {
		if (index == word.length()) {
			return true;
		}

		if (row < 0 || row >= board.length || col < 0 || col >= board[row].length
				|| board[row][col] != word.charAt(index)) {
			return false;
		}
		
		char temp = board[row][col];
		board[row][col] = ' ';
		boolean found = backtrack(row - 1, col, board, index + 1, word) || backtrack(row + 1, col, board, index + 1, word)
				|| backtrack(row, col - 1, board, index + 1, word) || backtrack(row, col + 1, board, index + 1, word);
		board[row][col] = temp;
		return found;
	}
    
    public static void main(String[] args) {
		WordSearch ws = new WordSearch();
		char[][] board = new char[][] {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		System.out.println(ws.exist(board, "ABCCED"));
		
		System.out.println(ws.exist(board, "ABCB"));
		
		 board = new char[][] {{'a','a'}};
		 System.out.println(ws.exist(board, "aaa"));
		
	}
}
