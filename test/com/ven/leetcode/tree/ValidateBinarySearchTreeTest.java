package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ValidateBinarySearchTreeTest {
	ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@Test
	void test() {
		TreeNode root = stringToTreeNode("[2,1,3]");
		assertTrue(vbst.isValidBST(root));
	}

	@Test
	void test2() {
		TreeNode root = stringToTreeNode("[5,1,4,null,null,3,6]");
		assertFalse(vbst.isValidBST(root));
	}

	@Test
	void test3() {
		TreeNode root = stringToTreeNode("[10,5,15,null,null,6,20]");
		assertFalse(vbst.isValidBST(root));
	}

	@Test
	void test4() {
		TreeNode root = stringToTreeNode("[1,1]");
		assertFalse(vbst.isValidBST(root));
	}
	
	@Test
	void test5() {
		TreeNode root = stringToTreeNode("[-2147483648,-2147483648]");
		assertFalse(vbst.isValidBST(root));
	}
	
	@Test
	void test6() {
		TreeNode root = stringToTreeNode("[-2147483648,null,2147483647]");
		assertTrue(vbst.isValidBST(root));
	}
	

	private static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}
}
