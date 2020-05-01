package com.ven.leetcode.tree;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return helper(root.left, root.right);
	}

	private boolean helper(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		
		if (left == null || right == null) {
			return false;
		}

		return helper(left.left, right.right) && helper(left.right, right.left);
	}

}
