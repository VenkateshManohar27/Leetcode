package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BTInorderIterativeTraversalTest {
	BTInorderIterativeTraversal bt = new BTInorderIterativeTraversal();
	private static TreeNode treeroot1 = null;
	private static TreeNode treeroot2 = null;
	private static TreeNode treeroot3 = null;
	
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
		treeroot2.left.left.left = new TreeNode(7);
		treeroot2.left.left.right = new TreeNode(15);
		treeroot2.left.right.left = new TreeNode(23);
		treeroot2.left.right.right = new TreeNode(27);
		
		treeroot3 = new TreeNode(1);
		treeroot3.right = new TreeNode(2);
		treeroot3.right.left = new TreeNode(3);
	}

	@Test
	void testSingleNode() {
		List<Integer> li = bt.inorderTraversal(new TreeNode(1));
		assertEquals(1, li.size());
		assertEquals(1, li.get(0));
	}
	
	@Test
	void testNullNode() {
		List<Integer> li = bt.inorderTraversal(null);
		assertEquals(0, li.size());
		assertTrue(li.isEmpty());
	}

	@Test
	void testTreeroot1() {
		List<Integer> li = bt.inorderTraversal(treeroot1);
		assertEquals(3, li.size());
		assertEquals(15, li.get(0));
		assertEquals(20, li.get(1));
		assertEquals(25, li.get(2));
	}
	
	@Test
	void testTreeroot2() {
		List<Integer> li = bt.inorderTraversal(treeroot2);
		assertEquals(9, li.size());
		assertEquals(7, li.get(0));
		assertEquals(4, li.get(1));
		assertEquals(15, li.get(2));
		assertEquals(2, li.get(3));
		assertEquals(23, li.get(4));
		assertEquals(5, li.get(5));
		assertEquals(27, li.get(6));
		assertEquals(1, li.get(7));
		assertEquals(3, li.get(8));
	}
	
	@Test
	void testTreeroot3() {
		List<Integer> li = bt.inorderTraversal(treeroot3);
		assertEquals(3, li.size());
		assertEquals(1, li.get(0));
		assertEquals(3, li.get(1));
		assertEquals(2, li.get(2));
	}
}
