package com.ven.leetcode.nov.challenge;

import java.util.ArrayDeque;

import com.ven.utility.ArrayUtility;

/**
 * You are given an array of integers nums, there is a sliding window of size k
 * which is moving from the very left of the array to the very right. You can
 * only see the k numbers in the window. Each time the sliding window moves
 * right by one position.
 * 
 * Return the max sliding window.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3 Output: [3,3,5,5,6,7] Explanation:
 * Window position Max --------------- ----- [1 3 -1] -3 5 3 6 7 3 1 [3 -1 -3] 5
 * 3 6 7 3 1 3 [-1 -3 5] 3 6 7 5 1 3 -1 [-3 5 3] 6 7 5 1 3 -1 -3 [5 3 6] 7 6 1 3
 * -1 -3 5 [3 6 7] 7 Example 2:
 * 
 * Input: nums = [1], k = 1 Output: [1] Example 3:
 * 
 * Input: nums = [1,-1], k = 1 Output: [1,-1] Example 4:
 * 
 * Input: nums = [9,11], k = 2 Output: [11] Example 5:
 * 
 * Input: nums = [4,-2], k = 2 Output: [4]
 * 
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 105 -104 <= nums[i] <= 104 1 <= k <= nums.length
 * 
 * @author Venkatesh Manohar
 *
 */
public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		if (nums == null || k <= 0)
			return new int[0];
		int[] res = new int[nums.length - k + 1];
		ArrayDeque<Integer> deque = new ArrayDeque<Integer>();

		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!deque.isEmpty() && deque.peek() < i - k + 1) // Ensure deque's size doesn't exceed k
				deque.poll();

			// Remove numbers smaller than a[i] from right(a[i-1]) to left, to make the
			// first number in the deque the largest one in the window
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
				deque.pollLast();

			deque.offer(i);// Offer the current index to the deque's tail

			if (i >= k - 1)// Starts recording when i is big enough to make the window has k elements
				res[index++] = nums[deque.peek()];
		}
		return res;
	}

	public static void main(String[] args) {
		SlidingWindowMaximum s = new SlidingWindowMaximum();
		ArrayUtility.print(s.maxSlidingWindow(new int[] { 7, 2, 4 }, 2));
	}
}
