package com.ven.leetcode.greedy;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array.
 * 
 * Each element in the array represents your maximum jump length at that
 * position.
 * 
 * Determine if you are able to reach the last index.
 * 
 * Example 1:
 * 
 * Input: [2,3,1,1,4] Output: true Explanation: Jump 1 step from index 0 to 1,
 * then 3 steps to the last index. Example 2:
 * 
 * Input: [3,2,1,0,4] Output: false Explanation: You will always arrive at index
 * 3 no matter what. Its maximum jump length is 0, which makes it impossible to
 * reach the last index.
 * 
 * @author Venkatesh Manohar
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		int max = 0;
		int i = 0;
		while (max < nums.length - 1) {
			if (i > max)
				return false;
			// System.out.println("i:"+i+", max:"+max);
			max = Math.max(max, i + nums[i]);
			i++;
			// System.out.println("i:"+i+", max:"+max);
		}
		return true;
	}

	public static void main(String[] args) {
		JumpGame jg = new JumpGame();
		System.out.println(jg.canJump(new int[] { 2, 3, 1, 1, 4 }));
		System.out.println(jg.canJump(new int[] { 3, 2, 1, 0, 4 }));
		System.out.println(jg.canJump(new int[] { 2, 0 }));
		System.out.println(jg.canJump(new int[] { 0 }));
		System.out.println(jg.canJump(new int[] { 2, 0, 0 }));
	}
}
