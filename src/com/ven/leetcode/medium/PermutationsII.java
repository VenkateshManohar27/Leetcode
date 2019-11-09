package com.ven.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return permutations;
		}
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		helper(nums, used, new ArrayList<>(), permutations);
		return permutations;
	}

	private void helper(int[] nums, boolean[] used, ArrayList<Integer> tempList, List<List<Integer>> permutations) {
		if (tempList.size() == nums.length) {
			permutations.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
					continue;
				}
				used[i] = true;
				tempList.add(nums[i]);
				helper(nums, used, tempList, permutations);
				tempList.remove(tempList.size() - 1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
		System.out.println(p.permute(new int[] { 1, 1, 3 }));
		
		System.out.println(p.permute(new int[] {3,3,0,3 }));
	}
}
