package com.vm.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combinations = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		helper(candidates, 0, target, new ArrayList<>(), combinations);
		return combinations;
	}

	private void helper(int[] candidates, int sum, int target, List<Integer> combination,
			List<List<Integer>> combinations) {
		if (sum == target) {
			combinations.add(new ArrayList<>(combination));
			return;
		}

		if (sum < target) {
			for (int i = 0; i < candidates.length; i++) {
				if (!combination.isEmpty() && !(combination.get(combination.size() - 1) <= candidates[i])) {
					continue;
				}
				combination.add(candidates[i]);
				helper(candidates, sum + candidates[i], target, combination, combinations);
				combination.remove(combination.size() - 1);
			}
		}

	}

	public static void main(String[] args) {
		CombinationSum cs = new CombinationSum();
		System.out.println(cs.combinationSum(new int[] { 2, 3, 5 }, 8));
		System.out.print(cs.combinationSum(new int[] { 2, 3, 6, 7 }, 7));
	}
}
