package com.ven.leetcode.dec.challenge;

import java.util.Arrays;

/**
 * Given an array A of integers, for each integer A[i] we need to choose either
 * x = -K or x = K, and add x to A[i] (only once).
 * 
 * After this process, we have some array B.
 * 
 * Return the smallest possible difference between the maximum value of B and
 * the minimum value of B.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1], K = 0 Output: 0 Explanation: B = [1] Example 2:
 * 
 * Input: A = [0,10], K = 2 Output: 6 Explanation: B = [2,8] Example 3:
 * 
 * Input: A = [1,3,6], K = 3 Output: 3 Explanation: B = [4,6,3]
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 10000 0 <= A[i] <= 10000 0 <= K <= 10000
 * 
 * @author Venkatesh Manohar
 *
 */
public class SmallestRangeII {
	public int smallestRangeII(int[] A, int K) {
        int n = A.length;
       if(n==1){
           return 0;
       }
       Arrays.sort(A);
       int ans = A[n-1] - A[0];
       int left = A[0] + K;
       int right = A[n-1] - K;
       for (int i = 0; i < A.length - 1; ++i) {
           int a = A[i], b = A[i+1];
           int high = Math.max(right, a + K);
           int low = Math.min(left, b - K);
           ans = Math.min(ans, high - low);
       }
       return ans;
   }

}
