package com.ven.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given an array nums of n integers, are there elements a, b, c in nums such
 * that a + b + c = 0? Find all unique triplets in the array which gives the sum
 * of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		HashSet<String> h = new HashSet<>();

		for (int i = 0; i < nums.length; i++) {
			int num1 = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				int num2 = nums[j];
				int num3 = -(num1 + num2);
				int found = Arrays.binarySearch(nums, j + 1, nums.length, num3);
				if (found >= 0 && num1 + num2 + nums[found] == 0) {
					String numbers = "" + num1 + num2 + nums[found];
					if (h.contains(numbers)) {
						continue;
					}
					List<Integer> list = new ArrayList<>();
					list.add(num1);
					list.add(num2);
					list.add(nums[found]);
					result.add(list);
					h.add(numbers);
				}
			}
		}
		return result;

	}

	public static void main(String[] args) {
		ThreeSum ts = new ThreeSum();

		System.out.println(ts.threeSum(new int[] { -1, 0, 1, 2, -1, -4 }));
	}
}
