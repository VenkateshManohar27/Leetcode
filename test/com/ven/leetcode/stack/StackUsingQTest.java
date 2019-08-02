package com.ven.leetcode.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StackUsingQTest {
	private StackUsingQ sq = new StackUsingQ();
	@Test
	void testIsEmpty() {
		assertTrue(sq.empty());
	}
	
	//@Test
	void testPeekWhenEmpty() {
		assertNull(sq.top());
	}
	
	@Test
	void testHappyPath() {
		sq.push(1);
		assertEquals(1, sq.top());
		sq.push(2);
		assertEquals(2, sq.top());
		sq.push(3);
		assertEquals(3, sq.top());
		sq.push(4);
		assertEquals(4, sq.top());
	}
	
	@Test
	void testPop() {
		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		
		assertEquals(4, sq.top());
		assertEquals(4, sq.pop());
		assertEquals(3, sq.top());
		assertEquals(3, sq.pop());
		assertEquals(2, sq.top());
		assertEquals(2, sq.pop());
		assertEquals(1, sq.top());
		assertEquals(1, sq.pop());
	}

}
