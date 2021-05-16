package com.ven.leetcode.week241;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class FindSumPairs {

	HashMap<Integer, Set<Integer>> map1 = new HashMap<>();
	HashMap<Integer, Set<Integer>> map2 = new HashMap<>();
	int[] n1 = null;
	int[] n2 = null;
	public FindSumPairs(int[] nums1, int[] nums2) {
		n1 = nums1;
		n2 = nums2;
		for (int i = 0; i < nums1.length; i++) {
			if (map1.containsKey(nums1[i])) {
				map1.get(nums1[i]).add(i);
			} else {
				Set<Integer> s = new HashSet<>();
				s.add(i);
				map1.put(nums1[i], s);

			}
		}

		for (int i = 0; i < nums2.length; i++) {
			if (map2.containsKey(nums2[i])) {
				map2.get(nums2[i]).add(i);
			} else {
				Set<Integer> s = new HashSet<>();
				s.add(i);
				map2.put(nums2[i], s);

			}
		}
	}

	public void add(int index, int val) {
		int curr = n2[index];
		n2[index] += val;
		
		map2.get(curr).remove(index);
		if (map2.containsKey(n2[index])) {
			map2.get(n2[index]).add(index);
		} else {
			Set<Integer> s = new HashSet<>();
			s.add(index);
			map2.put(n2[index], s);

		}
	}

	public int count(int tot) {
		int count1 = 0;
		for (int i = 0; i < n1.length; i++) {
			int diff = tot - n1[i];
			if(map2.containsKey(diff)) {
				count1 += map2.get(diff).size();
			}
		}
		
		return count1;
		
	}
}
