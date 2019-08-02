package com.ven.leetcode.bitmanipulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BitsSetTest {
	BitsSet bitsSet = new BitsSet();
	@Test
	void testCountSetBitNaive() {
		long start = System.nanoTime();
		assertEquals(1, bitsSet.countSetBitNaive(1));
		assertEquals(1, bitsSet.countSetBitNaive(2));
		assertEquals(2, bitsSet.countSetBitNaive(3));
		assertEquals(1, bitsSet.countSetBitNaive(4));
		assertEquals(2, bitsSet.countSetBitNaive(5));
		assertEquals(2, bitsSet.countSetBitNaive(6));
		assertEquals(3, bitsSet.countSetBitNaive(7));
		assertEquals(1, bitsSet.countSetBitNaive(8));
		assertEquals(26, bitsSet.countSetBitNaive(-127));
		//System.out.println(System.nanoTime() - start);
	}
	
	@Test
	void testCountSetBit() {
		long start = System.nanoTime();
		assertEquals(1, bitsSet.countSetBit(1));
		assertEquals(1, bitsSet.countSetBit(2));
		assertEquals(2, bitsSet.countSetBit(3));
		assertEquals(1, bitsSet.countSetBit(4));
		assertEquals(2, bitsSet.countSetBit(5));
		assertEquals(2, bitsSet.countSetBit(6));
		assertEquals(3, bitsSet.countSetBit(7));
		assertEquals(1, bitsSet.countSetBit(8));
		//assertEquals(26, bitsSet.countSetBitNaive(-127));
		//System.out.println(System.nanoTime() - start);
	}

}
