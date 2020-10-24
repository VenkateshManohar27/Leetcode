package com.ven.leetcode.oct.challenge;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of n integers nums, a 132 pattern is a subsequence of three
 * integers nums[i], nums[j] and nums[k] such that i < j < k and nums[i] <
 * nums[k] < nums[j].
 * 
 * Return true if there is a 132 pattern in nums, otherwise, return false.
 * 
 * Follow up: The O(n^2) is trivial, could you come up with the O(n logn) or the
 * O(n) solution?
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: false Explanation: There is no 132 pattern in
 * the sequence. Example 2:
 * 
 * Input: nums = [3,1,4,2] Output: true Explanation: There is a 132 pattern in
 * the sequence: [1, 4, 2]. Example 3:
 * 
 * Input: nums = [-1,3,2,0] Output: true Explanation: There are three 132
 * patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 * 
 * 
 * Constraints:
 * 
 * n == nums.length 1 <= n <= 104 -109 <= nums[i] <= 109
 * 
 * @author Venkatesh Manohar
 *
 */
public class Pattern132 {
	public boolean find132pattern(int[] nums) {
		if (nums == null || nums.length < 3)
			return false;

		int[] minArr = new int[nums.length];
		Deque<Integer> stack = new ArrayDeque<>();
		minArr[0] = nums[0];
		stack.push(nums[nums.length - 1]);
		for (int i = 1; i < nums.length; i++)
			minArr[i] = Math.min(nums[i], minArr[i - 1]);

		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > minArr[i]) {

				while (!stack.isEmpty() && stack.peek() <= minArr[i])
					stack.pop();

				if (!stack.isEmpty() && stack.peek() < nums[i])
					return true;
				else
					stack.push(nums[i]);
			}
		}

		return false;
	}

	public static void main(String[] args) {
		Pattern132 p = new Pattern132();
		System.out.println(p.find132pattern(new int[] { 4, 1, 3, 2 }));
		System.out.println(p.find132pattern(new int[] { 3, 5, 0, 3, 4 }));
	}
}
