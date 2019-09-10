package com.ven.leetcode.segtree;

public class Min implements Operation{

	@Override
	public int perform(int a, int b) {
		return Math.min(a, b);
	}

	@Override
	public int defaultValue() {
		return Integer.MAX_VALUE;
	}

}
