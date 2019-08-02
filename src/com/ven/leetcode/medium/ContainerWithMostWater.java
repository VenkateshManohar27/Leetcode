package com.ven.leetcode.medium;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int minheight = Math.min(height[i], height[j]);
				max = Math.max(max, minheight * (j - i));
			}
		}
		return max;
	}

	public int maxArea2(int[] height) {
		if (height == null || height.length == 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;
		int i = 0, j = height.length - 1;
		while (i < j) {
			int minheight = Math.min(height[i], height[j]);
			max = Math.max(max, minheight * (j - i));
			if(height[i] < height[j]) {
				i++;
			}else {
				j--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		System.out.println(c.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
		System.out.println(c.maxArea2(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}
}
