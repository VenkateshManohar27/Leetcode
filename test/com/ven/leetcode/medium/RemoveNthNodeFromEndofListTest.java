package com.ven.leetcode.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Given a linked list, remove the n-th node from the end of list and return its
 * head.
 * 
 * Example:
 * 
 * Given linked list: 1->2->3->4->5, and n = 2.
 * 
 * After removing the second node from the end, the linked list becomes
 * 1->2->3->5. Note:
 * 
 * Given n will always be valid.
 * 
 * Follow up:
 * 
 * Could you do this in one pass?
 * 
 * @author Venkatesh Manohar
 *
 */
class RemoveNthNodeFromEndofListTest {
	static ListNode head1, head2,head3,head4;
	RemoveNthNodeFromEndofList rnel = new RemoveNthNodeFromEndofList();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(3);
		head1.next.next.next = new ListNode(4);
		head1.next.next.next.next = new ListNode(5);
		
		head2 = new ListNode(1);
		head2.next = new ListNode(2);
		
		head3 = new ListNode(1);
		head3.next = new ListNode(2);
		head3.next.next = new ListNode(3);
		
	}
	
	@Test
	void testNullNode() {
		ListNode head = rnel.removeNthFromEnd(null, 2);
		assertNull(head);
	}

	@Test
	void testRemoveMiddleNode() {
		ListNode head = rnel.removeNthFromEnd(head1, 2);
		assertEquals(1, head.val);
		assertEquals(2, head.next.val);
		assertEquals(3, head.next.next.val);
		assertEquals(5, head.next.next.next.val);
		assertNull(head.next.next.next.next);
	}
	
	@Test
	void testRemoveFirstNode() {
		ListNode head = rnel.removeNthFromEnd(head2, 2);
		assertEquals(2, head.val);	
		assertNull(head.next);
	}

	@Test
	void testRemoveLastNode() {
		ListNode head = rnel.removeNthFromEnd(head3, 1);
		assertEquals(1, head.val);
		assertEquals(2, head.next.val);
		assertNull(head.next.next);
	}

}
