package com.ven.leetcode.bitmanipulation;

/*
 * Given a positive integer n, find count of positive integers i such that 0 <= i <= n and n+i = n^i
 */
public class EqualsSumXOR {
	public static int countValuesSimple(int n) {
		int count = 0;
		for (int i = 0; i <= n; i++) {
			if ((n + i) == (n ^ i)) {
				count++;
			}
		}
		return count;
	}

	public static int countValues(int n) {
		int unset_bits = 0;
		while (n > 0) {
			if((n & 1) == 0) {
				unset_bits++;
			}
			n>>=1;
		}
		return 1<<unset_bits;
	}
}
