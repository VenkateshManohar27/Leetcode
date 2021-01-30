package com.ven.leetcode.jan2021.challenge;

import java.util.PriorityQueue;

/**
 * You are given an array nums of n positive integers.
 * 
 * You can perform two types of operations on any element of the array any
 * number of times:
 * 
 * If the element is even, divide it by 2. For example, if the array is
 * [1,2,3,4], then you can do this operation on the last element, and the array
 * will be [1,2,3,2]. If the element is odd, multiply it by 2. For example, if
 * the array is [1,2,3,4], then you can do this operation on the first element,
 * and the array will be [2,2,3,4]. The deviation of the array is the maximum
 * difference between any two elements in the array.
 * 
 * Return the minimum deviation the array can have after performing some number
 * of operations.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,4] Output: 1 Explanation: You can transform the array to
 * [1,2,3,2], then to [2,2,3,2], then the deviation will be 3 - 2 = 1. Example
 * 2:
 * 
 * Input: nums = [4,1,5,20,3] Output: 3 Explanation: You can transform the array
 * after two operations to [4,2,5,5,3], then the deviation will be 5 - 2 = 3.
 * Example 3:
 * 
 * Input: nums = [2,10,8] Output: 3
 * 
 * 
 * Constraints:
 * 
 * n == nums.length 2 <= n <= 105 1 <= nums[i] <= 109
 * 
 * @author Venkatesh Manohar
 *
 */
public class MinimizeDeviationArray {
	public int minimumDeviation(int[] nums) {
		PriorityQueue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
		int min = Integer.MAX_VALUE;
		for (int n : nums) {
			if(n % 2 == 1) {
				n *=2;
			}
			q.offer(n);
			min = Math.min(min, n);
		}
		int res = q.peek() - min;
		while(!q.isEmpty() && q.peek() % 2 == 0) {
			int n = q.poll();
			n /= 2;
			q.offer(n);
			min = Math.min(min, n);
			res = Math.min(res, q.peek() - min);
		}
		return res;
	}

	public static void main(String[] args) {
		MinimizeDeviationArray m = new MinimizeDeviationArray();
		System.out.println(m.minimumDeviation(new int[] { 1, 2, 3, 4 }));
		System.out.println(m.minimumDeviation(new int[] { 4, 1, 5, 20, 3 }));
		System.out.println(m.minimumDeviation(new int[] { 2, 10, 8 }));
	}
}
