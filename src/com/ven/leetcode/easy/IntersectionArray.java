package com.ven.leetcode.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2] Output: [2] Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4] Output: [9,4] Note:
 * 
 * Each element in the result must be unique. The result can be in any order.
 * 
 * @author Venkatesh Manohar
 *
 */
public class IntersectionArray {
	public int[] intersection(int[] nums1, int[] nums2) {
		Set<Integer> s = new HashSet<Integer>();
		Set<Integer> intersection = new HashSet<Integer>();
		boolean isNums1Larger = nums1.length > nums2.length;
		populateSet(isNums1Larger ? nums2 : nums1, s);
		int[] larger = isNums1Larger ? nums1 : nums2;
		for (int num : larger) {
			if (s.contains(num)) {
				intersection.add(num);
			}
		}
		return intersection.stream().mapToInt(Number::intValue).toArray();
	}

	private void populateSet(int[] nums, Set<Integer> s) {
		for (int num : nums) {
			s.add(num);
		}
	}

	public int[] set_intersection(HashSet<Integer> set1, HashSet<Integer> set2) {
		int[] output = new int[set1.size()];
		int idx = 0;
		for (Integer s : set1)
			if (set2.contains(s))
				output[idx++] = s;

		return Arrays.copyOf(output, idx);
	}

	public int[] intersectionOptimized(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (int n : nums1) {
			set1.add(n);
		}

		HashSet<Integer> set2 = new HashSet<Integer>();
		for (int n : nums2) {
			set2.add(n);
		}
		if (set1.size() < set2.size()) {
			return set_intersection(set1, set2);
		} else {
			return set_intersection(set2, set1);
		}

	}
}
