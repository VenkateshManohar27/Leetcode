package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ZigZagLevelOrderTraversalBTTest {
	ZigZagLevelOrderTraversalBT z = new ZigZagLevelOrderTraversalBT();
	private static TreeNode treeroot = null;
	private static TreeNode treeroot2 = null;
	private static TreeNode treeroot3 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		treeroot = new TreeNode(3);
		treeroot.left = new TreeNode(9);
		treeroot.right = new TreeNode(20);
		treeroot.right.left = new TreeNode(15);
		treeroot.right.right = new TreeNode(7);

		treeroot2 = new TreeNode(1);
		treeroot2.left = new TreeNode(2);
		treeroot2.right = new TreeNode(3);
		treeroot2.left.left = new TreeNode(4);
		treeroot2.left.right = new TreeNode(5);
		treeroot2.right.left = new TreeNode(6);
		treeroot2.right.right = new TreeNode(7);
		treeroot2.left.left.left = new TreeNode(8);
		treeroot2.left.left.right = new TreeNode(9);
		
		treeroot3 = new TreeNode(1);
		treeroot3.left = new TreeNode(2);
		treeroot3.right = new TreeNode(3);
		treeroot3.left.left = new TreeNode(4);
		treeroot3.right.right = new TreeNode(5);
	
	}

	@Test
	void test() {
		List<List<Integer>> li = z.zigzagLevelOrder(treeroot);
		assertEquals(3, li.size());
		assertEquals(1, li.get(0).size());
		assertEquals(3, li.get(0).get(0));
		assertEquals(2, li.get(1).size());
		assertEquals(20, li.get(1).get(0));
		assertEquals(9, li.get(1).get(1));

		assertEquals(2, li.get(2).size());
		assertEquals(15, li.get(2).get(0));
		assertEquals(7, li.get(2).get(1));

	}

	@Test
	void testTree2() {

		List<List<Integer>> li = z.zigzagLevelOrder(treeroot2);
		assertEquals(4, li.size());
		assertEquals(1, li.get(0).size());
		assertEquals(1, li.get(0).get(0));
		assertEquals(3, li.get(1).get(0));
		assertEquals(2, li.get(1).get(1));

		assertEquals(4, li.get(2).size());
		assertEquals(4, li.get(2).get(0));
		assertEquals(5, li.get(2).get(1));
		assertEquals(6, li.get(2).get(2));
		assertEquals(7, li.get(2).get(3));

		assertEquals(2, li.get(3).size());
		assertEquals(9, li.get(3).get(0));
		assertEquals(8, li.get(3).get(1));
	}
	
	
	@Test
	void testTree3() {

		List<List<Integer>> li = z.zigzagLevelOrder(treeroot3);
		assertEquals(3, li.size());
		assertEquals(1, li.get(0).size());
		assertEquals(1, li.get(0).get(0));
		assertEquals(3, li.get(1).get(0));
		assertEquals(2, li.get(1).get(1));

		assertEquals(2, li.get(2).size());
		assertEquals(4, li.get(2).get(0));
		assertEquals(5, li.get(2).get(1));
		
	}
}
