package com.ven.leetcode.easy;

public class ClimbStairs {
	public int climbStairs(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		if (n == 2) {
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
	}

	public int climbStairsIterate(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int[] arr = new int[n + 1];
		arr[0] = 0;
		arr[1] = 1;
		arr[2] = 2;
		for (int i = 3; i < arr.length; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
		}

		return arr[n];
	}

}
