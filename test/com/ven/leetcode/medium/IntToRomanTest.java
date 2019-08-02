package com.ven.leetcode.medium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class IntToRomanTest {
	IntToRoman ir = new IntToRoman();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testBase1() {
		assertEquals("I", ir.intToRoman(1));
		assertEquals("II", ir.intToRoman(2));
		assertEquals("III", ir.intToRoman(3));
		assertEquals("IV", ir.intToRoman(4));
		assertEquals("V", ir.intToRoman(5));
		assertEquals("VI", ir.intToRoman(6));
		assertEquals("VII", ir.intToRoman(7));
		assertEquals("VIII", ir.intToRoman(8));
		assertEquals("IX", ir.intToRoman(9));

	}
	
	@Test
	void testBase10() {
		assertEquals("XI", ir.intToRoman(11));
		assertEquals("XII", ir.intToRoman(12));
		assertEquals("XIII", ir.intToRoman(13));
		assertEquals("XIV", ir.intToRoman(14));
		assertEquals("XV", ir.intToRoman(15));
		assertEquals("XVI", ir.intToRoman(16));
		assertEquals("XVII", ir.intToRoman(17));
		assertEquals("XVIII", ir.intToRoman(18));
		assertEquals("XIX", ir.intToRoman(19));
		assertEquals("XX", ir.intToRoman(20));
		assertEquals("XXIX", ir.intToRoman(29));
		assertEquals("XLIX", ir.intToRoman(49));
		assertEquals("L", ir.intToRoman(50));
		assertEquals("XCIX", ir.intToRoman(99));
	}

}
