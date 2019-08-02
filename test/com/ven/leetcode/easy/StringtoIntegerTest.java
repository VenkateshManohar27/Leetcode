package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StringtoIntegerTest {
	StringtoInteger si = new StringtoInteger();
	@Test
	void test() {
		assertEquals(42, si.myAtoi("42"));
		assertEquals(-42, si.myAtoi("   -42"));
		assertEquals(4193, si.myAtoi("4193 with words"));
		assertEquals(-2147483648, si.myAtoi("-91283472332"));
		assertEquals(0, si.myAtoi("words and 987"));
		assertEquals(3, si.myAtoi("3.14159"));
	}
	
	@Test
	void testmyAtoi2() {
		assertEquals(42, si.myAtoi2("42"));
		assertEquals(-42, si.myAtoi2("   -42"));
		assertEquals(4193, si.myAtoi2("4193 with words"));
		assertEquals(-2147483648, si.myAtoi2("-91283472332"));
		assertEquals(0, si.myAtoi2("words and 987"));
		assertEquals(3, si.myAtoi2("3.14159"));
		assertEquals(0, si.myAtoi2(" "));
		assertEquals(1, si.myAtoi2("+1"));
	}

}
