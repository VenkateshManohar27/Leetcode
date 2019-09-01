package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RotateListTest {
	static ListNode singleNode = new ListNode(1);
	static ListNode oneToFive = null;
	RotateList rl = new RotateList();
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		oneToFive = new ListNode(1);
		oneToFive.next = new ListNode(2);
		oneToFive.next.next = new ListNode(3);
		oneToFive.next.next.next = new ListNode(4);
		oneToFive.next.next.next.next = new ListNode(5);
		
	}
	
	@Test
	void testSingleNode() {
		ListNode res = rl.rotateRight(singleNode, 1);
		assertEquals(1, res.val);
		assertNull(res.next);
	}

	@Test
	void testRotate2nodes() {
		ListNode res = rl.rotateRight(oneToFive, 2);
		assertEquals(4, res.val);
		assertEquals(5, res.next.val);
		assertEquals(1, res.next.next.val);
		assertEquals(2, res.next.next.next.val);
		assertEquals(3, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
		
	}
	
	@Test
	void testRotateLengthEqualsLengthOfList() {
		ListNode res = rl.rotateRight(oneToFive, 5);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
		
	}
}
