package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LevelOrderTraversalBTTest {
	LevelOrderTraversalBT lot = new LevelOrderTraversalBT();
	private static TreeNode treeroot1 = null;
	private static TreeNode treeroot2 = null;
	


	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		treeroot1 = new TreeNode(20);
		treeroot1.left = new TreeNode(15);
		treeroot1.right = new TreeNode(25);

		treeroot2 = new TreeNode(30);
		treeroot2.left = new TreeNode(20);
		treeroot2.right = new TreeNode(35);
		treeroot2.left.left = new TreeNode(10);
		treeroot2.left.right = new TreeNode(25);
		treeroot2.left.left.left = new TreeNode(7);
		treeroot2.left.left.right = new TreeNode(15);
		treeroot2.left.right.left = new TreeNode(23);
		treeroot2.left.right.right = new TreeNode(27);
		
		
	}
	
	@Test
	void testNull() {
		List<List<Integer>> li = lot.levelOrder(null);
		assertEquals(0, li.size());
	
	}

	@Test
	void test() {
		List<List<Integer>> li = lot.levelOrder(treeroot1);
		assertEquals(2, li.size());
		assertEquals(1, li.get(0).size());
		assertEquals(20, li.get(0).get(0));
		assertEquals(2, li.get(1).size());
		assertEquals(15, li.get(1).get(0));
		assertEquals(25, li.get(1).get(1));
	}
	
	@Test
	void test2() {
		
		List<List<Integer>> li = lot.levelOrder(treeroot2);
		assertEquals(4, li.size());
		assertEquals(1, li.get(0).size());
		assertEquals(30, li.get(0).get(0));
		assertEquals(2, li.get(1).size());
		assertEquals(20, li.get(1).get(0));
		assertEquals(35, li.get(1).get(1));
		assertEquals(2, li.get(2).size());
		assertEquals(10, li.get(2).get(0));
		assertEquals(25, li.get(2).get(1));
		assertEquals(4, li.get(3).size());
		assertEquals(7, li.get(3).get(0));
		assertEquals(15, li.get(3).get(1));
		assertEquals(23, li.get(3).get(2));
		assertEquals(27, li.get(3).get(3));
	}

}
