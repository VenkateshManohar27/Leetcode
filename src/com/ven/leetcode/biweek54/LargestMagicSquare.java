package com.ven.leetcode.biweek54;

/**
 * A k x k magic square is a k x k grid filled with integers such that every row
 * sum, every column sum, and both diagonal sums are all equal. The integers in
 * the magic square do not have to be distinct. Every 1 x 1 grid is trivially a
 * magic square.
 * 
 * Given an m x n integer grid, return the size (i.e., the side length k) of the
 * largest magic square that can be found within this grid.
 * 
 * Example 1:
 * 
 * Input: grid = [[7,1,4,5,6],[2,5,1,6,4],[1,5,4,3,2],[1,2,7,3,4]] Output: 3
 * Explanation: The largest magic square has a size of 3. Every row sum, column
 * sum, and diagonal sum of this magic square is equal to 12. - Row sums: 5+1+6
 * = 5+4+3 = 2+7+3 = 12 - Column sums: 5+5+2 = 1+4+7 = 6+3+3 = 12 - Diagonal
 * sums: 5+4+3 = 6+4+2 = 12 Example 2:
 * 
 * Input: grid = [[5,1,3,1],[9,3,3,1],[1,3,3,8]] Output: 2
 * 
 * Constraints:
 * 
 * m == grid.length n == grid[i].length 1 <= m, n <= 50 1 <= grid[i][j] <= 106
 * 
 * @author Venkatesh Manohar
 *
 */
public class LargestMagicSquare {

	public int largestMagicSquare(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] row = new int[m][n]; // row cumulative sum
		int[][] col = new int[m][n]; // col cumulative sum
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				row[i][j] = grid[i][j] + (j == 0 ? 0 : row[i][j - 1]);
				col[i][j] = grid[i][j] + (i == 0 ? 0 : col[i - 1][j]);
			}
		}
		for (int k = Math.min(m, n); k >= 2; k--) {
			int i = k, j = k;
			while (i <= m && j <= n) {
				int sum = row[i - k][j - 1] - (j == k ? 0 : row[i - k][j - k - 1]);
				boolean flag = true;

				// check row sum O(k)
				for (int l = i - k + 1; l < i; l++) {
					if (sum != row[l][j - 1] - (j == k ? 0 : row[l][j - k - 1])) {
						flag = false;
					}
				}

				// check col sum O(k)
				if (flag) {
					for (int l = j - k; l < j; l++) {
						if (sum != col[i - 1][l] - (i == k ? 0 : col[i - k - 1][l])) {
							flag = false;
						}
					}
				}

				// check diagonals O(k)
				if (flag) {
					int tmp1 = 0, tmp2 = 0;
					for (int l = 0; l < k; l++) {
						tmp1 += grid[l + i - k][l + j - k];
						tmp2 += grid[l + i - k][j - l - 1];
					}
					if (tmp1 == sum && tmp2 == sum) {
						return k;
					}
				}
				j++;
				if (j > n) {
					i++;
					j = k;
				}
			}
		}
		return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestMagicSquare c = new LargestMagicSquare();
		c.largestMagicSquare(
				new int[][] { { 7, 1, 4, 5, 6 }, { 2, 5, 1, 6, 4 }, { 1, 5, 4, 3, 2 }, { 1, 2, 7, 3, 4 } });
	}
}
