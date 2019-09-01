package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OddEvenLinkedListTest {
	static ListNode singleNode = new ListNode(1);
	static ListNode oneToFive = null;
	static ListNode oneToSix = null;
	OddEvenLinkedList ll = new OddEvenLinkedList();
	
	@BeforeEach
	void setUpBeforeClass() throws Exception {
		oneToFive = new ListNode(1);
		oneToFive.next = new ListNode(2);
		oneToFive.next.next = new ListNode(3);
		oneToFive.next.next.next = new ListNode(4);
		oneToFive.next.next.next.next = new ListNode(5);
		
		oneToSix = new ListNode(1);
		oneToSix.next = new ListNode(2);
		oneToSix.next.next = new ListNode(3);
		oneToSix.next.next.next = new ListNode(4);
		oneToSix.next.next.next.next = new ListNode(5);
		oneToSix.next.next.next.next.next = new ListNode(6);
	}

	@Test
	void testNull() {
		assertNull(ll.oddEvenList(null));
	}
	@Test
	void testSingleNode() {
		ListNode result = ll.oddEvenList(singleNode);
		assertEquals(1, result.val);
		assertNull(result.next);
	}
	
	@Test
	void testOddSizedList() {
		ListNode result = ll.oddEvenList(oneToFive);
		assertEquals(1, result.val);
		assertEquals(3, result.next.val);
		assertEquals(5, result.next.next.val);
		assertEquals(2, result.next.next.next.val);
		assertEquals(4, result.next.next.next.next.val);
		assertNull(result.next.next.next.next.next);
		
		
	}
	@Test
	void testEvenSizedList() {
		ListNode result = ll.oddEvenList(oneToSix);
		assertEquals(1, result.val);
		assertEquals(3, result.next.val);
		assertEquals(5, result.next.next.val);
		assertEquals(2, result.next.next.next.val);
		assertEquals(4, result.next.next.next.next.val);
		assertEquals(6, result.next.next.next.next.next.val);
		assertNull(result.next.next.next.next.next.next);
	}
	
	
	@Test
	void testoddEvenList2Null() {
		assertNull(ll.oddEvenList2(null));
	}
	@Test
	void testoddEvenList2SingleNode() {
		ListNode result = ll.oddEvenList2(singleNode);
		assertEquals(1, result.val);
		assertNull(result.next);
	}
	
	@Test
	void testoddEvenList2OddSizedList() {
		ListNode result = ll.oddEvenList2(oneToFive);
		assertEquals(1, result.val);
		assertEquals(3, result.next.val);
		assertEquals(5, result.next.next.val);
		assertEquals(2, result.next.next.next.val);
		assertEquals(4, result.next.next.next.next.val);
		assertNull(result.next.next.next.next.next);
		
		
	}
	@Test
	void testoddEvenList2EvenSizedList() {
		ListNode result = ll.oddEvenList2(oneToSix);
		assertEquals(1, result.val);
		assertEquals(3, result.next.val);
		assertEquals(5, result.next.next.val);
		assertEquals(2, result.next.next.next.val);
		assertEquals(4, result.next.next.next.next.val);
		assertEquals(6, result.next.next.next.next.next.val);
		assertNull(result.next.next.next.next.next.next);
	}
}
