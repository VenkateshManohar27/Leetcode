package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortedArrToBSTTest {
	static int[] arr = { -10, -3, 0, 5, 9 };
	SortedArrToBST sb = new SortedArrToBST();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		TreeNode node = sb.sortedArrayToBST(arr);
		assertEquals(0, node.val);
		assertEquals(-3, node.left.val);
		assertEquals(9, node.right.val);
		assertEquals(-10, node.left.left.val);
		assertEquals(5, node.right.left.val);
	}
	
	@Test
	void testNull() {
		TreeNode node = sb.sortedArrayToBST(null);
		assertNull(node);
	}
	@Test
	void testEmptyArray() {
		TreeNode node = sb.sortedArrayToBST(new int[] {});
		assertNull(node);
	}
}
