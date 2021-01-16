package com.ven.leetcode.jan2021.challenge;

import java.util.HashMap;

public class MinimumOperationstoReduceXtoZero {
	public int minOperations(int[] nums, int x) {
		HashMap<Integer, Integer> m = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			m.put(sum, i);
		}
		m.put(0, -1);
		if (sum == x)
			return nums.length;
		int min = Integer.MAX_VALUE;
		int curr = 0;
		for (int i = nums.length - 1; i >= 0; i--) {

			int target = x - curr;
			// System.out.println("target:" + target);
			// System.out.println("curr:" + curr);
			if (m.containsKey(target)) {
				int index = m.get(target);
				// System.out.println("index:" + index);
				// System.out.println("i:" + i);
				if (index < i) {
					min = Math.min(min, nums.length - (i - index));
				}
			}
			curr += nums[i];
		}

		return (min == Integer.MAX_VALUE) ? -1 : min;
	}

	public static void main(String[] args) {
		MinimumOperationstoReduceXtoZero m = new MinimumOperationstoReduceXtoZero();
		System.out.println(m.minOperations(new int[] { 1, 1, 4, 2, 3 }, 5));
		System.out.println(m.minOperations(new int[] { 3, 2, 20, 1, 1, 3 }, 10));
		System.out.println(m.minOperations(new int[] { 5, 2, 3, 1, 1 }, 5));
	}
}
