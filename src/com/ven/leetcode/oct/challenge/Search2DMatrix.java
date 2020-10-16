package com.ven.leetcode.oct.challenge;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3 Output:
 * true Example 2:
 * 
 * 
 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13 Output:
 * false Example 3:
 * 
 * Input: matrix = [], target = 0 Output: false
 * 
 * 
 * Constraints:
 * 
 * m == matrix.length n == matrix[i].length 0 <= m, n <= 100 -104 <=
 * matrix[i][j], target <= 10 4
 * 
 * @author Venkatesh Manohar
 *
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return false;
		int rowIndex = findRow(matrix, target);
		//System.out.println("Row ind:" + rowIndex);
		if (rowIndex == -1) {
			return false;
		}

		int[] row = matrix[rowIndex];
		return binSearch(row, target);
	}

	private int findRow(int[][] a, int target) {
		int start = 0;
		int end = a.length-1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			//System.out.println("mid:" + mid);
			if (a[mid][0] <= target && ((mid + 1 < a.length && a[mid + 1][0] > target) || (mid + 1 == a.length))) {
				return mid;
			} else if (a[mid][0] > target) {
				end = mid - 1;
			} else if (a[mid][0] < target) {
				start = mid + 1;
			}
		}
		return -1;
	}

	private boolean binSearch(int[] row, int target) {
		int start = 0;
		int end = row.length-1;

		while (start <= end) {
			int mid = start + (end - start) / 2;
			//System.out.println("bin s mid:" + mid);
			if (row[mid] == target) {
				return true;
			} else if (row[mid] > target) {
				end = mid - 1;
			} else if (row[mid] < target) {
				start = mid + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Search2DMatrix s = new Search2DMatrix();
		int[][] matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println("true = "+s.searchMatrix(matrix, 3));
		matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(s.searchMatrix(matrix, 13));
		
		matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println("true = "+s.searchMatrix(matrix, 11));
		
		matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println("true = "+s.searchMatrix(matrix, 34));
		
		matrix = new int[][] { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } };
		System.out.println(s.searchMatrix(matrix, 55));
		
		System.out.println("true = "+s.searchMatrix(matrix, 1));

		matrix = new int[][] { { 1, 3, 5, 7 } };
		System.out.println("true = "+s.searchMatrix(matrix, 3));

		matrix = new int[][] {};
		System.out.println(s.searchMatrix(matrix, 0));
		
		matrix = new int[][] {{}};
		System.out.println(s.searchMatrix(matrix, 0));

	}
}
