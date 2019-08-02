package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReverseVowelsTest {
	ReverseVowels rv = new ReverseVowels();
	@Test
	void test() {
		assertEquals("holle", rv.reverseVowels("hello"));
		assertEquals("leotcede", rv.reverseVowels("leetcode"));
	}
	
	//@Test
	void test2() {
		assertEquals("holle", rv.reverseVowelsOptimized("hello"));
		assertEquals("leotcede", rv.reverseVowelsOptimized("leetcode"));
	}

}
