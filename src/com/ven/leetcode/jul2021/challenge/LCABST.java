package com.ven.leetcode.jul2021.challenge;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of
 * two given nodes in the BST.
 * 
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor
 * is defined between two nodes p and q as the lowest node in T that has both p
 * and q as descendants (where we allow a node to be a descendant of itself).”
 * 
 * Example 1:
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8 Output: 6
 * Explanation: The LCA of nodes 2 and 8 is 6. Example 2:
 * 
 * Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4 Output: 2
 * Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant
 * of itself according to the LCA definition. Example 3:
 * 
 * Input: root = [2,1], p = 2, q = 1 Output: 2
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [2, 105]. -109 <= Node.val <=
 * 109 All Node.val are unique. p != q p and q will exist in the BST.
 * 
 * @author Venkatesh Manohar
 *
 */

public class LCABST {
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


}
