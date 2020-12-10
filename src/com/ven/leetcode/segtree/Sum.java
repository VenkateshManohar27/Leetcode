package com.ven.leetcode.segtree;

public class Sum implements Operation {

	@Override
	public int perform(int a, int b) {
		return a + b;
	}

	@Override
	public int defaultValue() {
		return 0;
	}

}
