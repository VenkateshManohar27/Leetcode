package com.ven.leetcode.dec.challenge;

import com.ven.utility.ArrayUtility;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * 
 * A sudoku solution must satisfy all of the following rules:
 * 
 * Each of the digits 1-9 must occur exactly once in each row. Each of the
 * digits 1-9 must occur exactly once in each column. Each of the digits 1-9
 * must occur exactly once in each of the 9 3x3 sub-boxes of the grid. The '.'
 * character indicates empty cells.
 * 
 * 
 * Example 1:
 * 
 * Input: board =
 * [["5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9"]]
 * Output:
 * [["5','3','4','6','7','8','9','1','2'},{'6','7','2','1','9','5','3','4','8'},{'1','9','8','3','4','2','5','6','7'},{'8','5','9','7','6','1','4','2','3'},{'4','2','6','8','5','3','7','9','1'},{'7','1','3','9','2','4','8','5','6'},{'9','6','1','5','3','7','2','8','4'},{'2','8','7','4','1','9','6','3','5'},{'3','4','5','2','8','6','1','7','9"]]
 * Explanation: The input board is shown above and the only valid solution is
 * shown below:
 * 
 * Constraints:
 * 
 * board.length == 9 board[i].length == 9 board[i][j] is a digit or '.'. It is
 * guaranteed that the input board has only one solution.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		boolean[][] rowsData = new boolean[board.length][board.length];
		boolean[][] colsData = new boolean[board.length][board.length];
		boolean[][] blockData = new boolean[board.length][board.length];

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == '.')
					continue;
				rowsData[i][board[i][j] - '1'] = true;
				colsData[j][board[i][j] - '1'] = true;

				int block = findBlock(i, j);
				if (block != -1) {
					blockData[block][board[i][j] - '1'] = true;
				}
			}
		}
		helper(board, rowsData, colsData, blockData);
		ArrayUtility.print(board);
	}

	private boolean helper(char[][] board, boolean[][] rowsData, boolean[][] colsData, boolean[][] blockData) {

		for (int i = 0; i < blockData.length; i++) {
			for (int j = 0; j < blockData.length; j++) {
				char c = board[i][j];
				if (c != '.')
					continue;
				for (int k = 1; k <= 9; k++) {

					if (!rowsData[i][k - 1] && !colsData[j][k - 1] && !blockData[findBlock(i, j)][k - 1]) {
						board[i][j] = (char) (k + '0');
						rowsData[i][k - 1] = true;
						colsData[j][k - 1] = true;
						blockData[findBlock(i, j)][k - 1] = true;
						if (helper(board, rowsData, colsData, blockData)) {
							return true;
						} else {
							rowsData[i][k - 1] = false;
							colsData[j][k - 1] = false;
							blockData[findBlock(i, j)][k - 1] = false;
							board[i][j] = c;
						}
					}

				}
				return false;
			}
		}
		return true;
	}

	private int findBlock(int i, int j) {
		return ((i / 3) * 3) + (j / 3);
	}

	public static void main(String[] args) {
		char[][] input = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		SudokuSolver s = new SudokuSolver();
		s.solveSudoku(input);
	}
}
