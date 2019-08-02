package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RotateArrayTest {

	@Test
	void testrotateBubble() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		RotateArray.rotateBubble(nums, 3);
		assertEquals(5, nums[0]);
		assertEquals(6, nums[1]);
		assertEquals(7, nums[2]);
		assertEquals(1, nums[3]);
		assertEquals(2, nums[4]);
		assertEquals(3, nums[5]);
		assertEquals(4, nums[6]);
	}

	@Test
	void testrotateBubbleEmptyarr() {
		int[] nums = new int[0];
		RotateArray.rotateBubble(nums, 2);
		assertEquals(0, nums.length);
	}

	@Test
	void testrotateBubble2() {
		int[] nums = new int[] { -1, -100, 3, 99 };
		RotateArray.rotateBubble(nums, 2);
		assertEquals(3, nums[0]);
		assertEquals(99, nums[1]);
		assertEquals(-1, nums[2]);
		assertEquals(-100, nums[3]);
	}
	
	@Test
	void testRotate() {
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		RotateArray.rotate(nums, 3);
		assertEquals(5, nums[0]);
		assertEquals(6, nums[1]);
		assertEquals(7, nums[2]);
		assertEquals(1, nums[3]);
		assertEquals(2, nums[4]);
		assertEquals(3, nums[5]);
		assertEquals(4, nums[6]);
	}

	@Test
	void testRotateEmptyarr() {
		int[] nums = new int[0];
		RotateArray.rotate(nums, 2);
		assertEquals(0, nums.length);
	}

	@Test
	void testRotate2() {
		int[] nums = new int[] { -1, -100, 3, 99 };
		RotateArray.rotate(nums, 2);
		assertEquals(3, nums[0]);
		assertEquals(99, nums[1]);
		assertEquals(-1, nums[2]);
		assertEquals(-100, nums[3]);
	}
}
