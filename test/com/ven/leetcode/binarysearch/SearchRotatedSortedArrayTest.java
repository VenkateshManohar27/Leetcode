package com.ven.leetcode.binarysearch;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SearchRotatedSortedArrayTest {
	SearchRotatedSortedArray srt = new SearchRotatedSortedArray();
	private static int[] sorted = null;
	private static int[] nums2 = null;
	private static int[] nums3 = null;
	private static int[] nums4 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sorted = new int[] { 0, 1, 2, 4, 5, 6, 7 };
		nums2 = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		nums3 = new int[] { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		nums4 = new int[] { 30, 40, 50, 10, 20 };
	}

	@Test
	void testSearchOnSortedArr() {
		assertEquals(0, srt.search(sorted, 0));
		assertEquals(1, srt.search(sorted, 1));
		assertEquals(2, srt.search(sorted, 2));
		assertEquals(-1, srt.search(sorted, 3));
		assertEquals(3, srt.search(sorted, 4));
		assertEquals(4, srt.search(sorted, 5));
		assertEquals(5, srt.search(sorted, 6));
		assertEquals(6, srt.search(sorted, 7));
	}

	@Test
	void testFind() {
		assertEquals(3, srt.findIndex(nums2, 0, nums2.length-1));
		assertEquals(5, srt.findIndex(nums3, 0, nums3.length-1));
		assertEquals(2, srt.findIndex(nums4, 0, nums4.length-1));
	}
	
	@Test
	void testSearch() {
		assertEquals(0, srt.search(nums2, 4));
		assertEquals(1, srt.search(nums2, 5));
		assertEquals(2, srt.search(nums2, 6));
		assertEquals(3, srt.search(nums2, 7));
		assertEquals(4, srt.search(nums2, 0));
		assertEquals(5, srt.search(nums2, 1));
		assertEquals(6, srt.search(nums2, 2));
		assertEquals(-1, srt.search(nums2, 3));
		
		assertEquals(0, srt.search(nums3, 5));
		assertEquals(1, srt.search(nums3, 6));
		assertEquals(2, srt.search(nums3, 7));
		assertEquals(3, srt.search(nums3, 8));
		assertEquals(4, srt.search(nums3, 9));
		assertEquals(5, srt.search(nums3, 10));
		assertEquals(6, srt.search(nums3, 1));
		assertEquals(7, srt.search(nums3, 2));
		assertEquals(8, srt.search(nums3, 3));
		
		assertEquals(0, srt.search(nums4, 30));
		assertEquals(1, srt.search(nums4, 40));
		assertEquals(2, srt.search(nums4, 50));
		assertEquals(3, srt.search(nums4, 10));
		assertEquals(4, srt.search(nums4, 20));
	}

}
