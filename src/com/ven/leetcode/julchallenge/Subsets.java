package com.ven.leetcode.julchallenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/***
 * Given a set of distinct integers,nums,return all possible subsets(the*power
 * set).**Note:The solution set must not contain duplicate
 * subsets.**Example:**Input:nums=[1,2,3]Output:[[3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],*[]]**
 * 
 * @author Venkatesh Manohar
 *
 */
public class Subsets {
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> li = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return li;
		}
		generate(0, nums, new ArrayList<>(), li);
		return li;
	}

	private void generate(int index, int[] nums, ArrayList<Integer> list, List<List<Integer>> subsets) {

		subsets.add(new ArrayList<>(list));

		for (int i = index; i < nums.length; i++) {
			 if(i>index && nums[i-1]==nums[i]) { 
				continue;
			}
			list.add(nums[i]);
			
			generate(i + 1, nums, list, subsets);
			list.remove(list.size() - 1);
		}

	}

	public static void main(String[] args) {
		Subsets s = new Subsets();
		System.out.println(s.subsets(null));
		System.out.println(s.subsets(new int[] {}));
		System.out.println(s.subsets(new int[] { 1 }));

		System.out.println(s.subsets(new int[] { 1, 2 }));
		System.out.println(s.subsets(new int[] { 1, 2, 3 }));
		System.out.println(s.subsets(new int[] { 1, 2, 3, 4 }));

	}
}
