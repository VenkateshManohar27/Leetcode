package com.ven.leetcode.mar2021.challenge;

public class MinimumNumberOperationstoReinitializePermutation {
	public int reinitializePermutation(int n) {
		int[] a = new int[n];
		for (int i = 0; i < a.length; i++) {
			a[i] = i;
		}

		int count = 0;
		while (true) {
			int[] temp = new int[n];
			for (int i = 0; i < temp.length; i++) {
				if (i % 2 == 0) {
					temp[i] = a[i / 2];

				}

				if (i % 2 == 1) {
					temp[i] = a[n / 2 + (i - 1) / 2];
				}
			}
			count++;
			if (check(temp)) {
				break;
			}
			a = temp;
		}

		return count;
	}

	private boolean check(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] != i) {
				return false;
			}

		}
		return true;
	}
}
