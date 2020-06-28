package com.ven.leetcode.backtracking;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RestoreIPAddressesTest {
	RestoreIPAddresses ra = new RestoreIPAddresses();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void testEmptyString() {
		assertEquals(0, ra.restoreIpAddresses("").size());
	}

	@Test
	void testNull() {
		assertEquals(0, ra.restoreIpAddresses(null).size());
	}

	@Test
	void testInvalidString() {
		assertEquals(0, ra.restoreIpAddresses("000").size());
	}

	@Test
	void testInvalidString2() {
		assertEquals(0, ra.restoreIpAddresses("000A").size());
	}

	@Test
	void testInvalidString3() {
		assertEquals(0, ra.restoreIpAddresses("000!@##").size());
	}

	@Test
	void testInvalidString4() {
		assertEquals(0, ra.restoreIpAddresses("999999999999999999999").size());
	}

	@Test
	void testInvalidString5() {
		assertEquals(0, ra.restoreIpAddresses("000").size());
	}

	@Test
	void testHappyPath() {
		List<String> li = ra.restoreIpAddresses("25525511135");
		assertEquals(2, li.size());
		assertTrue(li.contains("255.255.11.135"));
		assertTrue(li.contains("255.255.111.35"));
	}
	
	@Test
	void testHappyPath2() {
		List<String> li = ra.restoreIpAddresses("010010");
		assertEquals(2, li.size());
	}
	
}
