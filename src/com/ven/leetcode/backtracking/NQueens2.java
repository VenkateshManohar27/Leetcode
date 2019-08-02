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
public class NQueens2 {
	static class Result {
		int count;
	}

	public int totalNQueens(int n) {
		int[][] board = new int[n][n];
		Result res = new Result();
		solve(board, 0, res);
		return res.count;
	}

	private void solve(int[][] board, int row, Result res) {
		if (row >= board.length) {
			res.count++;
			return;
		}
		
		for (int col = 0; col < board.length; col++) {
			if (isBoardSafe(board, row, col)) {
				board[row][col] = 1;
				solve(board, row + 1, res);
				board[row][col] = 0;
			}
		}
	}

	private boolean isBoardSafe(int[][] board, int row, int col) {
		// Check if above column has any queens
		for (int i = row; i >= 0; i--) {
			if (board[i][col] == 1) {
				return false;
			}
		}

		// check if left diagonal has any queens
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		// check if right diagonal has any queens
		for (int i = row, j = col; i >= 0 && j < board.length; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens2 nq = new NQueens2();
		System.out.println(nq.totalNQueens(4));
		System.out.println(nq.totalNQueens(5));
		System.out.println(nq.totalNQueens(6));
	}

}
