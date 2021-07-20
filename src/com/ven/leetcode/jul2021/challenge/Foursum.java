package com.ven.leetcode.jul2021.challenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array nums of n integers, return an array of all the unique
 * quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
 * 
 * 0 <= a, b, c, d < n a, b, c, and d are distinct. nums[a] + nums[b] + nums[c]
 * + nums[d] == target You may return the answer in any order.
 * 
 * Example 1:
 * 
 * Input: nums = [1,0,-1,0,-2,2], target = 0 Output:
 * [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]] Example 2:
 * 
 * Input: nums = [2,2,2,2,2], target = 8 Output: [[2,2,2,2]]
 * 
 * Constraints:
 * 
 * 1 <= nums.length <= 200 -109 <= nums[i] <= 109 -109 <= target <= 109
 * 
 * @author Venkatesh Manohar
 *
 */
public class Foursum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> solution = new ArrayList<List<Integer>>();

		if (nums == null || nums.length == 0) {
			return solution;
		}

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			// return immediately if numsi*4>target
			if (nums[i] << 2 > target)
				return solution;
			// traverse max
			for (int j = nums.length - 1; j > i + 2; j--) {
				// break immediately
				if (nums[j] << 2 < target)
					break;
				int rem = target - nums[i] - nums[j];
				int lo = i + 1, hi = j - 1;
				while (lo < hi) {
					int sum = nums[lo] + nums[hi];
					if (sum > rem)
						hi--;
					else if (sum < rem)
						lo++;
					else {
						solution.add(Arrays.asList(nums[i], nums[lo], nums[hi], nums[j]));
						lo++;
						hi--;
						// avoid duplicate results
						while (nums[lo - 1] == nums[lo] && lo < hi)
							lo++;
						while (nums[hi] == nums[hi + 1] && lo < hi)
							hi--;
					}
				}

				while (j > i + 2 && nums[j] == nums[j - 1])
					j--;
			}
			while (i < nums.length - 2 && nums[i] == nums[i + 1])
				i++;
		}
		return solution;
	}
}
