package com.ven.leetcode.week10;

import java.util.HashMap;
import java.util.Map;

public class MaximumScorefromPerformingMultiplicationOperations {
	Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();

	public int maximumScore(int[] nums, int[] multipliers) {

		return helper(0, nums.length - 1, nums, multipliers, 0);
	}

	private int helper(int start, int end, int[] nums, int[] multipliers, int ind) {
		if (ind >= multipliers.length) {
			return 0;
		}
		if (memo.containsKey(start))
			if (memo.get(start).containsKey(end))
				return memo.get(start).get(end);
		int a = helper(start + 1, end, nums, multipliers, ind + 1) + (nums[start] * multipliers[ind]);
		int b = helper(start, end - 1, nums, multipliers, ind + 1) + (nums[end] * multipliers[ind]);
		if (!memo.containsKey(start))
			memo.put(start, new HashMap<>());
		memo.get(start).put(end, Math.max(a, b));
		return Math.max(a, b);
	}

	public static void main(String[] args) {
		MaximumScorefromPerformingMultiplicationOperations m = new MaximumScorefromPerformingMultiplicationOperations();
		System.out.println(m.maximumScore(new int[] { 1, 2, 3 }, new int[] { 3, 2, 1 }));
		System.out.println(m.maximumScore(new int[] { -5, -3, -3, -2, 7, 1 }, new int[] { -10, -5, 3, 4, 6 }));

		System.out.println(m.maximumScore(
				new int[] { 555, 526, 732, 182, 43, -537, -434, -233, -947, 968, -250, -10, 470, -867, -809, -987, 120,
						607, -700, 25, -349, -657, 349, -75, -936, -473, 615, 691, -261, -517, -867, 527, 782, 939,
						-465, 12, 988, -78, -990, 504, -358, 491, 805, 756, -218, 513, -928, 579, 678, 10 },
				new int[] { 783, 911, 820, 37, 466, -251, 286, -74, -899, 586, 792, -643, -969, -267, 121, -656, 381,
						871, 762, -355, 721, 753, -521 }));
	}
}
