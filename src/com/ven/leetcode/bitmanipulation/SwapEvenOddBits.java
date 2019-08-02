package com.ven.leetcode.bitmanipulation;

public class SwapEvenOddBits {
	public int swapBits(int num) {
		int m = num & 0xAAAAAAAA;
		int n = num & 0x55555555;

		m >>= 1;
		n <<= 1;
		return m | n;
	}
}
