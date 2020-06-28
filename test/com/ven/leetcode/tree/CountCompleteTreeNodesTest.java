package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CountCompleteTreeNodesTest {
	CountCompleteTreeNodes c = new CountCompleteTreeNodes();
	private static TreeNode treeroot1 = null;
	private static TreeNode treeroot2 = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		treeroot1 = new TreeNode(20);
		treeroot1.left = new TreeNode(15);
		treeroot1.right = new TreeNode(25);
		
		treeroot2 = new TreeNode(1);
		treeroot2.left = new TreeNode(2);
		treeroot2.right = new TreeNode(3);
		treeroot2.left.left = new TreeNode(4);
		treeroot2.left.right = new TreeNode(5);
		treeroot2.right.left = new TreeNode(6);
	}

	@Test
	void testNull() {
		assertEquals(0, c.countNodes(null));
	}

	@Test
	void test1() {
		assertEquals(3, c.countNodes(treeroot1));
	}
	
	@Test
	void test2() {
		assertEquals(6, c.countNodes(treeroot2));
	}
}
