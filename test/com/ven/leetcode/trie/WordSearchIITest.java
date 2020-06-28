package com.ven.leetcode.trie;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class WordSearchIITest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		char[][] board = new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
				{ 'i', 'f', 'l', 'v' } };
		String[] words = new String[] { "oath", "pea", "eat", "rain" };
		WordSearchII ws = new WordSearchII();
		List<String> li = ws.findWords(board, words);
		assertTrue(li.contains("eat"));
		assertTrue(li.contains("oath"));
	}
	
	@Test
	void test2() {
		char[][] board = new char[][] { { 'a', 'a' } };
		String[] words = new String[] { "aaa" };
		WordSearchII ws = new WordSearchII();
		List<String> li = ws.findWords(board, words);
		assertFalse(li.contains("aaa"));	
	}
}
