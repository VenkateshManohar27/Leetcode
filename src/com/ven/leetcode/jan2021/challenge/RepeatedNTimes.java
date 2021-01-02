package com.ven.leetcode.jan2021.challenge;

/**
 * In a array A of size 2N, there are N+1 unique elements, and exactly one of
 * these elements is repeated N times.
 * 
 * Return the element repeated N times.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [1,2,3,3] Output: 3 Example 2:
 * 
 * Input: [2,1,2,5,3,2] Output: 2 Example 3:
 * 
 * Input: [5,1,5,2,5,3,5,4] Output: 5
 * 
 * 
 * Note:
 * 
 * 4 <= A.length <= 10000 0 <= A[i] < 10000 A.length is even
 * 
 * @author Venkatesh Manohar
 *
 */
public class RepeatedNTimes {
	public int repeatedNTimes(int[] A) {
		int[] arr = new int[10001];
		// int n = (A.length /2);
		for (int i = 0; i < A.length; i++) {
			arr[A[i]]++;
			if (arr[A[i]] > 1) {
				return A[i];
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		RepeatedNTimes r = new RepeatedNTimes();
		System.out.println(r.repeatedNTimes(new int[] { 1, 2, 3, 3 }));
		System.out.println(r.repeatedNTimes(new int[] { 2, 1, 2, 5, 3, 2 }));
		System.out.println(r.repeatedNTimes(new int[] { 5, 1, 5, 2, 5, 3, 5, 4 }));
	}
}
