package com.ven.leetcode.easy;

public class PathSum {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;
		int diff = sum - root.val;
		if (diff == 0 && isLeaf(root)) {
			return true;
		}
		return hasPathSum(root.left, diff) || hasPathSum(root.right, diff);
	}

	private boolean isLeaf(TreeNode node) {
		return node.left == null && node.right == null;
	}
}
