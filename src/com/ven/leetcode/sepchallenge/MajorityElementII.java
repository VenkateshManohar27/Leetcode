package com.ven.leetcode.sepchallenge;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer array of size n, find all elements that appear more than n/3
 * times.
 * 
 * Note: The algorithm should run in linear time and in O(1) space.
 * 
 * Example 1:
 * 
 * Input: [3,2,3] Output: [3] Example 2:
 * 
 * Input: [1,1,1,3,3,2,2,2] Output: [1,2]
 * 
 * @author Venkatesh Manohar
 *
 */
public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		List<Integer> li = new ArrayList<Integer>();
		int c1 = 0, c2 = 0;
		Integer m1 = null, m2 = null;
		int majority = nums.length / 3;
		//using Moore majority voting algorithm
		for (int i = 0; i < nums.length; i++) {
			if (m1 != null && nums[i] == m1) {
				c1++;
				continue;
			} else if (m2 != null && nums[i] == m2) {
				c2++;
				continue;
			} else if (c1 == 0) {
				m1 = nums[i];
				c1 = 1;
				continue;
			} else if (c2 == 0) {
				m2 = nums[i];
				c2 = 1;
				continue;
			} else {
				c1--;
				c2--;
			}
		}
		c1 = 0;
		c2 = 0;
		for (int i = 0; i < nums.length; i++) {
			if (m1 != null && nums[i] == m1) {
				c1++;
			}
			if (m2 != null && nums[i] == m2) {
				c2++;
			}
		}

		if (c1 > majority)
			li.add(m1);
		if (c2 > majority)
			li.add(m2);
		return li;
	}

	public static void main(String[] args) {
		MajorityElementII m = new MajorityElementII();
		System.out.println(m.majorityElement(new int[] { 3, 2, 3 }));
		System.out.println(m.majorityElement(new int[] { 1, 1, 1, 3, 3, 2, 2, 2 }));
	}
}
