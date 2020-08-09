package com.ven.leetcode.augchallenge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class VerticalOrderTraversalBinaryTreeTest {
	VerticalOrderTraversalBinaryTree vt = new VerticalOrderTraversalBinaryTree();
	static TreeNode tree1 = null;
	static TreeNode tree2 = null;
	static TreeNode tree3 = null;
	static TreeNode tree4 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tree1 = new TreeNode(3);
		tree1.left = new TreeNode(9);
		tree1.right = new TreeNode(20);
		tree1.right.left = new TreeNode(15);
		tree1.right.right = new TreeNode(17);

		tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		tree2.right = new TreeNode(3);
		tree2.left.left = new TreeNode(4);
		tree2.left.right = new TreeNode(5);
		tree2.right.left = new TreeNode(6);
		tree2.right.right = new TreeNode(7);

		tree3 = new TreeNode(0);
		tree3.left = new TreeNode(8);
		tree3.right = new TreeNode(1);
		tree3.right.left = new TreeNode(3);
		tree3.right.left.right = new TreeNode(4);
		tree3.right.left.right.right = new TreeNode(7);
		tree3.right.right = new TreeNode(2);
		tree3.right.right.left = new TreeNode(5);
		tree3.right.right.left.left = new TreeNode(6);
	}

	@Test
	void testTree1() {
		List<List<Integer>> li = vt.verticalTraversal(tree1);
		assertEquals(4, li.size());
		assertEquals(9, li.get(0).get(0));
		assertEquals(3, li.get(1).get(0));
		assertEquals(15, li.get(1).get(1));
		assertEquals(20, li.get(2).get(0));
		assertEquals(17, li.get(3).get(0));
	}
	
	@Test
	void testTree2() {
		//[[4],[2],[1,5,6],[3],[7]]
		List<List<Integer>> li = vt.verticalTraversal(tree2);
		assertEquals(5, li.size());
		assertEquals(4, li.get(0).get(0));
		assertEquals(2, li.get(1).get(0));
		assertEquals(1, li.get(2).get(0));
		assertEquals(5, li.get(2).get(1));
		assertEquals(6, li.get(2).get(2));
		assertEquals(3, li.get(3).get(0));
		assertEquals(7, li.get(4).get(0));
	}
	//[8],[0,3,6],[1,4,5],[2,7]
	@Test
	void testTree3() {
		
		List<List<Integer>> li = vt.verticalTraversal(tree3);
		assertEquals(4, li.size());
		assertEquals(8, li.get(0).get(0));
		assertEquals(0, li.get(1).get(0));
		assertEquals(3, li.get(1).get(1));
		assertEquals(6, li.get(1).get(2));
		assertEquals(1, li.get(2).get(0));
		assertEquals(4, li.get(2).get(1));
		assertEquals(5, li.get(2).get(2));
		assertEquals(2, li.get(3).get(0));
		assertEquals(7, li.get(3).get(1));
	}
}
