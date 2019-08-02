package com.ven.leetcode.bitmanipulation;

public class BitsSet {
	public int countSetBitNaive(int n) {
		int count = 0;
		while (n != 0) {
			if ((n & 1) == 1) {
				count++;
			}
			n >>>= 1;
		}
		return count;
	}

	public int countSetBit(int n) {
		int count = 0;
		while (n > 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}
}
