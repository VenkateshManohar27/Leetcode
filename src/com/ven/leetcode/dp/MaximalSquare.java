package com.ven.leetcode.dp;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}

		int max = 0;
		int dp[][] = new int[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = matrix[i][j] - '0';
					if (max == 0 && dp[i][j] == 1) {
						max = 1;
					}
					continue;
				}

				if (matrix[i][j] == '1') {
					if (matrix[i - 1][j] != 0 && matrix[i - 1][j - 1] != 0 && matrix[i][j - 1] != 0) {
						int maxSqr = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
						dp[i][j] = maxSqr;
						max = Math.max(max, maxSqr);
					}
				}
			}
		}

		return max * max;
	}

	public static void main(String[] args) {
		char[][] chrs = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };
		MaximalSquare ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(chrs));

		chrs = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' }, { '1', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1' } };
		ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(chrs));

		chrs = new char[][] { { '1', '0', '1', '0', '0', '1' }, { '1', '0', '1', '1', '1', '0' },
				{ '1', '1', '1', '1', '1', '0' }, { '1', '0', '1', '1', '1', '0' }, { '1', '0', '1', '1', '1', '0' },
				{ '1', '0', '1', '1', '1', '0' } };
		ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(chrs));

		chrs = new char[][] { { '1', '0', '1', '0', '0', '1' }, { '1', '0', '1', '1', '1', '1' },
				{ '1', '1', '1', '1', '1', '1' }, { '1', '0', '1', '1', '1', '1' }, { '1', '0', '1', '1', '1', '1' },
				{ '1', '0', '1', '1', '1', '0' } };
		ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(chrs));

		chrs = new char[][] { { '0' } };
		ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(chrs));
		
		chrs = new char[][] { { '0','0','1' } };
		ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(chrs));
		
		chrs = new char[][] { { '0'},{'0'},{'1' } };
		ms = new MaximalSquare();
		System.out.println(ms.maximalSquare(chrs));

	}
}
