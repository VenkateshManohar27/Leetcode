package com.ven.leetcode.string;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IsomorphicTest {
	Isomorphic i = new Isomorphic();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testCase1() {
		assertTrue(i.isIsomorphic("egg", "add"));
	}
	
	@Test
	void testCase2() {
		assertFalse(i.isIsomorphic("foo", "bar"));
	}
	
	@Test
	void testCase3() {
		assertTrue(i.isIsomorphic("paper", "title"));
	}

}
