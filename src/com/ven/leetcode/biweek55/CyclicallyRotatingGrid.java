package com.ven.leetcode.biweek55;

public class CyclicallyRotatingGrid {
	public int[][] rotateGrid(int[][] grid, int k) {
		spiralRotate(grid, grid.length, grid[0].length, k);

		return grid;
	}

	void fillSpiral(int mat[][], int m, int n, int temp[]) {
		int k = 0, l = 0;

		/*
		 * k - starting row index m - ending row index l - starting column index n -
		 * ending column index
		 */
		int tIdx = 0; // Index in temp array
		while (k < m && l < n) {
			/* first row from the remaining rows */
			for (int i = l; i < n; ++i)
				mat[k][i] = temp[tIdx++];
			k++;

			/* last column from the remaining columns */
			for (int i = k; i < m; ++i)
				mat[i][n - 1] = temp[tIdx++];
			n--;

			/* last row from the remaining rows */
			if (k < m) {
				for (int i = n - 1; i >= l; --i)
					mat[m - 1][i] = temp[tIdx++];
				m--;
			}

			/* first column from the remaining columns */
			if (l < n) {
				for (int i = m - 1; i >= k; --i)
					mat[i][l] = temp[tIdx++];
				l++;
			}
		}
	}

	// Function to spirally traverse matrix and
	// rotate each ring of matrix by K elements
	// mat[][] --> matrix of elements
	// M --> number of rows
	// N --> number of columns
	void spiralRotate(int mat[][], int M, int N, int k) {
		// Create a temporary array to store the result
		int temp[] = new int[M * N];

		/*
		 * s - starting row index m - ending row index l - starting column index n -
		 * ending column index;
		 */
		int m = M, n = N, s = 0, l = 0;

		int start = 0; // Start position of current ring
		int tIdx = 0; // Index in temp
		while (s < m && l < n) {
			// Initialize end position of current ring
			int end = start;

			// copy the first row from the remaining rows
			for (int i = l; i < n; ++i) {
				temp[tIdx++] = mat[s][i];
				end++;
			}
			s++;

			// copy the last column from the remaining columns
			for (int i = s; i < m; ++i) {
				temp[tIdx++] = mat[i][n - 1];
				end++;
			}
			n--;

			// copy the last row from the remaining rows
			if (s < m) {
				for (int i = n - 1; i >= l; --i) {
					temp[tIdx++] = mat[m - 1][i];
					end++;
				}
				m--;
			}

			/* copy the first column from the remaining columns */
			if (l < n) {
				for (int i = m - 1; i >= s; --i) {
					temp[tIdx++] = mat[i][l];
					end++;
				}
				l++;
			}

			// if elements in current ring greater than
			// k then rotate elements of current ring
			if (end - start > k) {
				// Rotate current ring using revarsal
				// algorithm for rotation
				reverseArray(temp, start, start + k);
				reverseArray(temp, start + k, end);
				reverseArray(temp, start, end);

				// Reset start for next ring
				start = end;
			} else // There are less than k elements in ring
				break;
		}

		// Fill tenp array in original matrix.
		fillSpiral(mat, M, N, temp);
	}

	/**
	 * 
	 * @param arr
	 * @param i
	 * @param j
	 */
	private static void reverseArray(int[] arr, int start, int end) {
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}

	}
}
