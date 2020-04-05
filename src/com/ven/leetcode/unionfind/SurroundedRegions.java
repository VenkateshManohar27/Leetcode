package com.ven.leetcode.unionfind;

import com.ven.utility.ArrayUtility;

/**
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * Example:
 * 
 * X X X X X O O X X X O X X O X X After running your function, the board should
 * be:
 * 
 * X X X X X X X X X X X X X O X X Explanation:
 * 
 * Surrounded regions shouldn’t be on the border, which means that any 'O' on
 * the border of the board are not flipped to 'X'. Any 'O' that is not on the
 * border and it is not connected to an 'O' on the border will be flipped to
 * 'X'. Two cells are connected if they are adjacent cells connected
 * horizontally or vertically.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SurroundedRegions {
	public void solve(char[][] board) {
		int rows = board.length;
		int cols = board[0].length;

		for (int i = 0; i < rows; i++) {
			if (board[i][0] == 'O') boundaryConnectedDFS(board, i, 0);
			if (board[i][cols-1] == 'O') boundaryConnectedDFS(board, i, cols - 1);
		}

		for (int i = 0; i < cols; i++) {
			if (board[0][i] == 'O') boundaryConnectedDFS(board, 0, i);
			if (board[rows-1][i] == 'O') boundaryConnectedDFS(board, rows - 1, i);
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				} else if (board[i][j] == '*') {
					board[i][j] = 'O';
				}
			}
		}
	}

	private void boundaryConnectedDFS(char[][] board, int i, int j) {
		if (i < 0 || i >= board.length || j < 0 || j > board[0].length) {
			return;
		}

		if (board[i][j] == 'O') {
			board[i][j] = '*';
		}

		if (i > 0 && board[i - 1][j] == 'O') {
			boundaryConnectedDFS(board, i - 1, j);
		}

		if (i < board.length - 1 && board[i + 1][j] == 'O') {
			boundaryConnectedDFS(board, i + 1, j);
		}

		if (j > 0 && board[i][j - 1] == 'O') {
			boundaryConnectedDFS(board, i, j - 1);
		}

		if (j < board[0].length - 1 && board[i][j + 1] == 'O') {
			boundaryConnectedDFS(board, i, j + 1);
		}
		return;
	}
	
	public static void main(String[] args) {
		char[][] board = {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
		SurroundedRegions sr = new SurroundedRegions();
		sr.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j]+",");
			}
			System.out.println("");
		}
	}
}
