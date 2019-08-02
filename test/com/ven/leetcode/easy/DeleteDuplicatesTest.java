package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.easy.DeleteDuplicates;
import com.ven.leetcode.easy.ListNode;

class DeleteDuplicatesTest {
	static ListNode testHead1, testHead2, testHead3;
	DeleteDuplicates dd = new DeleteDuplicates();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		testHead1 = new ListNode(1);
		testHead1.next = new ListNode(2);
		testHead1.next.next = new ListNode(3);
		
		testHead2 = new ListNode(1);
		testHead2.next = new ListNode(1);
		testHead2.next.next = new ListNode(2);
		
		testHead3 = new ListNode(1);
		testHead3.next = new ListNode(1);
		testHead3.next.next = new ListNode(2);
		testHead3.next.next.next = new ListNode(3);
		testHead3.next.next.next.next = new ListNode(3);
	}

	@BeforeEach
	void setUp() throws Exception {
		
		
	}
	
	@Test
	void testNullNode() {
		assertNull(dd.deleteDuplicates(null));
	}
	
	@Test
	void testOneNode() {
		ListNode result = dd.deleteDuplicates(new ListNode(1));
		assertEquals(1, result.val);
		assertNull(result.next);
	}

	@Test
	void testHappyPath() {
		ListNode result = dd.deleteDuplicates(testHead1);
		
		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
		assertEquals(3, result.next.next.val);
		assertNull(result.next.next.next);
	}
	
	@Test
	void testSortedListWithDuplicates() {
		ListNode result = dd.deleteDuplicates(testHead2);
		
		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
		assertNull(result.next.next);
		
		result = dd.deleteDuplicates(testHead3);
		assertEquals(1, result.val);
		assertEquals(2, result.next.val);
		assertEquals(3, result.next.next.val);
		assertNull(result.next.next.next);
	}
	

}
