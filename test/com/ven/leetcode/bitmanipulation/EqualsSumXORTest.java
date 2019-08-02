package com.ven.leetcode.bitmanipulation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EqualsSumXORTest {
	private static EqualsSumXOR esxor = new EqualsSumXOR();
	@Test
	void test() {
		assertEquals(4, esxor.countValuesSimple(12));
		
	}
	
	@Test
	void testcountValues() {
		assertEquals(4, esxor.countValues(12));
		
	}

}
