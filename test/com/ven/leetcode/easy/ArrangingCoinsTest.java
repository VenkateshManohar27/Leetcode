package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ArrangingCoinsTest {
	ArrangingCoins ac = new ArrangingCoins();
	
	@Test
	void test() {
		assertEquals(2, ac.arrangeCoins(5));
		assertEquals(3, ac.arrangeCoins(8));
		assertEquals(4, ac.arrangeCoins(10));
		assertEquals(4, ac.arrangeCoins(11));
		assertEquals(5, ac.arrangeCoins(15));
		assertEquals(57994, ac.arrangeCoins(1681692777));
	}

}
