package com.ven.leetcode.easy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BalancedTreeTest {
	static TreeNode tree1, tree2, tree3 ;
	BalancedTree bt = new BalancedTree();
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tree1 = new TreeNode(3);
		tree1.left = new TreeNode(9);
		tree1.right = new TreeNode(20);
		tree1.right.left = new TreeNode(15);
		tree1.right.right = new TreeNode(7);
		
		tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		tree2.right = new TreeNode(2);
		tree2.left.left = new TreeNode(3);
		tree2.left.right = new TreeNode(3);
		tree2.left.left.left = new TreeNode(4);
		tree2.left.left.right = new TreeNode(4);
		
		tree3 = new TreeNode(1);
		tree3.left = new TreeNode(2);
		tree3.right = new TreeNode(2);
		tree3.left.left = new TreeNode(3);
		tree3.left.left.left = new TreeNode(4);
		tree3.right.right = new TreeNode(3);
		tree3.right.right.right = new TreeNode(4);
		
		
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testHappyPath() {
		assertTrue(bt.isBalanced(tree1));
	}
	
	@Test
	void testNull() {
		assertTrue(bt.isBalanced(null));
	}

	@Test
	void testUnbalanced() {
		assertFalse(bt.isBalanced(tree2));
	}
	
	@Test
	void testUnbalancedtree3() {
		assertFalse(bt.isBalanced(tree3));
	}

}
