package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/*
 * Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
 */
class InvertBinaryTreeTest {
	private InvertBinaryTree ibt = new InvertBinaryTree();
	private static TreeNode root1;
	@BeforeAll
	public static void setUp() {
		root1 =  new TreeNode(4);
		root1.left =  new TreeNode(2);
		root1.left.left =  new TreeNode(1);
		root1.left.right =  new TreeNode(3);
		root1.right =  new TreeNode(7);
		root1.right.left =  new TreeNode(6);
		root1.right.right =  new TreeNode(9);
		
		
	}
	
	@Test
	void test() {
		TreeNode result = ibt.invertTree(root1);
		assertEquals(4, result.val);
		assertEquals(7, result.left.val);
		assertEquals(2, result.right.val);
		assertEquals(9, result.left.left.val);
		assertEquals(6, result.left.right.val);
		assertEquals(3, result.right.left.val);
		assertEquals(1, result.right.right.val);
	}

}
