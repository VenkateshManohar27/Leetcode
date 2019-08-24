package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * Example:
 * 
 * Input: [1,2,2] Output: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class SubSetsII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<List<Integer>>();
		if(nums == null || nums.length ==0) {
			return subsets;
		}
		Arrays.sort(nums);
		generate(0, nums, new ArrayList<>(),subsets);
		return subsets;
	}

	private void generate(int index, int[] nums, ArrayList<Integer> list, List<List<Integer>> subsets) {
		subsets.add(new ArrayList<>(list));
		
		for (int i = index; i < nums.length; i++) {
			if(i>index && nums[i-1]==nums[i]) {
				continue;
			}
			list.add(nums[i]);
			generate(i+1, nums, list, subsets);
			list.remove(list.size()-1);
		}
		
	}

	public static void main(String[] args) {
		SubSetsII ss = new SubSetsII();
		System.out.println(ss.subsetsWithDup(new int[] { 1, 2, 3 }));
		System.out.println(ss.subsetsWithDup(new int[] { 1, 1, 3 }));
		System.out.println(ss.subsetsWithDup(new int[] { 1, 1, 2 }));
		System.out.println(ss.subsetsWithDup(new int[] { 4,4,4,1,4}));
	}

}
