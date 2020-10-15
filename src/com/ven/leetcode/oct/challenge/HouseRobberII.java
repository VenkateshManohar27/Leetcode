package com.ven.leetcode.oct.challenge;

public class HouseRobberII {
	public int rob(int[] nums) {
		if (nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if (nums.length == 2)
			return Math.max(nums[0], nums[1]);
		return Math.max(robInRange(nums, 0, nums.length - 2), robInRange(nums, 1, nums.length - 1));
	}

	public int robInRange(int[] nums, int start, int end) {
		int prev = 0;
		int prevOfPrev = 0;
		for (int i = start; i <= end; i++) {
			int rob = nums[i] + prevOfPrev;
			prevOfPrev = prev;
			prev = Math.max(prev, rob);
		}

		return Math.max(prev, prevOfPrev);
	}

	public static void main(String[] args) {
		HouseRobberII h = new HouseRobberII();
		System.out.println(h.rob(new int[] { 2, 3, 2 }));
		System.out.println(h.rob(new int[] { 1, 2, 3, 1 }));
		System.out.println(h.rob(new int[] { 0 }));
		System.out.println(h.rob(new int[] { 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 10 }));
		System.out.println(h.rob(new int[] { 200, 3, 140, 20, 10 }));
	}
}
