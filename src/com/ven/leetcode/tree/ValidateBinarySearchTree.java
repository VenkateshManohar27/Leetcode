package com.ven.leetcode.tree;

public class ValidateBinarySearchTree {
	public boolean isValidBST(TreeNode root) {
		boolean result = true;
		if (root == null || (root.left == null && root.right == null)) {
			return result;
		}
		return isValidBST(Long.MIN_VALUE, Long.MAX_VALUE, root);
	}

	private boolean isValidBST(long minVal, long maxVal, TreeNode node) {
		if (node == null) {
			return true;
		}

		if (node.val <= minVal || node.val >= maxVal) {
			return false;
		}

		return isValidBST(minVal, node.val, node.left) && isValidBST(node.val, maxVal, node.right);
	}
}
