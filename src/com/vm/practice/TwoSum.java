package com.vm.practice;

import java.util.HashMap;

import com.ven.utility.ArrayUtility;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 * 
 * @author Venkatesh Manohar
 *
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> complement = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if(complement.containsKey(target - nums[i])) {
				return new int[] {complement.get(target - nums[i]), i};
			}else {
				complement.put(nums[i], i);
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] res = ts.twoSum(new int[] {2, 7, 11, 15}, 9);
		ArrayUtility.print(res);
		
	}
}
