package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReverseLinkedListIITest {
	ReverseLinkedListII rll = new ReverseLinkedListII();

	@Test
	void testNull() {
		assertNull(rll.reverseBetween(null, 0, 0));
	}

	@Test
	void testSingleNode() {
		ListNode head = new ListNode(0);
		ListNode result = rll.reverseBetween(head, 1, 1);
		assertEquals(0, result.val);
		assertNull(result.next);
	}

	@Test
	void testHappyPath() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = rll.reverseBetween(head,2,4);
		assertNotNull(res);
		assertEquals(1, res.val);
		assertEquals(4, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(2, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}
	
	@Test
	void testHappyPath2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = rll.reverseBetween(head,1,5);
		assertNotNull(res);
		assertEquals(5, res.val);
		assertEquals(4, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(2, res.next.next.next.val);
		assertEquals(1, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}

}
