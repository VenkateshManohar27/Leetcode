package com.ven.leetcode.jul2021.challenge;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given the root of a binary tree, return the same tree where every subtree (of
 * the given tree) not containing a 1 has been removed.
 * 
 * A subtree of a node node is node plus every node that is a descendant of
 * node.
 * 
 * Example 1:
 * 
 * Input: root = [1,null,0,0,1] Output: [1,null,0,null,1] Explanation: Only the
 * red nodes satisfy the property "every subtree not containing a 1". The
 * diagram on the right represents the answer. Example 2:
 * 
 * Input: root = [1,0,1,0,0,0,1] Output: [1,null,1,null,1] Example 3:
 * 
 * Input: root = [1,1,0,1,1,0,1,0] Output: [1,1,0,1,1,null,1]
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [1, 200]. Node.val is either
 * 0 or 1.
 * 
 * @author Venkatesh Manohar
 *
 */
public class BinaryTreePruning {
	public TreeNode pruneTree(TreeNode root) {
		boolean res = helper(root);
		return (res) ? root : null;
	}

	private boolean helper(TreeNode node) {
		if (node == null) {
			return false;
		}
		if (node.left == null && node.right == null) {
			if (node.val == 0) {
				return false;
			} else {
				return true;
			}
		}

		boolean left = helper(node.left);
		if (!left) {
			node.left = null;
			if (node.val == 1) {
				left = true;
			}
		}
		boolean right = helper(node.right);
		if (!right) {
			node.right = null;
			if (node.val == 1) {
				right = true;
			}
		}

		return left || right;
	}
}
