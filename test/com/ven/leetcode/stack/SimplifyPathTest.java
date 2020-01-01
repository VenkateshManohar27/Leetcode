package com.ven.leetcode.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SimplifyPathTest {
	SimplifyPath sp = new SimplifyPath();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test1() {
		assertEquals("/home", sp.simplifyPath("/home/"));
	}

	@Test
	void test2() {
		assertEquals("/", sp.simplifyPath("/../"));
	}

	@Test
	void test3() {
		assertEquals("/home/foo", sp.simplifyPath("/home//foo/"));
	}

	@Test
	void test4() {
		assertEquals("/c", sp.simplifyPath("/a/./b/../../c/"));
	}

	@Test
	void test5() {
		assertEquals("/c", sp.simplifyPath("/a/../../b/../c//.//"));
	}
	
	@Test
	void test6() {
		assertEquals("/a/b/c", sp.simplifyPath("/a//b////c/d//././/.."));
	}
	
	@Test
	void test7() {
		assertEquals("/", sp.simplifyPath("/."));
		
	}
	
	@Test
	void test8() {
		assertEquals("/...", sp.simplifyPath("/..."));
		
	}
}
