package com.ven.leetcode.dec.challenge;

public class LargestRectangleHistogram {
	public int largestRectangleArea(int[] heights) {
		return helper(heights, 0, heights.length - 1);
	}

	private int helper(int[] heights, int left, int right) {
		if (left > right)
			return 0;
		if (left == right)
			return heights[left];
		int minIndex = 0, min = Integer.MAX_VALUE;
		for (int i = left; i <= right; i++) {
			if (heights[i] < min) {
				min = heights[i];
				minIndex = i;
			}
		}

		int maximumWidthArea = (right - left + 1) * min;
		int leftAreaMax = helper(heights, left, minIndex - 1);
		int rightAreaMax = helper(heights, minIndex + 1, right);

		return Math.max(maximumWidthArea, Math.max(leftAreaMax, rightAreaMax));
	}
}
