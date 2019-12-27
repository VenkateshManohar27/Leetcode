package com.vm.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return permutations;
		}
		helper(nums, new ArrayList<Integer>(), permutations);

		return permutations;
	}

	private void helper(int[] nums, ArrayList<Integer> list, List<List<Integer>> permutations) {
		if (nums.length == list.size()) {
			permutations.add(new ArrayList<>(list));
			return;
		}

		for (int i = 0; i <= list.size(); i++) {
			list.add(i, nums[list.size()]);
			helper(nums, list, permutations);
			list.remove(i);
		}

	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[] { 1, 2, 3 }));
	}
}
