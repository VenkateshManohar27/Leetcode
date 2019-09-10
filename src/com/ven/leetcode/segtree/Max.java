package com.ven.leetcode.segtree;

public class Max implements Operation {

	@Override
	public int perform(int a, int b) {
		return Math.max(a, b);
	}

	@Override
	public int defaultValue() {
		return Integer.MIN_VALUE;
	}

}
