package com.ven.leetcode.dec.challenge;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as:
 * 
 * a binary tree in which the left and right subtrees of every node differ in
 * height by no more than 1.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: true Example 2:
 * 
 * 
 * Input: root = [1,2,2,3,3,null,null,4,4] Output: false Example 3:
 * 
 * Input: root = [] Output: true
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 5000]. -104 <= Node.val
 * <= 104
 * 
 * @author Venkatesh Manohar
 *
 */
class BBResult {
	int height = 0;

	public BBResult() {

	}

	public BBResult(int h) {
		height = h;
	}

	public String toString() {
		return "Height:" + height;
	}

}

public class BalancedBinaryTree {
	boolean balanced = true;

	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		BBResult r = helper(root);
		return r != null;
	}

	private BBResult helper(TreeNode node) {
		if (node == null) {
			return new BBResult();
		}
		if (!balanced) {
			return null;
		}
		System.out.println(node.val);
		BBResult left = helper(node.left);
		if (!balanced) {
			return null;
		}
		System.out.println("left:" + left.height);
		BBResult right = helper(node.right);
		if (!balanced) {
			return null;
		}
		System.out.println("right:" + right.height);
		if (Math.abs(left.height - right.height) > 1) {
			System.out.println("left:" + left.height);
			System.out.println("right:" + right.height);
			balanced = false;
			return null;
		}
		return new BBResult(Math.max(left.height, right.height) + 1);

	}
}
