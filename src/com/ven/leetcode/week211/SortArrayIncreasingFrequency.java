package com.ven.leetcode.week211;

import java.util.Arrays;
import java.util.HashMap;

public class SortArrayIncreasingFrequency {
	public int[] frequencySort(int[] nums) {
		// int frequency[] = new int[2][nums.length];
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			// frequency[0][i] = nums[i];
			if (map.containsKey(nums[i])) {
				/*
				 * Set<Integer> li = map.get(nums[i]); li.add(i); for(int ind: map.get(nums[i]))
				 * { frequency[1][ind] += 1; }
				 */
				map.put(nums[i], map.get(nums[i]) + 1);

			} else {
				/*
				 * HashSet<Integer> li = new HashSet<>(); li.add(i);
				 */
				map.put(nums[i], 1);
				// frequency[1][i] +=1;
			}

		}
		int frequency[][] = new int[nums.length][2];
		for (int i = 0; i < nums.length; i++) {
			frequency[i][0] = nums[i];
			frequency[i][1] = map.get(nums[i]);
		}
		Arrays.sort(frequency, (int[] a, int[] b) -> {
			if (a[1] < b[1]) {
				return -1;
			} else if (a[1] > b[1]) {
				return 1;
			} else {
				if (a[0] < b[0]) {
					return 1;
				} else if (a[0] > b[0]) {
					return -1;
				}
				return 0;
			}
		});

		for (int i = 0; i < nums.length; i++) {
			nums[i] = frequency[i][0];
		}

		return nums;
	}

	public static void main(String[] args) {
		SortArrayIncreasingFrequency s = new SortArrayIncreasingFrequency();
		s.frequencySort(new int[] { 1, 1, 2, 2, 2, 3 });
	}
}
