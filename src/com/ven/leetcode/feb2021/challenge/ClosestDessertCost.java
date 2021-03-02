package com.ven.leetcode.feb2021.challenge;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ClosestDessertCost {
	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		Set<Integer> s = new HashSet<>();
		for (int i = 0; i < baseCosts.length; i++) {
			helper(baseCosts[i], 0, target, toppingCosts, s);
		}
		System.out.println(s);
		int[] arr = s.stream().mapToInt(Integer::intValue).toArray();
		int min = Integer.MIN_VALUE;
		int max = Integer.MAX_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= target) {
				min = Math.max(min, arr[i]);
			} else if (arr[i] > target) {
				max = Math.min(max, arr[i]);
			}
		}

		int absmin = Math.abs(min - target);
		int absmax = Math.abs(max - target);
		if (absmin < absmax) {
			return min;
		} else if (absmax < absmin) {
			return max;
		} else {
			return Math.min(min, max);
		}

	}

	private void helper(int cost, int ind, int target, int[] toppingCosts, Set<Integer> s) {
		s.add(cost);
		for (int i = ind; i < toppingCosts.length; i++) {
			helper(cost + toppingCosts[i], i + 1, target, toppingCosts, s);
			helper(cost + (2 * toppingCosts[i]), i + 1, target, toppingCosts, s);
		}
	}

	public static void main(String[] args) {
		ClosestDessertCost c = new ClosestDessertCost();

		System.out.println(c.closestCost(new int[] { 2, 3 }, new int[] { 4, 5, 100 }, 18));
	}
}
