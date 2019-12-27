package com.onlineassesment;

import java.util.ArrayList;
import java.util.List;

public class NQueens {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> states = new ArrayList<List<String>>();
		boolean[][] boardState = new boolean[n][n];
		solve(boardState, 0, states);
		return states;
	}

	private void addBoardState(boolean[][] boardState, List<List<String>> states) {
		List<String> state = new ArrayList<>();
		for (int i = 0; i < boardState.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < boardState.length; j++) {
				if (boardState[i][j]) {
					sb.append("Q");
				} else {
					sb.append(".");
				}
			}
			state.add(sb.toString());
		}
		states.add(state);
	}

	private void solve(boolean[][] boardState, int row, List<List<String>> states) {
		if (row >= boardState.length) {
			addBoardState(boardState, states);
			return;
		}
		for (int col = 0; col < boardState.length; col++) {
			if (isBoardStateSafe(boardState, row, col)) {
				boardState[row][col] = true;
				solve(boardState, row + 1, states);
				boardState[row][col] = false;
			}
		}

	}

	private boolean isBoardStateSafe(boolean[][] boardState, int row, int col) {

		// check whether queen is present in column above
		for (int i = 0; i < row; i++) {
			if (boardState[i][col]) {
				return false;
			}
		}

		// check if left diagonal has any queens
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (boardState[i][j]) {
				return false;
			}
		}

		// check if right diagonal has any queens
		for (int i = row, j = col; i >= 0 && j < boardState.length; i--, j++) {
			if (boardState[i][j]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NQueens nq = new NQueens();
		System.out.println(nq.solveNQueens(2));
		System.out.println(nq.solveNQueens(3));
		System.out.println(nq.solveNQueens(4));
		// System.out.println(nq.solveNQueens(5));
	}
}
