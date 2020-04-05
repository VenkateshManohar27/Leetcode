package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct integers, return all possible permutations.
 * 
 * Example:
 * 
 * Input: [1,2,3] Output: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1]
 * ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<List<Integer>>();
		if (nums == null || nums.length == 0) {
			return permutations;
		}
		
		helper(new ArrayList<>(), permutations, nums);
		return permutations;
	}

	private void helper(ArrayList<Integer> list, List<List<Integer>> permutations, int[] nums) {
		if(list.size() == nums.length) {
			permutations.add(new ArrayList<>(list));
			return;
		}
		for (int i = 0 ; i <=list.size(); i++) {
			list.add(i, nums[list.size()]);
			helper(list, permutations, nums);
			list.remove(i);
		}
	}
	
	public static void main(String[] args) {
		Permutations p = new Permutations();
		System.out.println(p.permute(null));
		System.out.println(p.permute(new int[] {1}));
		System.out.println(p.permute(new int[] {1,2}));
		System.out.println(p.permute(new int[] {1,2,3}));
		
	}
}
