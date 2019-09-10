package com.ven.leetcode.segtree;

public interface Operation {
	public int perform(int a , int b);
	public int defaultValue();
}
