package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class LowestCommonAncestorTest {
	LowestCommonAncestor lca = new LowestCommonAncestor();
	private static TreeNode treeroot1 = null;
	private static TreeNode treeroot2 = null;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
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
	void test() {
		TreeNode ancestor = lca.lowestCommonAncestor(treeroot1, treeroot1.left, treeroot1.right);

		assertEquals(treeroot1, ancestor);
	}

	void test2() {
		TreeNode ancestor = lca.lowestCommonAncestor(treeroot2, treeroot2.left.left, treeroot2.left.right);

		assertEquals(treeroot2.left, ancestor);
	}
}
