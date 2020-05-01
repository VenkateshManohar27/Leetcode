package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PartitionListTest {
	PartitionList pl = new PartitionList();
	static ListNode node1 = null, node2 = null, node3 = null, node4 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		node1 = new ListNode(0);

		// 1->4->3->2->5->2, x = 3
		node2 = new ListNode(1);
		node2.next = new ListNode(4);
		node2.next.next = new ListNode(3);
		node2.next.next.next = new ListNode(2);
		node2.next.next.next.next = new ListNode(5);
		node2.next.next.next.next.next = new ListNode(2);

		// 1->2->3->4->5->6 x = 6
		node3 = new ListNode(1);
		node3.next = new ListNode(2);
		node3.next.next = new ListNode(3);
		node3.next.next.next = new ListNode(4);
		node3.next.next.next.next = new ListNode(5);
		node3.next.next.next.next.next = new ListNode(6);
		
		//2-1
		node4 = new ListNode(2);
		node4.next = new ListNode(1);
		
	}

	@Test
	void testNull() {
		assertNull(pl.partition(null, 1));
	}

	@Test
	void testSingleNode() {
		ListNode l = pl.partition(node1, 0);
		assertEquals(node1.val, l.val);
		assertNull(l.next);
	}

	@Test
	void testHappyPath() {
		ListNode l = pl.partition(node2, 3);
		assertEquals(1, l.val);
		assertEquals(2, l.next.val);
		assertEquals(2, l.next.next.val);
		assertEquals(4, l.next.next.next.val);
		assertEquals(3, l.next.next.next.next.val);
		assertEquals(5, l.next.next.next.next.next.val);
		assertNull(l.next.next.next.next.next.next);
	}

	@Test
	void testLastNode() {
		ListNode l = pl.partition(node3, 6);
		assertEquals(1, l.val);
		assertEquals(2, l.next.val);
		assertEquals(3, l.next.next.val);
		assertEquals(4, l.next.next.next.val);
		assertEquals(5, l.next.next.next.next.val);
		assertEquals(6, l.next.next.next.next.next.val);
		assertNull(l.next.next.next.next.next.next);
	}
	
	
	@Test
	void testPartitionNotFound() {
		ListNode l = pl.partition(node3, 8);
		assertEquals(1, l.val);
		assertEquals(2, l.next.val);
		assertEquals(3, l.next.next.val);
		assertEquals(4, l.next.next.next.val);
		assertEquals(5, l.next.next.next.next.val);
		assertEquals(6, l.next.next.next.next.next.val);
		assertNull(l.next.next.next.next.next.next);
	}
	
	@Test
	void testPartitionNotFound2() {
		ListNode l = pl.partition(node4, 0);
		assertEquals(2, l.val);
		assertEquals(1, l.next.val);
		assertNull(l.next.next);
	}
}
