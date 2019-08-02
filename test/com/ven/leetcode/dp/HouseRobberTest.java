package com.ven.leetcode.dp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HouseRobberTest {
	private static HouseRobber hr = new HouseRobber();
	@Test
	void test() {
		assertEquals(4, hr.rob(new int[] {1,2,3,1}));
		assertEquals(12, hr.rob(new int[] {2,7,9,3,1}));
		assertEquals(6, hr.rob(new int[] {1,1,5,3}));
	}

}
