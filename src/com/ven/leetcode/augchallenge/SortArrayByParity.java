package com.ven.leetcode.augchallenge;

import com.ven.utility.ArrayUtility;

/**
 * Given an array A of non-negative integers, return an array consisting of all
 * the even elements of A, followed by all the odd elements of A.
 * 
 * You may return any answer array that satisfies this condition.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: [3,1,2,4] Output: [2,4,3,1] The outputs [4,2,3,1], [2,4,1,3], and
 * [4,2,1,3] would also be accepted.
 * 
 * 
 * Note:
 * 
 * 1 <= A.length <= 5000 0 <= A[i] <= 5000
 * 
 * @author Venkatesh Manohar
 *
 */
public class SortArrayByParity {
	public int[] sortArrayByParity(int[] A) {
		int start = 0;
		int end = A.length - 1;

		while (start < end) {
			if (A[start] % 2 > A[end] % 2) {
				swap(A, start, end);
			}
			if (A[start] % 2 == 0)
				start++;
			if (A[end] % 2 == 1)
				end--;
		}

		return A;
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}

	public static void main(String[] args) {
		SortArrayByParity s = new SortArrayByParity();
		ArrayUtility.print(s.sortArrayByParity(new int[] { 3, 1, 2, 4 }));
		ArrayUtility.print(s.sortArrayByParity(new int[] { 3, 1, 2, 4, 5 }));
	}
}
