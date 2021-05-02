package com.ven.leetcode.week239;

public class MinimumDistanceTargetElement {
	public int getMinDistance(int[] nums, int target, int start) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				int diff = Math.abs(i - start);
				if (diff < min) {
					min = diff;
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		MinimumDistanceTargetElement a = new MinimumDistanceTargetElement();
		System.out.println(a.getMinDistance(new int[] { 1, 2, 3, 4, 5 }, 5, 3));
	}

}
