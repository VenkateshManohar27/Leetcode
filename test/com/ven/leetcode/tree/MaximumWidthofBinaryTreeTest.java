package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class MaximumWidthofBinaryTreeTest {
	private static TreeNode root1, root2, root3, root4;
	MaximumWidthofBinaryTree mw = new MaximumWidthofBinaryTree();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		root1 = new TreeNode(1);
		root1.left = new TreeNode(3);
		root1.right = new TreeNode(2);
		root1.left.left = new TreeNode(5);
		root1.left.right = new TreeNode(3);
		root1.right.right = new TreeNode(9);

		root2 = new TreeNode(1);
		root2.left = new TreeNode(3);
		root2.left.left = new TreeNode(5);
		root2.left.right = new TreeNode(3);

		root3 = new TreeNode(1);
		root3.left = new TreeNode(3);
		root3.right = new TreeNode(2);
		root3.left.left = new TreeNode(5);

		root4 = new TreeNode(1);
		root4.left = new TreeNode(3);
		root4.right = new TreeNode(2);
		root4.left.left = new TreeNode(5);
		root4.right.right = new TreeNode(9);
		root4.left.left.left = new TreeNode(6);
		root4.right.right.right = new TreeNode(7);
	}

	@Test
	void test1() {
		assertEquals(4, mw.widthOfBinaryTree(root1));
	}

	@Test
	void test2() {
		assertEquals(2, mw.widthOfBinaryTree(root2));
	}

	@Test
	void test3() {
		assertEquals(2, mw.widthOfBinaryTree(root3));
	}

	@Test
	void test4() {
		assertEquals(8, mw.widthOfBinaryTree(root4));
	}
}
