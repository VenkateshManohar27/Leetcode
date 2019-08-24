package com.ven.leetcode.greedy;

public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII jg = new JumpGameII();
		System.out.println(jg.canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jg.canJump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(jg.canJump(new int[] { 2, 0 }));
		System.out.println(jg.canJump(new int[] { 0 }));
		System.out.println(jg.canJump(new int[] { 2, 0, 0 }));
		System.out.println(jg.canJump(new int[] { 1, 2, 1, 1, 1 }));
	}

	public int canJump(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int max = nums[0];
		int currIndex = 0;
		int jumps = 0;
		while (max < nums.length - 1) {

			for (int i = currIndex; i <= max; i++) {
				if (i < nums.length - 1 && max < i + nums[i]) {
					max = i + nums[i];
					jumps++;
				}

			}
			currIndex++;
		}
		return jumps;
	}

}
