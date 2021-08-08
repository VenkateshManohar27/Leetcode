package com.ven.leetcode.aug2021.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums that may contain duplicates, return all possible
 * subsets (the power set).
 * 
 * The solution set must not contain duplicate subsets. Return the solution in
 * any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,2] Output: [[],[1],[1,2],[1,2,2],[2],[2,2]] Example 2:
 * 
 * Input: nums = [0] Output: [[],[0]]
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 10 -10 <= nums[i] <= 10
 * 
 * @author Venkatesh Manohar
 *
 */
public class SubsetsII {
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
}
