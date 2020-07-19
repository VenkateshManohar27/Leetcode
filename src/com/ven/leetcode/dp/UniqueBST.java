package com.ven.leetcode.dp;

public class UniqueBST {
	public int numTrees(int n) {
		if (n == 0) {
			return 0;
		}

		int[] nums = new int[n];
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i + 1;
		}
		int res = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < nums.length; i++) {
			int temp = nums[i];
			nums[i] = -1;
			sb.append("->" + temp);
			res += helper(nums, 1, 0, temp, Integer.MAX_VALUE, sb);
			sb.delete(sb.length() - 3, sb.length());
			nums[i] = temp;
		}

		return res;
	}

	private int helper(int[] nums, int val, int min, Integer curr, int max, StringBuilder sb) {

		if (val == nums.length) {
			System.out.println(sb.toString());
			return 1;
		}
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == -1) {
				continue;
			}
			int temp = nums[i];
			nums[i] = -1;
			// System.out.println("temp:" + temp + " min: " + min + " max: " + max);
			if (temp > min && temp < curr) {
				sb.append("->" + temp);
				res += helper(nums, val + 1, min, temp, temp, sb);
				sb.delete(sb.length() - 3, sb.length());
			}
			if ( temp > curr && temp < max) {
				sb.append("->" + temp);
				res += helper(nums, val + 1, temp, temp, max, sb);
				sb.delete(sb.length() - 3, sb.length());
			}
			nums[i] = temp;
		}
		return res;
	}

	public static void main(String[] args) {
		UniqueBST ub = new UniqueBST();
		// System.out.println(ub.numTrees(1));
		// System.out.println(ub.numTrees(2));
		System.out.println(ub.numTrees(3));
		System.out.println(ub.numTrees(4));
	}
}
