package com.vm.practice;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> permutations = new ArrayList<>();
		if(nums == null || nums.length == 0) {
			return permutations;
		}
		boolean used[] = new boolean[nums.length];
		helper(nums, used, new ArrayList<>(), permutations);
		return permutations;
	}
	
	private void helper(int[] nums, boolean[] used, ArrayList<Integer> li, List<List<Integer>> permutations) {
		if(li.size() == nums.length) {
			
			permutations.add(new ArrayList<>(li));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if(!used[i]) {
				used[i] = true;
				li.add(nums[i]);
				helper(nums, used, li, permutations);
				li.remove(li.size()-1);
				used[i]=false;
			}
		}
		
	}







	public static void main(String[] args) {
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[] { 1, 2, 3 }));
	}
}
