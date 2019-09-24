package com.ven.google;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class BackspaceStringCompareTest {
	BackspaceStringCompare bsc = new BackspaceStringCompare();

	@Test
	void testHappyPath() {
		assertTrue(bsc.backspaceCompare("ab#c", "ad#c"));
	}
	@Test
	void testExample2() {
		assertTrue(bsc.backspaceCompare("ab##", "c#d#"));
	}
	@Test
	void testExample3() {
		assertTrue(bsc.backspaceCompare("a##c", "#a#c"));
	}
	@Test
	void testExample4() {
		assertFalse(bsc.backspaceCompare("a#c", "b"));
	}
	
	
	@Test
	void testBackspaceCompare2HappyPath() {
		assertTrue(bsc.backspaceCompare2("ab#c", "ad#c"));
	}
	@Test
	void testBackspaceCompare2Example2() {
		assertTrue(bsc.backspaceCompare2("ab##", "c#d#"));
	}
	@Test
	void testBackspaceCompare2Example3() {
		assertTrue(bsc.backspaceCompare2("a##c", "#a#c"));
	}
	@Test
	void testBackspaceCompare2Example4() {
		assertFalse(bsc.backspaceCompare2("a#c", "b"));
	}
}
