package com.ven.leetcode.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderMaxPQTest {

	private  OrderMaxPQ<Integer> maxpq;
	@BeforeEach
	public void initialize() {
		maxpq = new OrderMaxPQ<>(10);
	}

	@Test
	public void TestIsEmpty() {
		assertTrue(maxpq.isEmpty());
	}

	@Test
	public void TestDeleteOnEmptyPQ() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			maxpq.delMax();
		});
	}

	@Test
	public void TestMaxWithOneElement() {
		maxpq.insert(1);
		assertFalse(maxpq.isEmpty());
		assertEquals(maxpq.delMax(), Integer.valueOf(1));
		assertTrue(maxpq.isEmpty());
	}

	@Test
	public void TestMaxWithFiveElement() {
		maxpq.insert(1);
		maxpq.insert(5);
		maxpq.insert(3);
		maxpq.insert(2);
		maxpq.insert(4);
		assertFalse(maxpq.isEmpty());
		assertEquals(maxpq.delMax(), Integer.valueOf(5));
		assertFalse(maxpq.isEmpty());

		assertFalse(maxpq.isEmpty());
		assertEquals(maxpq.delMax(), Integer.valueOf(4));
		assertFalse(maxpq.isEmpty());

		assertFalse(maxpq.isEmpty());
		assertEquals(maxpq.delMax(), Integer.valueOf(3));
		assertFalse(maxpq.isEmpty());

		assertFalse(maxpq.isEmpty());
		assertEquals(maxpq.delMax(), Integer.valueOf(2));
		assertFalse(maxpq.isEmpty());

		assertFalse(maxpq.isEmpty());
		assertEquals(maxpq.delMax(), Integer.valueOf(1));
		assertTrue(maxpq.isEmpty());
	}

}
