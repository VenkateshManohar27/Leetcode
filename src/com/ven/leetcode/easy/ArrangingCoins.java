package com.ven.leetcode.easy;

public class ArrangingCoins {
	public int arrangeCoins(int n) {
		int rows = 0;
		long count = 0;
		for (int i = 1; i <= n; i++) {
			if (count + i <= n) {
				rows++;
				count += i;
			}
		}
		return rows;
	}
}
