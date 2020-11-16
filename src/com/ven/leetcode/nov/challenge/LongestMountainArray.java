package com.ven.leetcode.nov.challenge;

/**
 * Let's call any (contiguous) subarray B (of A) a mountain if the following
 * properties hold:
 * 
 * B.length >= 3 There exists some 0 < i < B.length - 1 such that B[0] < B[1] <
 * ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1] (Note that B could be any
 * subarray of A, including the entire array A.)
 * 
 * Given an array A of integers, return the length of the longest mountain.
 * 
 * Return 0 if there is no mountain.
 * 
 * Example 1:
 * 
 * Input: [2,1,4,7,3,2,5] Output: 5 Explanation: The largest mountain is
 * [1,4,7,3,2] which has length 5. Example 2:
 * 
 * Input: [2,2,2] Output: 0 Explanation: There is no mountain. Note:
 * 
 * 0 <= A.length <= 10000 0 <= A[i] <= 10000 Follow up:
 * 
 * Can you solve it using only one pass? Can you solve it in O(1) space?
 * 
 * @author Venkatesh Manohar
 *
 */
public class LongestMountainArray {
	public int longestMountain(int[] A) {
		int maxLength = 1;
		int length = 1;
		boolean up = false;
		boolean down = false;
		int l = 0, r = 1;
		while (r < A.length) {
			while (r < A.length && A[r] > A[r - 1]) {
				up = true;
				r++;
			}
			while (r < A.length && A[r] < A[r - 1]) {
				down = true;
				r++;
			}
			if (up && down) {
				maxLength = Math.max(maxLength, r - l);
			}
			up = down = false;
			while (r < A.length && A[r] == A[r - 1]) {
				r++;
			}
			l = r - 1;
		}

		return (maxLength > 1) ? maxLength : 0;
	}

	public static void main(String[] args) {
		LongestMountainArray l = new LongestMountainArray();
		System.out.println(l.longestMountain(new int[] {2,1,4,7,3,2,5}));
		System.out.println(l.longestMountain(new int[] {2,2,2,2}));
		System.out.println(l.longestMountain(new int[] {1,2,3,4,5,4,3,2,1,5}));
		System.out.println(l.longestMountain(new int[] {9,8,7,6,5,2,2,2}));
	}
}
