package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
/**
 * 
 * 				20
 * 				/\
 * 			15		25
 * 
 * 
 * 
 * @author Venkatesh Manohar
 *
 */
class BinaryTreePathTest {
	BinaryTreePath btp = new BinaryTreePath();
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
		treeroot3.left.right = new TreeNode(5);
	}

	@Test
	void test() {
		List<String> paths= btp.binaryTreePaths(treeroot1);
		assertEquals("20->15", paths.get(0));
		assertEquals("20->25", paths.get(1));
	}
	
	@Test
	void test2() {
		List<String> paths= btp.binaryTreePaths(treeroot2);
		assertEquals("30->20->10->7", paths.get(0));
		assertEquals("30->20->10->15", paths.get(1));
		assertEquals("30->20->25->23", paths.get(2));
		assertEquals("30->20->25->27", paths.get(3));
		assertEquals("30->35", paths.get(4));
	}

	@Test
	void test3() {
		List<String> paths= btp.binaryTreePaths(treeroot3);
		assertEquals("1->2->5", paths.get(0));
		assertEquals("1->3", paths.get(1));
		
	}
	
	@Test
	void testOptimized() {
		List<String> paths= btp.binaryTreePathsOptimized(treeroot1);
		assertEquals("20->15", paths.get(0));
		assertEquals("20->25", paths.get(1));
	}
	
	@Test
	void test2Optimized() {
		List<String> paths= btp.binaryTreePathsOptimized(treeroot2);
		assertEquals("30->20->10->7", paths.get(0));
		assertEquals("30->20->10->15", paths.get(1));
		assertEquals("30->20->25->23", paths.get(2));
		assertEquals("30->20->25->27", paths.get(3));
		assertEquals("30->35", paths.get(4));
	}

	@Test
	void test3Optimized() {
		List<String> paths= btp.binaryTreePathsOptimized(treeroot3);
		assertEquals("1->2->5", paths.get(0));
		assertEquals("1->3", paths.get(1));
		
	}
}
