package com.ven.leetcode.tree;

public class LowestCommonAncestor {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (!covers(root, p) || !covers(root, q)) {
			return null;
		} else if (covers(p, q)) {
			return p;
		} else if (covers(q, p)) {
			return q;
		}

		return ancestorHelper(root, p, q);

	}

	private TreeNode ancestorHelper(TreeNode node, TreeNode p, TreeNode q) {
		if (node == null || node == p || node == q) {
			return node;
		}
		boolean pIsOnLeft = covers(node.left, p);
		boolean qIsOnLeft = covers(node.left, q);
		if (pIsOnLeft != qIsOnLeft) {
			return node;
		}
		TreeNode childSide = (pIsOnLeft) ? node.left : node.right;
		return ancestorHelper(childSide, p, q);
	}

	private boolean covers(TreeNode root, TreeNode node) {
		if (root == null) {
			return false;
		}
		if (root == node) {
			return true;
		}
		return covers(root.left, node) || covers(root.right, node);
	}

	/*
	 * public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q,
	 * TreeNode parent) { if (root == null) { return null; } if ((root.val == p.val
	 * && covers(root, q)) || (root.val == q.val && covers(root, p))) { return root;
	 * } else if (root.val == p.val || root.val == q.val) { return parent; }
	 * TreeNode leftParent = lowestCommonAncestor(root.left, p, q, root); TreeNode
	 * rightParent = lowestCommonAncestor(root.right, p, q, root); if(leftParent ==
	 * null) {
	 * 
	 * }
	 * 
	 * if (leftParent == root && rightParent == root) { return root; } else { return
	 * parent; } }
	 */

}
