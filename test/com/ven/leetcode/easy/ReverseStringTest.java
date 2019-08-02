package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ReverseStringTest {
	ReverseString rs = new ReverseString();

	@Test
	void test() {
		char[] chars = { 'h', 'e', 'l', 'l', 'o' };
		rs.reverseString(chars);
		assertEquals('o', chars[0]);
		assertEquals('l', chars[1]);
		assertEquals('l', chars[2]);
		assertEquals('e', chars[3]);
		assertEquals('h', chars[4]);
	}

	
	@Test
	void test2() {
		char[] chars = { 'H','a','n','n','a','h' };
		rs.reverseString(chars);
		assertEquals('h', chars[0]);
		assertEquals('a', chars[1]);
		assertEquals('n', chars[2]);
		assertEquals('n', chars[3]);
		assertEquals('a', chars[4]);
		assertEquals('H', chars[5]);
	}
	
	@Test
	void test3() {
		char[] chars = { };
		rs.reverseString(chars);
		assertEquals(0, chars.length);
	}
}
