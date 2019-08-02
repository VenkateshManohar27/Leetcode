package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.easy.LengthOfLastWord;

class LengthOfLastWordTest {
	LengthOfLastWord lw = new LengthOfLastWord();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testHelloWorld() {
		assertEquals(5, lw.lengthOfLastWord("Hello World"));
	}
	
	@Test
	void testSingleWord() {
		assertEquals(5, lw.lengthOfLastWord("Hello"));
	}
	@Test
	void testNull() {
		assertEquals(0, lw.lengthOfLastWord(null));
	}
	
	@Test
	void testEmptyStr() {
		assertEquals(0, lw.lengthOfLastWord(""));
	}
	
	@Test
	void testSpace() {
		assertEquals(0, lw.lengthOfLastWord(" "));
	}
	
	@Test
	void testHelloWorldWithoutSplit() {
		assertEquals(5, lw.lengthOfLastWordWithoutSplit("Hello World"));
	}
	
	@Test
	void testSingleWordWithoutSplit() {
		assertEquals(5, lw.lengthOfLastWordWithoutSplit("Hello"));
	}
	@Test
	void testNullWithoutSplit() {
		assertEquals(0, lw.lengthOfLastWordWithoutSplit(null));
	}
	
	@Test
	void testEmptyStrWithoutSplit() {
		assertEquals(0, lw.lengthOfLastWordWithoutSplit(""));
	}
	
	@Test
	void testSpaceWithoutSplit() {
		assertEquals(0, lw.lengthOfLastWordWithoutSplit(" "));
	}
}
