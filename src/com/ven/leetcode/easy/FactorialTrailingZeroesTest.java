package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FactorialTrailingZeroesTest {

	@Test
	void test() {
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		assertEquals(0, ftz.trailingZeroes(0));
		assertEquals(0, ftz.trailingZeroes(3));
		assertEquals(1, ftz.trailingZeroes(5));
		assertEquals(0, ftz.trailingZeroes(13));//FAILS DUE TO INT OVERFLOW
		assertEquals(0, ftz.trailingZeroes(0));
		
	}
	
	@Test
	void testtrailingZeroesUsing5Factors() {
		FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		assertEquals(0, ftz.trailingZeroesUsing5Factors(0));
		assertEquals(0, ftz.trailingZeroesUsing5Factors(3));
		assertEquals(1, ftz.trailingZeroesUsing5Factors(5));
		assertEquals(2, ftz.trailingZeroesUsing5Factors(13));
		assertEquals(0, ftz.trailingZeroesUsing5Factors(0));
		
	}

}
