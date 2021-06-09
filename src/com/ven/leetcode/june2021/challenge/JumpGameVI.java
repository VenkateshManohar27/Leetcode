package com.ven.leetcode.june2021.challenge;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * You are given a 0-indexed integer array nums and an integer k.
 * 
 * You are initially standing at index 0. In one move, you can jump at most k
 * steps forward without going outside the boundaries of the array. That is, you
 * can jump from index i to any index in the range [i + 1, min(n - 1, i + k)]
 * inclusive.
 * 
 * You want to reach the last index of the array (index n - 1). Your score is
 * the sum of all nums[j] for each index j you visited in the array.
 * 
 * Return the maximum score you can get.
 * 
 * Example 1:
 * 
 * Input: nums = [1,-1,-2,4,-7,3], k = 2 Output: 7 Explanation: You can choose
 * your jumps forming the subsequence [1,-1,4,3] (underlined above). The sum is
 * 7. Example 2:
 * 
 * Input: nums = [10,-5,-2,4,0,3], k = 3 Output: 17 Explanation: You can choose
 * your jumps forming the subsequence [10,4,3] (underlined above). The sum is
 * 17. Example 3:
 * 
 * Input: nums = [1,-5,-20,4,-1,3,-6,-3], k = 2 Output: 0
 * 
 * Constraints:
 * 
 * 1 <= nums.length, k <= 105 -104 <= nums[i] <= 104
 * 
 * @author Venkatesh Manohar
 *
 */
public class JumpGameVI {
	public int maxResultPQ(int[] nums, int k) {
		int[] dp = new int[nums.length];
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);

		pq.offer(new int[] { 0, nums[0] });
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			while (!pq.isEmpty() && (i - pq.peek()[0]) > k) // Ensure deque's size doesn't exceed k
				pq.poll();

			dp[i] = pq.peek()[1] + nums[i];

			pq.offer(new int[] { i, dp[i] });

		}

		return dp[dp.length - 1];
	}

	public int maxResultDQ(int[] nums, int k) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		Deque<int[]> queue = new ArrayDeque<>();
		queue.addLast(new int[] { 0, dp[0] });

		for (int i = 1; i < nums.length; i++) {
			// remove all elements that more than k dist away
			while (queue.peekFirst()[0] < i - k) {
				queue.pollFirst();
			}
			// first element in the queue is always the max element
			dp[i] = queue.peekFirst()[1] + nums[i];
			// System.out.println(Arrays.toString(dp));
			// remove all elements from right that are smaller than cur element,
			// since they can never be used as max
			while (!queue.isEmpty() && queue.peekLast()[1] < dp[i]) {
				queue.pollLast();
			}
			queue.addLast(new int[] { i, dp[i] });
		}

		return dp[nums.length - 1];
	}

	public int maxResultDQ1(int[] nums, int k) {
		int dp[] = new int[nums.length];
		dp[0] = nums[0];
		Deque<Integer> queue = new ArrayDeque<>();
		queue.addLast(0);

		for (int i = 1; i < nums.length; i++) {
			// remove all elements that more than k dist away
			while (queue.peekFirst() < i - k) {
				queue.pollFirst();
			}
			// first element in the queue is always the max element
			dp[i] = dp[queue.peekFirst()] + nums[i];
			// System.out.println(Arrays.toString(dp));
			// remove all elements from right that are smaller than cur element,
			// since they can never be used as max
			while (!queue.isEmpty() && dp[queue.peekLast()] < dp[i]) {
				queue.pollLast();
			}
			queue.addLast(i);
		}

		return dp[nums.length - 1];
	}

	public static void main(String[] args) {
		JumpGameVI j = new JumpGameVI();
		System.out.println(j.maxResultPQ(new int[] { 10, -5, -2, 4, 0, 3 }, 3));
		System.out.println(j.maxResultPQ(new int[] { 1, -1, -2, 4, -7, 3 }, 2));
		System.out.println(j.maxResultPQ(new int[] { 1, -5, -20, 4, -1, 3, -6, -3 }, 2));
		System.out.println(j.maxResultDQ(new int[] { 10, -5, -2, 4, 0, 3 }, 3));
		System.out.println(j.maxResultDQ(new int[] { 1, -1, -2, 4, -7, 3 }, 2));
		System.out.println(j.maxResultDQ(new int[] { 1, -5, -20, 4, -1, 3, -6, -3 }, 2));
		
		System.out.println(j.maxResultDQ1(new int[] { 10, -5, -2, 4, 0, 3 }, 3));
		System.out.println(j.maxResultDQ1(new int[] { 1, -1, -2, 4, -7, 3 }, 2));
		System.out.println(j.maxResultDQ1(new int[] { 1, -5, -20, 4, -1, 3, -6, -3 }, 2));

	}
}
