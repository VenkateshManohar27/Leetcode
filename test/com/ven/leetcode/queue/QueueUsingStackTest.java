package com.ven.leetcode.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueUsingStackTest {
	private QueueUsingStack q = new QueueUsingStack();
	@Test
	void testEmpty() {
		assertTrue(q.empty());
	}
	
	@Test
	void testPushPop() {
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		assertEquals(1, q.pop());
		assertEquals(2, q.pop());
		assertEquals(3, q.pop());
		assertEquals(4, q.pop());
		assertTrue(q.empty());
	}
	
	@Test
	void testPushPeek() {
		q.push(1);
		q.push(2);
		q.push(3);
		q.push(4);
		assertEquals(1, q.peek());
		q.pop();
		assertEquals(2, q.peek());
		q.pop();
		assertEquals(3, q.peek());
		q.pop();
		assertEquals(4, q.peek());
		q.pop();
		assertTrue(q.empty());
	}

}
