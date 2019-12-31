package com.ven.leetcode.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class NextGreaterElementITest {
	NextGreaterElementI nge = new NextGreaterElementI();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		int[] op = nge.nextGreaterElement(new int[] { 4, 1, 2 }, new int[] { 1, 3, 4, 2 });
		assertEquals(-1, op[0]);
		assertEquals(3, op[1]);
		assertEquals(-1, op[2]);
	}

	@Test
	void test2() {
		int[] op = nge.nextGreaterElement(new int[] { 1, 3, 5, 2, 4 }, new int[] { 6, 5, 4, 3, 2, 1, 7 });
		assertEquals(7, op[0]);
		assertEquals(7, op[1]);
		assertEquals(7, op[2]);
		assertEquals(7, op[3]);
		assertEquals(7, op[4]);
	}

}
