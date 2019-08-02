package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MajorityNumberTest {
	MajorityNumber mn = new MajorityNumber();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		assertEquals(3, mn.majorityElement(new int[] {3,2,3}));
	}
	
	@Test
	void test2() {
		assertEquals(5, mn.majorityElement(new int[] {6,5,5}));
	}
	
	@Test
	void test3() {
		assertEquals(1, mn.majorityElement(new int[] {1}));
	}
}
