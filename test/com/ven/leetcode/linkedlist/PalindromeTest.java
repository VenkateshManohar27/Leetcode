package com.ven.leetcode.linkedlist;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class PalindromeTest {
	private static ListNode root1 = null, root2 = null, root3 = null;
	Palindrome p  = new Palindrome();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root1 = new ListNode(1);
		root1.next = new ListNode(2);
		root1.next.next = new ListNode(2);
		root1.next.next.next = new ListNode(1);

		root2 = new ListNode(1);
		root2.next = new ListNode(2);
		
		root3 = new ListNode(3);
		root3.next = new ListNode(4);
		root3.next.next = new ListNode(5);
		root3.next.next.next = new ListNode(4);
		root3.next.next.next.next = new ListNode(3);

	}
	
	@Test
	void testNull() {
		assertTrue(p.isPalindrome(null));
	}
	
	@Test
	void testSingleNode() {
		assertTrue(p.isPalindrome(new ListNode(1)));
	}

	@Test
	void testPalindrome() {
		assertTrue(p.isPalindrome(root1));
	}
	
	@Test
	void testPalindrome2() {
		assertTrue(p.isPalindrome(root3));
	}

	@Test
	void testNotPalindrome() {
		assertFalse(p.isPalindrome(root2));
	}
}
