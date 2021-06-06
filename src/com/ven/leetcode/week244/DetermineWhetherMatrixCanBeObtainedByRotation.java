package com.ven.leetcode.week244;

/**
 * Given two n x n binary matrices mat and target, return true if it is possible
 * to make mat equal to target by rotating mat in 90-degree increments, or false
 * otherwise.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]] Output: true Explanation:
 * We can rotate mat 90 degrees clockwise to make mat equal target. Example 2:
 * 
 * 
 * Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]] Output: false Explanation:
 * It is impossible to make mat equal to target by rotating mat. Example 3:
 * 
 * 
 * Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * Output: true Explanation: We can rotate mat 90 degrees clockwise two times to
 * make mat equal target.
 * 
 * 
 * Constraints:
 * 
 * n == mat.length == target.length n == mat[i].length == target[i].length 1 <=
 * n <= 10 mat[i][j] and target[i][j] are either 0 or 1.
 * 
 * @author Venkatesh Manohar
 *
 */
public class DetermineWhetherMatrixCanBeObtainedByRotation {

	static void reverseColumns(int arr[][]) {
		for (int i = 0; i < arr[0].length; i++)
			for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) {
				int temp = arr[j][i];
				arr[j][i] = arr[k][i];
				arr[k][i] = temp;
			}
	}

	// Function for do transpose of matrix
	static void transpose(int arr[][]) {
		for (int i = 0; i < arr.length; i++)
			for (int j = i; j < arr[0].length; j++) {
				int temp = arr[j][i];
				arr[j][i] = arr[i][j];
				arr[i][j] = temp;
			}
	}

	private boolean compare(int[][] mat, int[][] target) {
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat.length; j++) {
				if (mat[i][j] != target[i][j]) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean findRotation(int[][] mat, int[][] target) {

		// Check 360
		if (compare(mat, target))
			return true;
		// 90
		transpose(mat);
		reverseColumns(mat);
		if (compare(mat, target))
			return true;
		// 180
		transpose(mat);
		reverseColumns(mat);
		if (compare(mat, target))
			return true;
		// 270
		transpose(mat);
		reverseColumns(mat);
		if (compare(mat, target))
			return true;

		return false;
	}

	public static void main(String[] args) {
		DetermineWhetherMatrixCanBeObtainedByRotation a = new DetermineWhetherMatrixCanBeObtainedByRotation();
		int[][] mat = new int[][] { { 0, 1 }, { 1, 0 } };
		int[][] target = new int[][] { { 0, 1 }, { 1, 0 } };
		System.out.println(a.findRotation(mat, target));

	}

}
