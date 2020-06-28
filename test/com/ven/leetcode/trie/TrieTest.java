package com.ven.leetcode.trie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TrieTest {
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testHappyPath() {
		Trie trie = new Trie();
		trie.insert("apple");
		assertTrue(trie.search("apple"));   // returns true
		assertFalse(trie.search("app"));     // returns false
		assertTrue(trie.startsWith("app")); // returns true
		trie.insert("app");   
		assertTrue(trie.search("app"));     // returns true
		assertFalse(trie.search(null));
		assertFalse(trie.search(""));
		assertFalse(trie.startsWith(""));
	}
	@Test
	void test2() {
		Trie trie = new Trie();
		//trie.insert("apple");
		assertFalse(trie.search("a"));
	}
}
