package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class StringAnagramTest {
	StringAnagram sa = new StringAnagram();
	
	@Test
	void test() {
		List<Integer> li = sa.findAnagrams("cbaebabacd", "abc");
		assertEquals(0, li.get(0));
		assertEquals(6, li.get(1));
	}
	
	@Test
	void test2() {
		List<Integer> li = sa.findAnagrams("abab", "ab");
		assertEquals(0, li.get(0));
		assertEquals(1, li.get(1));
		assertEquals(2, li.get(2));
	}
}
