package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SplitLinkedListinPartsTest {
	SplitLinkedListinParts sp = new SplitLinkedListinParts();
	static ListNode num1, num2, num3;

	@BeforeEach
	void setUpBeforeClass() throws Exception {
		num1 = new ListNode(1);
		num1.next = new ListNode(2);
		num1.next.next = new ListNode(3);
		num1.next.next.next = new ListNode(4);
		num1.next.next.next.next = new ListNode(5);

		num2 = new ListNode(4);
		num2.next = new ListNode(3);
		num2.next.next = new ListNode(2);

		num3 = new ListNode(3);
		num3.next = new ListNode(9);
		num3.next.next = new ListNode(9);
		num3.next.next.next = new ListNode(9);
		num3.next.next.next.next = new ListNode(9);
		num3.next.next.next.next.next = new ListNode(9);
		num3.next.next.next.next.next.next = new ListNode(9);
		num3.next.next.next.next.next.next.next = new ListNode(9);
		num3.next.next.next.next.next.next.next.next = new ListNode(9);
		num3.next.next.next.next.next.next.next.next.next = new ListNode(9);

	}

	@Test
	void testSplitListToParts() {
		ListNode[] res = sp.splitListToParts(num1, 2);
		assertEquals(res.length, 2);
		assertEquals(res[0].val, 1);
		assertEquals(res[0].next.val, 2);
		assertEquals(res[0].next.next.val, 3);
		assertEquals(res[1].val, 4);
		assertEquals(res[1].next.val, 5);
	}
	
	@Test
	void testSplitListToPartsToFive() {
		ListNode[] res = sp.splitListToParts(num1, 5);
		assertEquals(res.length, 5);
		assertEquals(res[0].val, 1);
		assertEquals(res[1].val, 2);
		assertEquals(res[2].val, 3);
		assertEquals(res[3].val, 4);
		assertEquals(res[4].val, 5);
	}
	@Test
	void testSplitListToPartsToFive2() {
		ListNode[] res = sp.splitListToParts(num2, 5);
		assertEquals(res.length, 5);
		assertEquals(res[0].val, 4);
		assertEquals(res[1].val, 3);
		assertEquals(res[2].val, 2);
		assertNull(res[3]);
		assertNull(res[4]);
	}
	
	@Test
	void testSplitListToPartsTo1() {
		ListNode[] res = sp.splitListToParts(num1, 1);
		assertEquals(res.length, 1);
		assertEquals(res[0].val, 1);
		assertEquals(res[0].next.val, 2);
		assertEquals(res[0].next.next.val, 3);
		assertEquals(res[0].next.next.next.val, 4);
		assertEquals(res[0].next.next.next.next.val, 5);
	}
}
