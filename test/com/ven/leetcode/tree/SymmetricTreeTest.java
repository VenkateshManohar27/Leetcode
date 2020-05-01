package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SymmetricTreeTest {
	SymmetricTree st = new SymmetricTree();
	static TreeNode tree1 = null, tree2 = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tree1 = new TreeNode(1);
		tree1.left = new TreeNode(2);
		tree1.right = new TreeNode(2);
		tree1.left.left = new TreeNode(3);
		tree1.left.right = new TreeNode(4);
		tree1.right.left = new TreeNode(4);
		tree1.right.right = new TreeNode(3);
		
		tree2 = new TreeNode(1);
		tree2.left = new TreeNode(2);
		tree2.right = new TreeNode(2);
		tree2.left.right = new TreeNode(3);
		tree2.right.right = new TreeNode(3);
	}

	@Test
	void testNullTree() {
		assertTrue(st.isSymmetric(null));
	}
	
	@Test
	void testSingleNode() {
		assertTrue(st.isSymmetric(new TreeNode(0)));
	}
	
	@Test
	void testValidTree() {
		assertTrue(st.isSymmetric(tree1));
	}
	
	@Test
	void testInvalidTree() {
		assertFalse(st.isSymmetric(tree2));
	}
}
