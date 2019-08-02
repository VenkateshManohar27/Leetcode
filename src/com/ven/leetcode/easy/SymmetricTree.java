package com.ven.leetcode.easy;

public class SymmetricTree {
	public boolean isSymmetric(TreeNode root) {
		return root == null || check(root.left, root.right);
	}

	private boolean check(TreeNode leftSub, TreeNode rightSub) {
		if (leftSub == null && rightSub == null) {
			return true;
		}
		if (leftSub != null && rightSub != null) {
			return leftSub.val == rightSub.val && check(leftSub.left, rightSub.right)
					&& check(leftSub.right, rightSub.left);
		}
		return false;
	}
}
