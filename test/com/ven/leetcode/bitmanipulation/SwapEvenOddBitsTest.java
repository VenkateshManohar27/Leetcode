package com.ven.leetcode.bitmanipulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SwapEvenOddBitsTest {
	SwapEvenOddBits s = new SwapEvenOddBits();

	@Test
	void test() {
		assertEquals(2, s.swapBits(1));
		assertEquals(1, s.swapBits(2));
		assertEquals(3, s.swapBits(3));
		assertEquals(8, s.swapBits(4));
		assertEquals(10, s.swapBits(5));
		assertEquals(9, s.swapBits(6));
		assertEquals(11, s.swapBits(7));
		assertEquals(5, s.swapBits(10));
		assertEquals(152, s.swapBits(100));
		assertEquals(68, s.swapBits(136));
		
	}

}
