package com.ven.sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.linkedlist.ListNode;

class InsertionSortListTest {
	InsertionSortList isl = new InsertionSortList();
	static ListNode n = null, head2 = null, head3 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		n = new ListNode(4);
		n.next = new ListNode(3);
		n.next.next = new ListNode(2);
		n.next.next.next = new ListNode(1);

		// 4->2->1->3
		head2 = new ListNode(4);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(1);
		head2.next.next.next = new ListNode(3);

		// -1->5->3->4->0
		head3 = new ListNode(-1);
		head3.next = new ListNode(5);
		head3.next.next = new ListNode(3);
		head3.next.next.next = new ListNode(4);
		head3.next.next.next.next = new ListNode(0);

	}

	@Test
	void testNull() {
		assertNull(isl.insertionSortList(null));
	}

	@Test
	void testSingleNode() {
		ListNode head = new ListNode(1);
		ListNode res = isl.insertionSortList(head);
		assertEquals(head.val, res.val);
		assertNull(res.next);

	}

	@Test
	void testHappyPath() {
		ListNode res = isl.insertionSortList(n);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertNull(res.next.next.next.next);
	}

	@Test
	void testCase2() {
		ListNode res = isl.insertionSortList(head2);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertNull(res.next.next.next.next);
	}

	@Test
	void testCase3() {
		ListNode res = isl.insertionSortList(head3);
		assertEquals(-1, res.val);
		assertEquals(0, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}

	@Test
	void testIS2Null() {
		assertNull(isl.insertionSortList2(null));
	}

	@Test
	void testIS2SingleNode() {
		ListNode head = new ListNode(1);
		ListNode res = isl.insertionSortList2(head);
		assertEquals(head.val, res.val);
		assertNull(res.next);

	}

	@Test
	void testIS2HappyPath() {
		n = new ListNode(4);
		n.next = new ListNode(3);
		n.next.next = new ListNode(2);
		n.next.next.next = new ListNode(1);
		ListNode res = isl.insertionSortList2(n);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertNull(res.next.next.next.next);
	}

	@Test
	void testIS2Case2() {
		// 4->2->1->3
		head2 = new ListNode(4);
		head2.next = new ListNode(2);
		head2.next.next = new ListNode(1);
		head2.next.next.next = new ListNode(3);

		ListNode res = isl.insertionSortList2(head2);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertNull(res.next.next.next.next);
	}

	@Test
	void testIS2Case3() {
		// -1->5->3->4->0
		head3 = new ListNode(-1);
		head3.next = new ListNode(5);
		head3.next.next = new ListNode(3);
		head3.next.next.next = new ListNode(4);
		head3.next.next.next.next = new ListNode(0);
		ListNode res = isl.insertionSortList2(head3);
		assertEquals(-1, res.val);
		assertEquals(0, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}
}
