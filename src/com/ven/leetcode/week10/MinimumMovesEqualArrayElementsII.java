package com.ven.leetcode.week10;

import java.util.Arrays;

/**
 * Given a non-empty integer array, find the minimum number of moves required to
 * make all array elements equal, where a move is incrementing a selected
 * element by 1 or decrementing a selected element by 1.
 * 
 * You may assume the array's length is at most 10,000.
 * 
 * Example:
 * 
 * Input: [1,2,3]
 * 
 * Output: 2
 * 
 * Explanation: Only two moves are needed (remember each move increments or
 * decrements one element):
 * 
 * [1,2,3] => [2,2,3] => [2,2,2]
 * 
 * @author Venkatesh Manohar
 *
 */
public class MinimumMovesEqualArrayElementsII {
	public int minMoves2(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return 0;
		}
		int n = nums.length;
		Arrays.sort(nums);
		if (n % 2 == 0) {
			int mid = nums[n / 2];
			int res = 0;
			for (int i = 0; i < nums.length; i++) {
				res += Math.abs(nums[i] - mid);
			}

			return res;
		} else {
			int total1 = 0;
			int total2 = 0;
			int mid1 = nums[n / 2];
			int mid2 = nums[(n / 2) - 1];

			for (int i = 0; i < nums.length; i++) {
				total1 += Math.abs(nums[i] - mid1);
				total2 += Math.abs(nums[i] - mid2);
			}

			return Math.min(total1, total2);
		}
	}

	public static void main(String[] args) {
		MinimumMovesEqualArrayElementsII m = new MinimumMovesEqualArrayElementsII();
		System.out.println(m.minMoves2(new int[] { 1, 2, 3 }));
		System.out.println(m.minMoves2(new int[] { 1, 2, 3, 4 }));
	}
}
