package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesfromSortedListIITest {
	RemoveDuplicatesfromSortedListII r =  new RemoveDuplicatesfromSortedListII();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testSingleNode() {
		ListNode head = new ListNode(1);
		assertEquals(head,r.deleteDuplicates(head));
	}
	
	@Test
	void testFirstNodeDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		
		ListNode res = r.deleteDuplicates(head);
		assertEquals(2, res.val);
		assertEquals(3, res.next.val);
	}
	
	@Test
	void testMiddleNodeDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		head.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(5);
		
		ListNode res = r.deleteDuplicates(head);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(5, res.next.next.val);
	}
	@Test
	void testLastNodeDuplicates() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(3);
		
		
		ListNode res = r.deleteDuplicates(head);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertNull( res.next.next);
	}
}
