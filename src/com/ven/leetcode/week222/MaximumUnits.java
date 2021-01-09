package com.ven.leetcode.week222;

import java.util.Arrays;

public class MaximumUnits {
	public int maximumUnits(int[][] boxTypes, int truckSize) {
		Arrays.sort(boxTypes, (int[] a, int[] b) -> {
			return b[1] - a[1];
		});
		int max = 0;
		int size = truckSize;
		for (int i = 0; i < boxTypes.length; i++) {
			if (size == 0)
				break;
			if (size > boxTypes[i][0]) {
				size = size - boxTypes[i][0];
				max += (boxTypes[i][0] * boxTypes[i][1]);
			} else {
				max += (size * boxTypes[i][1]);
				size = 0;
			}

		}
		return max;
	}

	public static void main(String[] args) {
		MaximumUnits m = new MaximumUnits();
		m.maximumUnits(new int[][] {{1,3},{2,2},{3,1}}, 4);
	}
}
