package com.vm.practice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AddTwoNumbersTest {
	ListNode l1 = null;
	ListNode l2 = null;
	AddTwoNumbers atn = new AddTwoNumbers();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testAddingTwoNumber() {
		l1 = null;
		l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l2 = null;
		l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		
		ListNode lt = atn.addTwoNumbers(l1, l2);
		
		assertEquals(7, lt.val);
		assertEquals(0, lt.next.val);
		assertEquals(8, lt.next.next.val);
	}
	
	@Test
	void testAddingTwoNumberWithCarryatEnd() {
		l1 = null;
		l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l2 = null;
		l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(6);
		
		ListNode lt = atn.addTwoNumbers(l1, l2);
		
		assertEquals(7, lt.val);
		assertEquals(0, lt.next.val);
		assertEquals(0, lt.next.next.val);
		assertEquals(1, lt.next.next.next.val);
	}
	
	@Test
	void testAddingTwoNumberWithUnequalLengths() {
		l1 = null;
		l1 = new ListNode(2);
		l1.next = new ListNode(4);
		l1.next.next = new ListNode(3);
		l2 = null;
		l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		l2.next.next.next = new ListNode(5);
		
		ListNode lt = atn.addTwoNumbers(l1, l2);
		
		assertEquals(7, lt.val);
		assertEquals(0, lt.next.val);
		assertEquals(8, lt.next.next.val);
		assertEquals(5, lt.next.next.next.val);
	}

}
