package com.ven.google;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class FindDisappearedNumbersTest {
	FindDisappearedNumbers fdn = new FindDisappearedNumbers();
	@Test
	void testFindDisappearedNumbers1() {
		List<Integer> result = fdn.findDisappearedNumbers(new int[] {4,3,2,7,8,2,3,1});
		assertEquals(2, result.size());
		assertEquals(result.get(0), 5);
		assertEquals(result.get(1), 6);
	}
	
	@Test
	void testFindDisappearedNumbers2() {
		List<Integer> result = fdn.findDisappearedNumbers(new int[] {5,4,6,7,9,3,10,9,5,6});
		assertEquals(3, result.size());
		assertEquals(result.get(0), 1);
		assertEquals(result.get(1), 2);
		assertEquals(result.get(2), 8);
	}

	
	@Test
	void testfindDisappearedNumbersOptimized1() {
		List<Integer> result = fdn.findDisappearedNumbersOptimized(new int[] {4,3,2,7,8,2,3,1});
		assertEquals(2, result.size());
		assertEquals(result.get(0), 5);
		assertEquals(result.get(1), 6);
	}
	
	@Test
	void testfindDisappearedNumbersOptimized2() {
		List<Integer> result = fdn.findDisappearedNumbersOptimized(new int[] {5,4,6,7,9,3,10,9,5,6});
		assertEquals(3, result.size());
		assertEquals(result.get(0), 1);
		assertEquals(result.get(1), 2);
		assertEquals(result.get(2), 8);
	}

}
