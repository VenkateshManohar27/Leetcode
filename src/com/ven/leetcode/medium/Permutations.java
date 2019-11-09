package com.ven.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/*
	 * public List<List<Integer>> permute(int[] nums) { List<List<Integer>> list =
	 * new ArrayList<>(); if (nums == null || nums.length == 0) return list;
	 * backtrack(list, new ArrayList<>(), nums); return list; }
	 * 
	 * private void backtrack(List<List<Integer>> list, List<Integer> tempList,
	 * int[] nums) { if (tempList.size() == nums.length) { list.add(new
	 * ArrayList<>(tempList)); } else { for (int i = 0; i <= tempList.size(); i++) {
	 * tempList.add(i, nums[tempList.size()]); System.out.println("i:"+i);
	 * System.out.println(tempList); backtrack(list, tempList, nums);
	 * tempList.remove(i); System.out.println(tempList); } } }
	 */

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return permutations;
		}
		helper(nums, new ArrayList<>(), permutations);
		return permutations;
	}

	private void helper(int[] nums, ArrayList<Integer> tempList, List<List<Integer>> permutations) {
		if (tempList.size() == nums.length) {
			permutations.add(new ArrayList<>(tempList));
			return;
		}
		for (int i = 0; i <= tempList.size(); i++) {
			tempList.add(i, nums[tempList.size()]);
			helper(nums, tempList, permutations);
			tempList.remove(i);
		}
	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[] { 1, 2, 3 }));
	}

}
