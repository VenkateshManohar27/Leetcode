package com.ven.leetcode.dp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RangeSumQueryImmutableTest {
	@Test
	void test() {
		RangeSumQueryImmutable rsi = new RangeSumQueryImmutable(new int[] {-2, 0, 3, -5, 2, -1});
		
		assertEquals(1, rsi.sumRange(0, 2));
		assertEquals(-1, rsi.sumRange(2, 5));
		assertEquals(-3, rsi.sumRange(0, 5));
	}

}
