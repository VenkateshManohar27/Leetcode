package com.ven.leetcode.dec.challenge;

/**
 * Given an array A of 0s and 1s, we may change up to K values from 0 to 1.
 * 
 * Return the length of the longest (contiguous) subarray that contains only 1s.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2 Output: 6 Explanation:
 * [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1. The longest
 * subarray is underlined. Example 2:
 * 
 * Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3 Output: 10
 * Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] Bolded numbers were
 * flipped from 0 to 1. The longest subarray is underlined.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 20000 0 <= K <= A.length A[i] is 0 or 1
 * 
 * @author Venkatesh Manohar
 *
 */
public class MaxConsecutiveOnesIII {
	public int longestOnes(int[] A, int K) {
		int max = 0;
		int start = 0, end = 0;
		int c = K;
		while (end < A.length) {
			// System.out.println(end +" A[end]:"+A[end]);
			if (A[end] == 1) {
				end++;
			} else if (A[end] == 0 && c > 0) {
				end++;
				c--;
			} else {
				start++;
				if (A[start - 1] == 0 && c < K) {
					c++;
				}
			}
			// System.out.println("end:"+end +" , start:"+start);
			if (start > end)
				end = start;
			max = Math.max(max, end - start);
		}
		return max;
	}
}
