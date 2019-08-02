package com.ven.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array nums of n integers and an integer target, find three integers
 * in nums such that the sum is closest to target. Return the sum of the three
 * integers. You may assume that each input would have exactly one solution.
 * 
 * Example:
 * 
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * @author Venkatesh Manohar
 *
 */
public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		int closest = 0, diff = Integer.MAX_VALUE;
		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int left = i + 1;
			int right = nums.length - 1;
			while (right > left) {
				int currsum = nums[right] + nums[left] + nums[i];
				if (currsum == target) {
					return target;
				} else if (currsum < target) {
					left++;
				} else {
					right--;
				}
				if (Math.abs(target - currsum) < diff) {
					diff = Math.abs(target - currsum);
					closest = currsum;
				}
			}

		}

		return closest;
	}
}
