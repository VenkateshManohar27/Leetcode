package com.ven.amazon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.tree.TreeNode;

class BinaryTreeRightSideViewTest {
	BinaryTreeRightSideView brsv = new BinaryTreeRightSideView();
	private static TreeNode treeroot1 = null;
	private static TreeNode treeroot2 = null;
	private static TreeNode treeroot3 = null;

	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		treeroot1 = new TreeNode(20);
		treeroot1.left = new TreeNode(15);
		treeroot1.right = new TreeNode(25);

		treeroot2 = new TreeNode(30);
		treeroot2.left = new TreeNode(20);
		
		treeroot3 = new TreeNode(1);
		treeroot3.left = new TreeNode(2);
		treeroot3.left.right = new TreeNode(5);
	}
	
	@Test
	void testBinaryTreeRightSideViewWithNull() {
		List<Integer> list = brsv.rightSideView(null);
		assertEquals(0, list.size());
	}

	@Test
	void testBinaryTreeRightSideViewTreeRoot1() {
		List<Integer> list = brsv.rightSideView(treeroot1);
		assertEquals(2, list.size());
		assertEquals(20, list.get(0));
		assertEquals(25, list.get(1));
	}
	
	@Test
	void testBinaryTreeRightSideViewTreeRoot2() {
		List<Integer> list = brsv.rightSideView(treeroot2);
		assertEquals(2, list.size());
		assertEquals(30, list.get(0));
		assertEquals(20, list.get(1));
	}

	@Test
	void testBinaryTreeRightSideViewTreeRoot3() {
		List<Integer> list = brsv.rightSideView(treeroot3);
		assertEquals(3, list.size());
		assertEquals(1, list.get(0));
		assertEquals(2, list.get(1));
		assertEquals(5, list.get(2));
	}
}
