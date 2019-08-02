package com.ven.leetcode.easy;

public class BalancedTree {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		int result = check(root);

		return result != -1;
	}

	private int check(TreeNode node) {
		if (node == null) {
			return 0;
		}
		int left = check(node.left);
		if (left == -1) {
			return left;
		}
		int right = check(node.right);
		if (right == -1) {
			return right;
		}
		int diff = Math.abs(left - right);
		if (diff > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
