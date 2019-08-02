package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * 
 * @author Venkatesh Manohar
 *
 */
class ContainsNearbyDuplicateTest {
	private static ContainsNearbyDuplicate cnd = new ContainsNearbyDuplicate();
	@Test
	void test() {
		assertTrue(cnd.containsNearbyDuplicate(new int[] {99,99}, 2));
	}

}
