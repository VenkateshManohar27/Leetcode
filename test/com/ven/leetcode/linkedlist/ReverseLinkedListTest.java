package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ReverseLinkedListTest {
	ReverseLinkedList rll = new ReverseLinkedList();

	@Test
	void testNull() {
		assertNull(rll.reverseIterative(null));
	}
	
	@Test
	void testSingleNode() {
		ListNode head = new ListNode(0);
		assertEquals(0, rll.reverseIterative(head).val);
		assertNull(rll.reverseIterative(head).next);
	}

	@Test
	void testHappyPath() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode res = rll.reverseIterative(head);
		assertNotNull(res);
		assertEquals(5, res.val);
		assertEquals(4, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(2, res.next.next.next.val);
		assertEquals(1, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}

}
