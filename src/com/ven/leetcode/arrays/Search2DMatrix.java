package com.ven.leetcode.arrays;

import java.util.Arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted from left to right. The first integer of each
 * row is greater than the last integer of the previous row. Example 1:
 * 
 * Input: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] target =
 * 3 Output: true Example 2:
 * 
 * Input: matrix = [ [1, 3, 5, 7], [10, 11, 16, 20], [23, 30, 34, 50] ] target =
 * 13 Output: false
 * 
 * @author Venkatesh Manohar
 *
 */
public class Search2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix == null || matrix.length == 0) {
			return false;
		}
		int index = -1;
		for (int i = 0; i < matrix.length; i++) {
			if(matrix[i].length >0 && target >= matrix[i][0] && target <=matrix[i][matrix[i].length-1]) {
				index = i;
				break;
			}
		}
		if(index == -1) return false;
		int res = binarySearch(0, matrix[index].length,  matrix[index], target);
		return res >= 0;
	}
	private int binarySearch(int start, int end, int[] nums, int target) {
		if (end < start) {
			return -1;
		}
		int mid = (start + end) / 2;
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] > target) {
			return binarySearch(start, mid - 1, nums, target);
		} else {
			return binarySearch(mid + 1, end, nums, target);
		}
	}
	
	public static void main(String[] args) {
		Search2DMatrix sm = new Search2DMatrix();
		int[][] matrix  = new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}; 
		System.out.println(sm.searchMatrix(matrix, 3));
		
		matrix  = new int[][]{{1, 3, 5, 7},{10, 11, 16, 20},{23, 30, 34, 50}}; 
		System.out.println(sm.searchMatrix(matrix, 13));
		matrix  = new int[][]{{1}}; 
		System.out.println(sm.searchMatrix(matrix, 1));
		
		matrix  = new int[][]{{}}; 
		System.out.println(sm.searchMatrix(matrix, 1));
		
		System.out.println(sm.searchMatrix(new int [][]{}, 0));
		matrix  = new int[][]{{1},{3}}; 
		System.out.println(sm.searchMatrix(matrix, 3));
	}
}
