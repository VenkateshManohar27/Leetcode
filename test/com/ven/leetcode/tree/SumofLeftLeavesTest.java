package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

/**
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
 * @author Venkatesh Manohar
 *
 */
class SumofLeftLeavesTest {
	SumofLeftLeaves sl = new SumofLeftLeaves();
	private static TreeNode treeroot1 = null;
	private static TreeNode treeroot2 = null;
	private static TreeNode treeroot3 = null;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		treeroot1 = new TreeNode(3);
		treeroot1.left = new TreeNode(9);
		treeroot1.right = new TreeNode(20);
		treeroot1.right.left = new TreeNode(15);
		treeroot1.right.right = new TreeNode(7);
		
		treeroot2 = new TreeNode(30);
		treeroot2.left = new TreeNode(20);
		treeroot2.right = new TreeNode(35);
		treeroot2.left.left = new TreeNode(10);
		treeroot2.left.right = new TreeNode(25);
		treeroot2.left.left.left = new TreeNode(7);
		treeroot2.left.left.right = new TreeNode(15);
		treeroot2.left.right.left = new TreeNode(23);
		treeroot2.left.right.right = new TreeNode(27);
		
		treeroot3 = new TreeNode(1);
		treeroot3.left = new TreeNode(2);
		treeroot3.right = new TreeNode(3);
		treeroot3.left.left = new TreeNode(4);
		treeroot3.left.right = new TreeNode(5);
	}

	@Test
	void test() {
		assertEquals(24, sl.sumOfLeftLeaves(treeroot1));
	}

	@Test
	void test2() {
		assertEquals(30, sl.sumOfLeftLeaves(treeroot2));
	}
	
	@Test
	void test3() {
		assertEquals(4, sl.sumOfLeftLeaves(treeroot3));
	}
	
	@Test
	void testSumofLeftLeavesWithoutExtraSpace() {
		assertEquals(24, sl.sumOfLeftLeavesWithoutExtraSpace(treeroot1));
	}

	@Test
	void testSumofLeftLeavesWithoutExtraSpace2() {
		assertEquals(30, sl.sumOfLeftLeaves(treeroot2));
	}
	
	@Test
	void testSumofLeftLeavesWithoutExtraSpace3() {
		assertEquals(4, sl.sumOfLeftLeaves(treeroot3));
	}
}
