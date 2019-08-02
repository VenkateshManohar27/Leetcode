package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExcelColumnTest {
	ExcelColumn ec = new ExcelColumn();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testConvertToColumnNumber() {
		assertEquals(1, ec.convertToColumnNumber("A"));
		assertEquals(2, ec.convertToColumnNumber("B"));
		assertEquals(26, ec.convertToColumnNumber("Z"));
		assertEquals(27, ec.convertToColumnNumber("AA"));
		assertEquals(28, ec.convertToColumnNumber("AB"));
		assertEquals(701, ec.convertToColumnNumber("ZY"));
		assertEquals(1, ec.convertToColumnNumber("A"));
	}
	
	@Test
	void convertToColumnNumber2() {
		assertEquals(1, ec.convertToColumnNumber2("A"));
		assertEquals(2, ec.convertToColumnNumber2("B"));
		assertEquals(26, ec.convertToColumnNumber2("Z"));
		assertEquals(27, ec.convertToColumnNumber2("AA"));
		assertEquals(28, ec.convertToColumnNumber2("AB"));
		assertEquals(701, ec.convertToColumnNumber2("ZY"));
		assertEquals(1, ec.convertToColumnNumber2("A"));
	}

}
