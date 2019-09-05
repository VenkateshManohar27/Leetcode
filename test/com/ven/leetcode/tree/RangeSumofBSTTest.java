package com.ven.leetcode.tree;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RangeSumofBSTTest {
	RangeSumofBST rsbst = new RangeSumofBST();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15 Output: 32
	 */
	@Test
	void testInput1() {
		TreeNode root = stringToTreeNode("[10,5,15,3,7,null,18]");
		assertEquals(32, rsbst.rangeSumBST(root, 7, 15));
	}

	/**
	 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10 Output: 23
	 */
	@Test
	void testInput2() {
		TreeNode root = stringToTreeNode("[10,5,15,3,7,13,18,1,null,6]");
		assertEquals(23, rsbst.rangeSumBST(root, 6, 10));
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
