package com.ven.leetcode.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RemoveDuplicatesTest {
	RemoveDuplicates rd = new RemoveDuplicates();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		assertEquals("ca", rd.removeDuplicates("abbaca"));
	}

}
