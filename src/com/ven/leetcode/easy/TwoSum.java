package com.ven.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

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
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}

			map.put(nums[i], i);
		}
		return new int[0];
	}

	public int[] twoSumBinSearch(int[] numbers, int target) {
		if (numbers == null || numbers.length == 0)
			return null;
		for (int i = 0; i < numbers.length; i++) {
			int num2 = target - numbers[i];
			int found = Arrays.binarySearch(numbers, i + 1, numbers.length, num2);
			if (found >= 0) {
				return new int[] { i + 1, found + 1 };
			}
		}
		return null;
	}
}
