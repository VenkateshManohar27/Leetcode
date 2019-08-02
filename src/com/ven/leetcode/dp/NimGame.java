package com.ven.leetcode.dp;

public class NimGame {
	public boolean canWinNim(int n) {
		/*
		 * if (n == 0) { return true; } else if (n < 0) { return false; } return
		 * canWinNim(n - 1) || canWinNim(n - 2) || canWinNim(n - 3);
		 */
		return n % 4 != 0;
	}
}
