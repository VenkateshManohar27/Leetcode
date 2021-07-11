package com.ven.leetcode.jul2021.challenge;

import java.util.Arrays;

/**
 * Given an n x n matrix where each of the rows and columns are sorted in
 * ascending order, return the kth smallest element in the matrix.
 * 
 * Note that it is the kth smallest element in the sorted order, not the kth
 * distinct element.
 * 
 * Example 1:
 * 
 * Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8 Output: 13
 * Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and
 * the 8th smallest number is 13 Example 2:
 * 
 * Input: matrix = [[-5]], k = 1 Output: -5
 * 
 * Constraints:
 * 
 * n == matrix.length n == matrix[i].length 1 <= n <= 300 -109 <= matrix[i][j]
 * <= 109 All the rows and columns of matrix are guaranteed to be sorted in
 * non-decreasing order. 1 <= k <= n2
 * 
 * @author Venkatesh Manohar
 *
 */
public class KthSmallestElementSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int[] a = new int[n*n];
        int index = 0;
        for(int i = 0; i < n; i++){
           for(int j = 0; j < n; j++){
                a[index++]= matrix[i][j];
           }
        }
        Arrays.sort(a);
        return a[k-1];
    }
}
