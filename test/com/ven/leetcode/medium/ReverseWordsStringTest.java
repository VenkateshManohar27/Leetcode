package com.ven.leetcode.medium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReverseWordsStringTest {
	ReverseWordsString rws = new ReverseWordsString();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testNull() {
		assertNull(rws.reverseWords(null));
	}
	
	@Test
	void testValidInput1() {
		assertEquals("blue is sky the",rws.reverseWords("the sky is blue"));
	}
	
	@Test
	void testValidInput2WithLeadingAndTrailingspaces() {
		assertEquals("world! hello",rws.reverseWords("  hello world!  "));
	}
	
	@Test
	void testValidInput3WithMultipleSpaces() {
		assertEquals("example good a",rws.reverseWords("a good   example"));
	}
}
