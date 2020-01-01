package com.ven.leetcode.tree;

import java.util.Stack;

public class BSTIterator {
	Stack<Integer> st = new Stack<>();

	public BSTIterator(TreeNode root) {
		if (root != null) {
			initialize(root);
		}
	}

	public void initialize(TreeNode node) {
		if (node.right != null) {
			initialize(node.right);
		}
		if (node != null) {
			st.push(node.val);
		}
		if (node.left != null) {
			initialize(node.left);
		}
	}

	/** @return the next smallest number */
	public int next() {
		return st.pop();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !st.isEmpty();
	}

	public static void main(String[] args) {
		TreeNode node = new TreeNode(7);
		node.left = new TreeNode(3);
		node.right = new TreeNode(15);
		node.right.left = new TreeNode(9);
		node.right.right = new TreeNode(20);
		BSTIterator bst = new BSTIterator(node);
		while (bst.hasNext()) {
			System.out.println(bst.next());
		}
	}
}
