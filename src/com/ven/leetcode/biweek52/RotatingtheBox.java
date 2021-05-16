package com.ven.leetcode.biweek52;

/**
 * You are given an m x n matrix of characters box representing a side-view of a
 * box. Each cell of the box is one of the following:
 * 
 * A stone '#' A stationary obstacle '*' Empty '.' The box is rotated 90 degrees
 * clockwise, causing some of the stones to fall due to gravity. Each stone
 * falls down until it lands on an obstacle, another stone, or the bottom of the
 * box. Gravity does not affect the obstacles' positions, and the inertia from
 * the box's rotation does not affect the stones' horizontal positions.
 * 
 * It is guaranteed that each stone in box rests on an obstacle, another stone,
 * or the bottom of the box.
 * 
 * Return an n x m matrix representing the box after the rotation described
 * above.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: box = [["#",".","#"]] Output: [["."], ["#"], ["#"]] Example 2:
 * 
 * 
 * 
 * Input: box = [["#",".","*","."], ["#","#","*","."]] Output: [["#","."],
 * ["#","#"], ["*","*"], [".","."]] Example 3:
 * 
 * 
 * 
 * Input: box = [["#","#","*",".","*","."], ["#","#","#","*",".","."],
 * ["#","#","#",".","#","."]] Output: [[".","#","#"], [".","#","#"],
 * ["#","#","*"], ["#","*","."], ["#",".","*"], ["#",".","."]]
 * 
 * 
 * Constraints:
 * 
 * m == box.length n == box[i].length 1 <= m, n <= 500 box[i][j] is either '#',
 * '*', or '.'.
 * 
 * @author Venkatesh Manohar
 *
 */
public class RotatingtheBox {
	public char[][] rotateTheBox(char[][] box) {
		int m = box.length;
		int n = box[0].length;
		char[][] res = new char[n][m];

		for (int i = 0; i < m; i++) {
			int obstacle = n - 1;
			int index = n - 1;
			while (index >= 0) {
				if (box[i][index] == '.') {
					index--;
					continue;
				}
				if (box[i][index] == '*') {
					obstacle = index;
				}
				// obstacle--;
				int j = obstacle;
				while (j >= 0) {
					// reset obstacle index
					if (box[i][j] == '*') {
						obstacle = j - 1;
						;
					}
					// swap the stones
					if (box[i][j] == '#') {
						char temp = box[i][j];
						box[i][j] = '.';
						box[i][obstacle--] = temp;
					}
					j--;
				}
				index = j;
			}
		}
		// Rotate 90 degrees
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[j][m - i - 1] = box[i][j];
			}
		}

		return res;

	}
}
