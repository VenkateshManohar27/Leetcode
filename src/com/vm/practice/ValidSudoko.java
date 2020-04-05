package com.vm.practice;

public class ValidSudoko {

	public boolean isValidSudoku(char[][] board) {

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if(!Character.isDigit(board[i][j])) {
					continue;
				}
				int num = board[i][j] - '0';
				if (!isNumberValidInRow(board, num, i, j)) {
					return false;
				}
				if (!isNumberValidInColumn(board, num,i,  j)) {
					return false;
				}
				if (!isNumberValidInSubBox(board, num, i, j)) {
					return false;
				}
			}
		}

		return true;
	}

	private boolean isNumberValidInRow(char[][] board, int num, int row, int col) {
		for (int j = col+1; j < 9; j++) {
			if(!Character.isDigit(board[row][j])) {
				continue;
			}
			if (num == board[row][j] - '0') {
				return false;
			}
		}
		return true;
	}

	private boolean isNumberValidInColumn(char[][] board, int num, int row, int col) {
		for (int i = row+1; i < 9; i++) {
			if(!Character.isDigit(board[i][col])) {
				continue;
			}
			if (num == board[i][col] - '0') {
				return false;
			}
		}
		return true;
	}

	private boolean isNumberValidInSubBox(char[][] board, int num, int row, int col) {
		int subrow = row / 3;
		int subcol = col / 3;

		for (int i = subrow * 3; i < (subrow*3 + 3); i++) {
			for (int j = subcol * 3; j < (subcol*3 + 3); j++) {
				if((i == row && j == col) ||  !Character.isDigit(board[i][j])) {
					continue;
				}
				if (num == board[i][j] - '0') {
					return false;
				}
			}
		}
		return true;
	}
	public static void main(String[] args) {
		char[][] board = new char[][]{
		  {'8','3','.','.','7','.','.','.','.'},
		  {'6','.','.','1','9','5','.','.','.'},
		  {'.','9','8','.','.','.','.','6','.'},
		  {'8','.','.','.','6','.','.','.','3'},
		  {'4','.','.','8','.','3','.','.','1'},
		  {'7','.','.','.','2','.','.','.','6'},
		  {'.','6','.','.','.','.','2','8','.'},
		  {'.','.','.','4','1','9','.','.','5'},
		  {'.','.','.','.','8','.','.','7','9'}
		};
		ValidSudoko vs = new ValidSudoko();
		System.out.println(vs.isValidSudoku(board));
		
		board = new char[][] {{'.','.','.','.','.','.','5','.','.'},
			{'.','.','.','.','.','.','.','.','.'},
			{'.','.','.','.','.','.','.','.','.'},
			{'9','3','.','.','2','.','4','.','.'},
			{'.','.','7','.','.','.','3','.','.'},
			{'.','.','.','.','.','.','.','.','.'},
			{'.','.','.','3','4','.','.','.','.'},
			{'.','.','.','.','.','3','.','.','.'},
			{'.','.','.','.','.','5','2','.','.'}};
			
			
			System.out.println(vs.isValidSudoku(board));
	}
}
