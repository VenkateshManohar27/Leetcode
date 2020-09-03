package com.ven.leetcode.sepchallenge;

import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1], k = 3, t = 0 Output: true Example 2:
 * 
 * Input: nums = [1,0,1,1], k = 1, t = 2 Output: true Example 3:
 * 
 * Input: nums = [1,5,9,1,5,9], k = 2, t = 3 Output: false
 * 
 * @author Venkatesh Manohar
 *
 */
public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int n = nums.length;
		if (n <= 1 || t < 0) {
			return false;
		}

		TreeSet<Integer> set = new TreeSet<>();
		for (int i = 0; i < n; i++) {
			if (i > k) {
				set.remove(nums[i - k - 1]);
			}
			if (!set.add(nums[i]))
				return true;
			if (set.lower(nums[i]) != null && (long) nums[i] - set.lower(nums[i]) <= t)
				return true;
			if (set.higher(nums[i]) != null && set.higher(nums[i]) - (long) nums[i] <= t)
				return true;

		}

		return false;
	}

	public static void main(String[] args) {
		ContainsDuplicateIII c = new ContainsDuplicateIII();
		System.out.println(c.containsNearbyAlmostDuplicate(new int[] { 1, 2, 3, 1 }, 3, 0));
		System.out.println(c.containsNearbyAlmostDuplicate(new int[] { 1, 0, 1, 1 }, 1, 2));
		System.out.println(c.containsNearbyAlmostDuplicate(new int[] { 1, 5, 9, 1, 5, 9 }, 2, 3));
	}
}
