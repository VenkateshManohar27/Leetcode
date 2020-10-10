package com.ven.leetcode.oct.challenge;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.linkedlist.ListNode;

class RotateListTest {
	RotateList r = new RotateList();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testNull() {
		assertNull(r.rotateRight(null, 1));
	}

	@Test
	void testWhenKisLessthanLength() {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		
		l= r.rotateRight(l, 2);
		assertEquals(4, l.val);
		assertEquals(5, l.next.val);
		assertEquals(1, l.next.next.val);
		assertEquals(2, l.next.next.next.val);
		assertEquals(3, l.next.next.next.next.val);
		assertNull(l.next.next.next.next.next);
	}
	
	@Test
	void testWhenKisLargerthanLength() {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		
		l= r.rotateRight(l, 6);
		assertEquals(5, l.val);
		assertEquals(1, l.next.val);
		assertEquals(2, l.next.next.val);
		assertEquals(3, l.next.next.next.val);
		assertEquals(4, l.next.next.next.next.val);
		assertNull(l.next.next.next.next.next);
	}
}
