package com.ven.leetcode.may2021.challenge;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> li = new ArrayList<>();
		boolean[][] board = new boolean[n][n];
		helper(board, 0, li);
		return li;
	}

	private void helper(boolean[][] b, int row, List<List<String>> li) {
		if (row >= b.length) {
			List<String> l = new ArrayList<String>();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < b.length; i++) {
				sb.setLength(0);
				for (int j = 0; j < b.length; j++) {
					if (b[i][j]) {
						sb.append("Q");
					} else {
						sb.append(".");
					}
				}
				l.add(sb.toString());
			}
			li.add(l);
			return;
		}
		for (int i = 0; i < b.length; i++) {
			if (stateValid(b, row, i)) {
				b[row][i] = true;

				helper(b, row + 1, li);

				b[row][i] = false;
			}
		}
	}

	private boolean stateValid(boolean[][] b, int r, int c) {
		// check above rows for queens
		for (int i = r; i >= 0; i--) {
			if (b[i][c]) {
				return false;
			}
		}

		// check left diagonal for queens
		for (int i = r, j = c; i >= 0 && j >= 0; i--, j--) {
			if (b[i][j])
				return false;
		}

		// check if right diagonal has any queens
		for (int i = r, j = c; i >= 0 && j < b.length; i--, j++) {
			if (b[i][j])
				return false;

		}
		return true;
	}

	public static void main(String[] args) {
		NQueens n = new NQueens();
		System.out.println(n.solveNQueens(4));
		System.out.println(n.solveNQueens(5));
		
		System.out.println(n.solveNQueens(6));
	}
}
