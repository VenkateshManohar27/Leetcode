package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TwoSumTest {
	private static TwoSum ts = new TwoSum();
	private static int[] input1 = new int[] {2,7,11,15};
	private static int[] input2 = new int[] {-9,-7,-5,-3,-2, -1, 0, 10,12};
	private static int[] input3 = new int[] {1,2,3,4,4,9,56,90};
		
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testTwoSum() {
		int[] result = ts.twoSum(input1, 9);
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
	}
	@Test
	void testTwoSumWhenInputNull() {
		int[] result = ts.twoSum(null, 9);
		assertNull(result);
	}
	
	@Test
	void testTwoSumWhenInputHasNegativeNumbers() {
		int[] result = ts.twoSum(input2, -4);
		assertEquals(4, result[0]);
		assertEquals(6, result[1]);
	}
	
	
	@Test
	void testTwoSumInputLeetCode() {
		int[] result = ts.twoSum(input3, 8);
		assertEquals(4, result[0]);
		assertEquals(5, result[1]);
	}
	
	@Test
	void testTwoSumBinSearch() {
		int[] result = ts.twoSumBinSearch(input1, 9);
		assertEquals(1, result[0]);
		assertEquals(2, result[1]);
	}
	@Test
	void testTwoSumBinSearchWhenInputNull() {
		int[] result = ts.twoSumBinSearch(null, 9);
		assertNull(result);
	}
	
	@Test
	void testTwoSumBinSearchWhenInputHasNegativeNumbers() {
		int[] result = ts.twoSumBinSearch(input2, -4);
		assertEquals(4, result[0]);
		assertEquals(6, result[1]);
	}
	
	@Test
	void testTwoSumBinSearchInputLeetCode() {
		int[] result = ts.twoSumBinSearch(input3, 8);
		assertEquals(4, result[0]);
		assertEquals(5, result[1]);
	}
}
