package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.easy.MergeSortedArray;

class MergeSortedArrayTest {
	MergeSortedArray ms = new MergeSortedArray();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testHappyPath() {
		int nums[] = new int[] {1,2,3,0,0,0};
		ms.merge(nums, 3, new int[] {2,5,6}, 3);
		assertEquals(1, nums[0]);
		assertEquals(2, nums[1]);
		assertEquals(2, nums[2]);
		assertEquals(3, nums[3]);
		assertEquals(5, nums[4]);
		assertEquals(6, nums[5]);
	}
	
	@Test
	void testWhenNumsisZero() {
		int nums[] = new int[] {0,0,0};
		ms.merge(nums, 0, new int[] {2,5,6}, 3);
		assertEquals(2, nums[0]);
		assertEquals(5, nums[1]);
		assertEquals(6, nums[2]);
		
	}
	
	@Test
	void testWhenNumsHasAdditionalSpace() {
		int nums[] = new int[] {1,2,3,0,0,0,0};
		ms.merge(nums, 3, new int[] {2,5,6}, 3);
		assertEquals(1, nums[0]);
		assertEquals(2, nums[1]);
		assertEquals(2, nums[2]);
		assertEquals(3, nums[3]);
		assertEquals(5, nums[4]);
		assertEquals(6, nums[5]);
	}
	
	@Test
	void testWhenNums1HasGreaterElements() {
		int nums[] = new int[] {4,5,6,0,0,0,0};
		ms.merge(nums, 3, new int[] {1,2,3}, 3);
		assertEquals(1, nums[0]);
		assertEquals(2, nums[1]);
		assertEquals(3, nums[2]);
		assertEquals(4, nums[3]);
		assertEquals(5, nums[4]);
		assertEquals(6, nums[5]);
	}
}
