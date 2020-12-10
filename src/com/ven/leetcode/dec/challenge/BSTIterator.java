package com.ven.leetcode.dec.challenge;

import java.util.ArrayDeque;

import com.ven.leetcode.tree.TreeNode;

public class BSTIterator {
	ArrayDeque<Integer> q = new ArrayDeque<>();

	public BSTIterator(TreeNode root) {
		if (root != null) {
			initialize(root);
		}
	}

	public void initialize(TreeNode node) {
		if(node == null){
            return;
        }
        initialize(node.left); 
        q.offer(node.val);
        initialize(node.right);
	}

	/** @return the next smallest number */
	public int next() {
		return q.poll();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !q.isEmpty();
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
