package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MaxDepthTest {
	static TreeNode tree1;
	MaxDepth md = new MaxDepth();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tree1 = new TreeNode(3);
		tree1.left = new TreeNode(9);
		tree1.right = new TreeNode(20);
		tree1.right.left = new TreeNode(15);
		tree1.right.right = new TreeNode(7);
		
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	
	@Test
	void testNull() {
		assertEquals(0, md.maxDepth(null));
	}
	
	@Test
	void testJustRootNode() {
		assertEquals(1, md.maxDepth(new TreeNode(3)));
	}

	@Test
	void testHappyPath() {
		assertEquals(3, md.maxDepth(tree1));
	}
	
	@Test
	void testNullIterative() {
		assertEquals(0, md.maxDepthIterative(null));
	}
	
	@Test
	void testJustRootNodeIterative() {
		assertEquals(1, md.maxDepthIterative(new TreeNode(3)));
	}

	@Test
	void testHappyPathIterative() {
		assertEquals(3, md.maxDepthIterative(tree1));
	}

}
