package com.ven.leetcode.greedy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SplitBalancedStringsTest {
	SplitBalancedStrings sbs = new SplitBalancedStrings();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testHappyPath() {
		assertEquals(4, sbs.balancedStringSplit("RLRRLLRLRL"));
		assertEquals(3, sbs.balancedStringSplit("RLLLLRRRLR"));
		assertEquals(1, sbs.balancedStringSplit("LLLLRRRR"));
		assertEquals(2, sbs.balancedStringSplit("RLRRRLLRLL"));
	}
	
	@Test
	void testMemoryEfficient() {
		assertEquals(4, sbs.balancedStringSplit2("RLRRLLRLRL"));
		assertEquals(3, sbs.balancedStringSplit2("RLLLLRRRLR"));
		assertEquals(1, sbs.balancedStringSplit2("LLLLRRRR"));
		assertEquals(2, sbs.balancedStringSplit2("RLRRRLLRLL"));
	}
}
