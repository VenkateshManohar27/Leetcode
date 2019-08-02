package com.ven.leetcode.easy;

public class PerfectSquare {
	public boolean isPerfectSquare(int num) {
		long start = 1, end = num;

		while (start <= end) {
			long mid = start + (end - start) / 2;
			long square = mid * mid;
			if (square < num) {
				start = mid + 1;
			} else if (square > num) {
				end = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}
}
