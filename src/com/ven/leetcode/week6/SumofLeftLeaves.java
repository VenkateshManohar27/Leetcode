package com.ven.leetcode.week6;

import com.ven.leetcode.tree.TreeNode;

/**
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example:
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SumofLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		return sumOfLeftLeaves(root, false);
	}

	public int sumOfLeftLeaves(TreeNode root, boolean left) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			if (left) {
				return root.val;
			} else {
				return 0;
			}
		}

		return sumOfLeftLeaves(root.left, true) + sumOfLeftLeaves(root.right, false);
	}
}
