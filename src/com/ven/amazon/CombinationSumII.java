package com.ven.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return combinations;
		}
		Arrays.sort(candidates);
		helper(candidates, target, 0, 0, new ArrayList<Integer>(), combinations);
		return combinations;
	}

	private void helper(int[] candidates, int target, int sum, int index, ArrayList<Integer> list,
			List<List<Integer>> combinations) {
		if (sum > target) {
			return;
		}
		if (sum == target) {
			combinations.add(new ArrayList<>(list));
			return;
		}

		for (int i = index; i < candidates.length; i++) {
			if (i == index || candidates[i] != candidates[i - 1]) {
				list.add(candidates[i]);
				helper(candidates, target, sum + candidates[i], i + 1, list, combinations);
				list.remove(list.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		CombinationSumII cs = new CombinationSumII();
		System.out.println(cs.combinationSum2(new int[] { 10, 1, 2, 7, 6, 1, 5 }, 8));
	}
}
