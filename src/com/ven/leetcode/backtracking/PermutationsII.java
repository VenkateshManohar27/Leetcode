package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * Example:
 * 
 * Input: [1,1,2] Output: [ [1,1,2], [1,2,1], [2,1,1] ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return permutations;
		}
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		helper(new ArrayList<>(), nums, used, permutations);
		return permutations;
	}

	private void helper(ArrayList<Integer> list, int[] nums, boolean[] used, List<List<Integer>> permutations) {
		if (list.size() == nums.length) {
			permutations.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0; i <nums.length; i++) {
			if (!used[i]) {
				if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
					continue;
				}
				used[i] = true;
				list.add(nums[i]);
				helper(list, nums, used, permutations);
				list.remove(list.size()-1);
				used[i] = false;
			}

		}
	}

	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
		System.out.println(p.permuteUnique(null));
		System.out.println(p.permuteUnique(new int[] { 1 }));
		System.out.println(p.permuteUnique(new int[] { 1, 2 }));
		System.out.println(p.permuteUnique(new int[] { 1, 2, 3 }));
		System.out.println(p.permuteUnique(new int[] { 1, 1, 3 }));
	}
}
