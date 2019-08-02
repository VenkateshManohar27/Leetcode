package com.ven.leetcode.dp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LongestIncreasingSubsequenceTest {
	private LongestIncreasingSubsequence ls = new LongestIncreasingSubsequence();

	@Test
	void test() {
		assertEquals(4, ls.countIncreasingSubsequence(new int[] { 3, 4, -1, 0, 6, 2, 3 }));
		assertEquals(5, ls.countIncreasingSubsequence(new int[] { 10, 22, 9, 33, 21, 50, 41, 60 }));
		assertEquals(4, ls.countIncreasingSubsequence(new int[] {50, 3, 10, 7, 40, 80}));
	}

}
