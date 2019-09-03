package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AddTwoNumbersIITest {
	AddTwoNumbersII atn = new AddTwoNumbersII();
	static ListNode num1, num2, num3;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		num1 = new ListNode(1);
		num1.next = new ListNode(2);
		num1.next.next = new ListNode(3);
		num1.next.next.next = new ListNode(4);
		num1.next.next.next.next = new ListNode(5);
		
		num2 = new ListNode(4);
		num2.next = new ListNode(3);
		num2.next.next = new ListNode(2);
		
		num3 =new ListNode(3);
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
	void testAddTwoNumbers() {
	
		ListNode res = atn.addTwoNumbers(num1, num2);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(7, res.next.next.val);
		assertEquals(7, res.next.next.next.val);
		assertEquals(7, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}

	@Test
	void testAddTwoNumbers2() {
	
		ListNode res = atn.addTwoNumbers(num1, new ListNode(0));
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}
	
	@Test
	void testAddTwoNumbers5() {
		ListNode res = atn.addTwoNumbers(new ListNode(5), new ListNode(5));
		assertEquals(1, res.val);
		assertEquals(0, res.next.val);
	}
	
	@Test
	void testAddTwoNumbers3() {
	
		ListNode res = atn.addTwoNumbers(num2, num1);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(7, res.next.next.val);
		assertEquals(7, res.next.next.next.val);
		assertEquals(7, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}
	
	@Test
	void testAddTwoNumbersWhenNum1IsNull() {
	
		ListNode res = atn.addTwoNumbers(null, num2);
		assertEquals(4, res.val);
		assertEquals(3, res.next.val);
		assertEquals(2, res.next.next.val);
		assertNull(res.next.next.next);
	}
	
	@Test
	void testAddTwoNumbersWhenNum2IsNull() {
	
		ListNode res = atn.addTwoNumbers(num1, null);
		assertEquals(1, res.val);
		assertEquals(2, res.next.val);
		assertEquals(3, res.next.next.val);
		assertEquals(4, res.next.next.next.val);
		assertEquals(5, res.next.next.next.next.val);
		assertNull(res.next.next.next.next.next);
	}
	
	@Test
	void testAddTwoNumbers4() {
	
		ListNode res = atn.addTwoNumbers(num3, new ListNode(7));
		assertEquals(4, res.val);
		assertEquals(0, res.next.val);
		assertEquals(0, res.next.next.val);
		assertEquals(0, res.next.next.next.val);
		assertEquals(0, res.next.next.next.next.val);
		assertEquals(0, res.next.next.next.next.next.val);
		assertEquals(0, res.next.next.next.next.next.next.val);
		assertEquals(0, res.next.next.next.next.next.next.next.val);
		assertEquals(0, res.next.next.next.next.next.next.next.next.val);
		assertEquals(6, res.next.next.next.next.next.next.next.next.next.val);
		
	}
}
