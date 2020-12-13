package com.ven.leetcode.biweekly41;

import com.ven.utility.ArrayUtility;

/**
 * You are given an integer array nums sorted in non-decreasing order.
 * 
 * Build and return an integer array result with the same length as nums such
 * that result[i] is equal to the summation of absolute differences between
 * nums[i] and all the other elements in the array.
 * 
 * In other words, result[i] is equal to sum(|nums[i]-nums[j]|) where 0 <= j <
 * nums.length and j != i (0-indexed).
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [2,3,5] Output: [4,3,5] Explanation: Assuming the arrays are
 * 0-indexed, then result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4, result[1]
 * = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3, result[2] = |5-2| + |5-3| + |5-5| =
 * 3 + 2 + 0 = 5. Example 2:
 * 
 * Input: nums = [1,4,6,8,10] Output: [24,15,13,15,21]
 * 
 * 
 * Constraints:
 * 
 * 2 <= nums.length <= 105 1 <= nums[i] <= nums[i + 1] <= 104
 * 
 * @author Venkatesh Manohar
 *
 */
public class SumofAbsoluteDifferencesSortedArray {
	public int[] getSumAbsoluteDifferences(int[] nums) {
		int n = nums.length;
		int[] sfx = new int[n];
		int[] pre = new int[n];
		for (int i = 1; i < n; i++) {
			pre[i] = pre[i - 1] + nums[i - 1];
		}

		for (int i = n - 2; i >= 0; i--) {
			sfx[i] = sfx[i + 1] + nums[i + 1];
		}

		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			res[i] = (sfx[i] - (n - i - 1) * nums[i]) + (nums[i] * (i) - pre[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		SumofAbsoluteDifferencesSortedArray s = new SumofAbsoluteDifferencesSortedArray();
		ArrayUtility.print(s.getSumAbsoluteDifferences(new int[] { 2, 3, 5 }));
	}
}
