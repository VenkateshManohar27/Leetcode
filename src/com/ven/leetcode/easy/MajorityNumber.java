package com.ven.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

public class MajorityNumber {
	public int majorityElement(int[] nums) {
		HashMap<Integer, Integer> maps = new HashMap<Integer, Integer>();
		int majority = nums[0];
		for (int i : nums) {
			if (maps.containsKey(i)) {
				maps.put(i, maps.get(i) + 1);
			} else {
				maps.put(i, 1);
			}
			if (maps.get(i) > nums.length / 2) {
				majority = i;
				break;
			}
		}
		return majority;
	}

	public int majorityElementUsingSorting(int[] nums) {
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public int majorityElementUsingMooreAlgo(int[] nums) {
		int major = 0, count = 0;

		for (int n : nums) {
			if (count == 0) {
				major = n;
				count = 1;
			} else if (major == n) {
				count++;
			} else {
				count--;
			}
		}
		return major;
	}

}
