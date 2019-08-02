package com.ven.leetcode.backtracking;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other.
 * 
 * 
 * 
 * Given an integer n, return the number of distinct solutions to the n-queens
 * puzzle.
 * 
 * Example:
 * 
 * Input: 4 Output: 2 Explanation: There are two distinct solutions to the
 * 4-queens puzzle as shown below. [ [".Q..", // Solution 1 "...Q", "Q...",
 * "..Q."],
 * 
 * ["..Q.", // Solution 2 "Q...", "...Q", ".Q.."] ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class NQueens3 {
	//Here I am not using any result object
	public int totalNQueens(int n) {
		boolean[][] board = new boolean[n][n];
		return solve(board, 0);
	}

	private int solve(boolean[][] board, int row) {
		if (row >= board.length) {
			return 1;
		}
		int sum = 0;
		for (int col = 0; col < board.length; col++) {
			if (isBoardSafe(board, row, col)) {
				board[row][col] = true;
				sum+=solve(board, row + 1);
				board[row][col] = false;
			}
		}
		
		return sum;
	}

	private boolean isBoardSafe(boolean[][] board, int row, int col) {
		// Check if above column has any queens
		for (int i = row; i >= 0; i--) {
			if (board[i][col]) {
				return false;
			}
		}

		// check if left diagonal has any queens
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j]) {
				return false;
			}
		}

		// check if right diagonal has any queens
		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens3 nq = new NQueens3();
		System.out.println(nq.totalNQueens(4));
		System.out.println(nq.totalNQueens(5));
		System.out.println(nq.totalNQueens(6));
	}

}
