package com.ven.leetcode.dec.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the
 * matrix in any order.
 * 
 * A lucky number is an element of the matrix such that it is the minimum
 * element in its row and maximum in its column.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]] Output: [15] Explanation: 15
 * is the only lucky number since it is the minimum in its row and the maximum
 * in its column Example 2:
 * 
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]] Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row
 * and the maximum in its column. Example 3:
 * 
 * Input: matrix = [[7,8],[1,2]] Output: [7]
 * 
 * 
 * Constraints:
 * 
 * m == mat.length n == mat[i].length 1 <= n, m <= 50 1 <= matrix[i][j] <= 10^5.
 * All elements in the matrix are distinct.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LuckyNumbersMatrix {
	public List<Integer> luckyNumbers (int[][] matrix) {
        int[] rowMin = new int[matrix.length];
        Arrays.fill(rowMin, Integer.MAX_VALUE);
        int[] colMax = new int[matrix[0].length];
        Arrays.fill(colMax, Integer.MIN_VALUE);
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                rowMin[i] = Math.min(rowMin[i], matrix[i][j]);
                colMax[j] = Math.max(colMax[j], matrix[i][j]);
            }
        }
        
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < rowMin.length; i++){
            for(int j = 0; j < colMax.length; j++){
                if(rowMin[i] == colMax[j]){
                    l.add(rowMin[i]);
                }
            }
        }
        return l;
    }
}
