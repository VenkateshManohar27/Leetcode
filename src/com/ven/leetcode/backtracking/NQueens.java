package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public void addBoardState(int[][] board, List<List<String>> state) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			list.add(sb.toString());
		}

		state.add(list);
	}

	public List<List<String>> solveNQueens(int n) {
		int[][] board = new int[n][n];
		List<List<String>> state = new ArrayList<List<String>>();
		solve(board, 0, state);
		return state;
	}

	private void solve(int[][] board, int row,List<List<String>> state) {
		if (row >= board.length) {
			addBoardState(board, state);
			return;
		}
		for (int col = 0; col < board.length; col++) {
			if (isBoardSafe(board, row, col)) {
				board[row][col] = 1;
				solve(board, row + 1, state);
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
		NQueens nq = new NQueens();
		List<List<String>> res = nq.solveNQueens(4);
		System.out.println(res);
		
		res = nq.solveNQueens(5);
		System.out.println(res);
	}

}
