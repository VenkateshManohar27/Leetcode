package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SwapNodesPairsTest {
	SwapNodesPairs snp = new SwapNodesPairs();
	static ListNode head1 = null;
	static ListNode head2 = null;
	static ListNode head3 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);

		head2 = new ListNode(1);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(3);
		head2.next.next.next = new ListNode(4);
		head2.next.next.next.next = new ListNode(5);

	}

	@Test
	void testNull() {
		ListNode res = snp.swapPairs(null);
		assertNull(res);
	}

	@Test
	void testSingleNode() {
		ListNode res = snp.swapPairs(new ListNode(1));
		assertEquals(1, res.val);
		assertNull(res.next);
	}

	@Test
	void testEvenNumberOfNodes() {
		ListNode res = snp.swapPairs(head1);
		assertEquals(2, res.val);
		assertEquals(1, res.next.val);
		assertEquals(4, res.next.next.val);
		assertEquals(3, res.next.next.next.val);
		assertNull(res.next.next.next.next);
	}

	@Test
	void testOddNumberOfNodes() {
		ListNode res = snp.swapPairs(head2);
		assertEquals(2, res.val);
		assertEquals(1, res.next.val);
		assertEquals(4, res.next.next.val);
		assertEquals(3, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}
}
