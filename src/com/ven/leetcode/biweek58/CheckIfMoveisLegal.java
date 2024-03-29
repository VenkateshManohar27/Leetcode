package com.ven.leetcode.biweek58;

/**
 * You are given a 0-indexed 8 x 8 grid board, where board[r][c] represents the
 * cell (r, c) on a game board. On the board, free cells are represented by '.',
 * white cells are represented by 'W', and black cells are represented by 'B'.
 * 
 * Each move in this game consists of choosing a free cell and changing it to
 * the color you are playing as (either white or black). However, a move is only
 * legal if, after changing it, the cell becomes the endpoint of a good line
 * (horizontal, vertical, or diagonal).
 * 
 * A good line is a line of three or more cells (including the endpoints) where
 * the endpoints of the line are one color, and the remaining cells in the
 * middle are the opposite color (no cells in the line are free). You can find
 * examples for good lines in the figure below:
 * 
 * 
 * Given two integers rMove and cMove and a character color representing the
 * color you are playing as (white or black), return true if changing cell
 * (rMove, cMove) to color color is a legal move, or false if it is not legal.
 * 
 * Example 1:
 * 
 * Input: board =
 * [[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],["W","B","B",".","W","W","W","B"],[".",".",".","B",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".","."]],
 * rMove = 4, cMove = 3, color = "B" Output: true Explanation: '.', 'W', and 'B'
 * are represented by the colors blue, white, and black respectively, and cell
 * (rMove, cMove) is marked with an 'X'. The two good lines with the chosen cell
 * as an endpoint are annotated above with the red rectangles. Example 2:
 * 
 * 
 * Input: board =
 * [[".",".",".",".",".",".",".","."],[".","B",".",".","W",".",".","."],[".",".","W",".",".",".",".","."],[".",".",".","W","B",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".","B","W",".","."],[".",".",".",".",".",".","W","."],[".",".",".",".",".",".",".","B"]],
 * rMove = 4, cMove = 4, color = "W" Output: false Explanation: While there are
 * good lines with the chosen cell as a middle cell, there are no good lines
 * with the chosen cell as an endpoint.
 * 
 * 
 * Constraints:
 * 
 * board.length == board[r].length == 8 0 <= rMove, cMove < 8
 * board[rMove][cMove] == '.' color is either 'B' or 'W'.
 * 
 * @author Venkatesh Manohar
 *
 */
public class CheckIfMoveisLegal {
	public boolean checkMove(char[][] board, int r, int c, char color) {
		board[r][c] = color;
		int n = board.length;
		int m = board[0].length;
		if (r <= 5) {
			int count = 1;
			for (int i = r + 1; i < n; i++) {
				count++;
				if (board[i][c] == '.')
					break;
				if (count < 3 && board[i][c] == color)
					break;
				if (count >= 3 && board[i][c] == color) {
					// System.out.println ("row down");
					return true;
				}
			}
		}
		if (r >= 2) {
			int count = 1;
			for (int i = r - 1; i >= 0; i--) {
				count++;
				if (board[i][c] == '.')
					break;
				if (count < 3 && board[i][c] == color)
					break;
				if (count >= 3 && board[i][c] == color) {
					// System.out.println ("row up");
					return true;
				}
			}
		}
		if (c >= 2) {
			int count = 1;
			for (int j = c - 1; j >= 0; j--) {
				count++;
				if (board[r][j] == '.')
					break;
				if (count < 3 && board[r][j] == color)
					break;
				if (count >= 3 && board[r][j] == color) {
					// System.out.println ("col left");
					return true;
				}
			}
		}
		if (c <= 5) {
			int count = 1;
			for (int j = c + 1; j < m; j++) {
				count++;
				if (board[r][j] == '.')
					break;
				if (count < 3 && board[r][j] == color)
					break;
				if (count >= 3 && board[r][j] == color) {
					// System.out.println ("col right");
					return true;
				}
			}
		}
		if (r >= 2 && c >= 2) {
			int count = 1;
			for (int i = r - 1, j = c - 1; i >= 0 && j >= 0; i--, j--) {
				count++;
				if (board[i][j] == '.')
					break;
				if (count < 3 && board[i][j] == color)
					break;
				if (count >= 3 && board[i][j] == color) {
					// System.out.println ("dia left up");
					return true;
				}
			}
		}
		if (r <= 5 && c <= 5) {
			int count = 1;
			for (int i = r + 1, j = c + 1; i < n && j < m; i++, j++) {
				count++;
				if (board[i][j] == '.')
					break;
				if (count < 3 && board[i][j] == color)
					break;
				if (count >= 3 && board[i][j] == color) {
					// System.out.println ("dia right down");
					return true;
				}
			}
		}
		if (r >= 2 && c <= 5) {
			int count = 1;
			for (int i = r - 1, j = c + 1; i >= 0 && j < m; i--, j++) {
				count++;
				if (board[i][j] == '.')
					break;
				if (count < 3 && board[i][j] == color)
					break;
				if (count >= 3 && board[i][j] == color) {
					// System.out.println ("dia left down");
					return true;
				}
			}
		}
		if (r <= 5 && c >= 2) {
			int count = 1;
			for (int i = r + 1, j = c - 1; i < n && j >= 0; i++, j--) {
				count++;
				if (board[i][j] == '.')
					break;
				if (count < 3 && board[i][j] == color)
					break;
				if (count >= 3 && board[i][j] == color) {
					// System.out.println ("dia right up");
					return true;
				}
			}
		}
		return false;
	}
}
