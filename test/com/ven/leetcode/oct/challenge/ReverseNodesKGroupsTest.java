package com.ven.leetcode.oct.challenge;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.linkedlist.ListNode;

class ReverseNodesKGroupsTest {
	ReverseNodesKGroups r = new ReverseNodesKGroups();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testSingleNode() {
		ListNode head = new ListNode(1);
		assertEquals(head, r.reverseKGroup(head, 1));
	}
	
	@Test
	void testExample1() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = r.reverseKGroup(head, 2);
		assertEquals(2, res.val);
		assertEquals(1, res.next.val);
		assertEquals(4, res.next.next.val);
		assertEquals(3, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}
	
	@Test
	void testExample2() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = r.reverseKGroup(head, 3);
		assertEquals(3, res.val);
		assertEquals(2, res.next.val);
		assertEquals(1, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}	
	
	@Test
	void testWhenkisListSize() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = r.reverseKGroup(head, 5);
		assertEquals(5, res.val);
		assertEquals(4, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(2, res.next.next.next.val);
		assertEquals(1, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}	
	
	@Test
	void testWhenKgreaterthanListSize() {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		
		ListNode res = r.reverseKGroup(head, 6);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}	

}
