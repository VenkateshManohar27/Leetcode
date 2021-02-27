package com.ven.leetcode.week223;

import java.util.HashMap;

public class MinimizeHammingDistanceAfterSwapOperations {
	public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
		HashMap<String, Integer> map = new HashMap<>();
		int min = helper(source, target, allowedSwaps, map);
		return min;
	}

	private int helper(int[] source, int[] target, int[][] allowedSwaps, HashMap<String, Integer> map) {
		String key = getKey(source);
		if (map.containsKey(key)) {
			return map.get(key);
		}
		int hammingDistance = hammingDistance(source, target);
		int min = hammingDistance;

		for (int i = 0; i < allowedSwaps.length; i++) {
			swap(source, allowedSwaps[i][0], allowedSwaps[i][1]);
			String currkey = getKey(source);
			int currHD = Integer.MAX_VALUE;
			if (map.containsKey(currkey)) {
				currHD = map.get(currkey);
			} else {
				currHD = hammingDistance(source, target);
				map.put(currkey, currHD);
				helper(source, target, allowedSwaps, map);
			}
			min = Math.min(min, currHD);

		}
		return min;
	}

	private void swap(int[] s, int i, int j) {
		int temp = s[i];
		s[i] = s[j];
		s[j] = temp;
	}

	private String getKey(int[] source) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < source.length; i++) {
			sb.append(source[i] + "x");
		}
		return sb.toString();
	}

	private int hammingDistance(int[] source, int[] target) {
		int diff = 0;

		for (int i = 0; i < source.length; i++) {
			if (source[i] != target[i]) {
				diff++;
			}
		}
		return diff;
	}

	public static void main(String[] args) {
		MinimizeHammingDistanceAfterSwapOperations m = new MinimizeHammingDistanceAfterSwapOperations();
		int min = m.minimumHammingDistance(new int[] { 5, 1, 2, 4, 3 }, new int[] { 1, 5, 4, 2, 3 },
				new int[][] { { 0, 4 }, { 4, 2 }, { 1, 3 }, { 1, 4 } });
		System.out.println(min);
	}
}
