package com.ven.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
//NOT SOLVED YET

public class SubsetSumIncomplete {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		HashSet<String> set = new HashSet<>();
		Arrays.sort(nums);
		sum(nums, 0, 0, 0,target, new ArrayList<Integer>(), set, result);
		return result;
	}

	/*private void sum(int[] nums, int currSum, int index, int count, int target, List<Integer> currList,
			HashSet<String> set, List<List<Integer>> result) {

		if (currSum == target && count == 4 && currList.size()>0) {
			if(set.contains(currList.toString())) {
				return;
			}
			result.add(currList);
			set.add(currList.toString());
			return;
			//return true;
		}

		if (count >= 4 || index >= nums.length) {
			return;
			//return false;
		}

		List<Integer> cloneList = new ArrayList<Integer>(currList);
		//List<Integer> cloneList2 = new ArrayList<Integer>(currList);
		cloneList.add(nums[index]);
		if (sum(nums, currSum + nums[index], index + 1, target, cloneList1, result)) {

			return true;
		}
		sum(nums, currSum + nums[index], index + 1, count+1, target, cloneList, set, result);
		if (sum(nums, currSum, index + 1, target, cloneList2, result)) {

			return true;
		}
		sum(nums, currSum, index + 1, count, target, currList, set, result);
		return;
	}*/

	public static void main(String[] args) {
		SubsetSumIncomplete ss = new SubsetSumIncomplete();
		//List<List<Integer>> result = ss.sum(new int[] { 5, 10, 12, 13, 15, 18 }, 30);
		//System.out.println(result);
		List<List<Integer>> result  = ss.fourSum(new int[] { 1, 0, -1, 0, -2, 2 }, 0);
		System.out.println(result);
	}
}
