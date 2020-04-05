package com.ven.leetcode.tree.binarytree;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.ven.leetcode.tree.TreeNode;

class SumRoottoLeafNumbersTest {
	SumRoottoLeafNumbers sln = new SumRoottoLeafNumbers();
	static TreeNode tree1 = null;
	static TreeNode tree2 = null;
	static TreeNode tree3 = null;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tree1 = new TreeNode(1);
		tree1.left = new TreeNode(2);
		tree1.right = new TreeNode(3);
		
		tree2 = new TreeNode(4);
		tree2.left = new TreeNode(9);
		tree2.right = new TreeNode(0);
		tree2.left.left = new TreeNode(5);
		
		tree3 = new TreeNode(4);
		tree3.left = new TreeNode(9);
		tree3.right = new TreeNode(0);
		tree3.left.left = new TreeNode(5);
		tree3.left.right = new TreeNode(1);
	}

	@Test
	void test() {
		assertEquals(25, sln.sumNumbers(tree1));
	}
	
	@Test
	void test2() {
		assertEquals(535, sln.sumNumbers(tree2));
	}
	
	@Test
	void test3() {
		assertEquals(1026, sln.sumNumbers(tree3));
	}
	
	@Test
	void testEfficient1() {
		assertEquals(25, sln.sumNumbersEfficient(tree1));
	}
	
	@Test
	void testEfficient2() {
		assertEquals(535, sln.sumNumbersEfficient(tree2));
	}
	
	@Test
	void testEfficient3() {
		assertEquals(1026, sln.sumNumbersEfficient(tree3));
	}

}
