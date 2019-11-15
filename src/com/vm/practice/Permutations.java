package com.vm.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> p = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return p;
		}
		helper(new ArrayList<Integer>(), nums, p);
		return p;
	}

	private void helper(ArrayList<Integer> tempList, int[] nums, List<List<Integer>> p) {
		if (tempList.size() == nums.length) {
			p.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = 0; i <= tempList.size(); i++) {
			tempList.add(i, nums[tempList.size()]);
			helper(tempList, nums, p);
			tempList.remove(i);
		}
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[] { 1, 2, 3 }));
	}
}
