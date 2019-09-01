package com.ven.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	TreeNode root = null;

	public BinaryTree() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BinaryTree(TreeNode root) {
		super();
		this.root = root;
	}

	public void printPreorder() {
		printPreorder(root);
	}

	private void printPreorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.val+" ");
			printPreorder(node.left);
			printPreorder(node.right);
		}
	}

	public void printInorder() {
		printInorder(root);
	}

	private void printInorder(TreeNode node) {
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.val+" ");
			printInorder(node.right);
		}
	}

	public void printPostorder() {
		printPostorder(root);
	}

	private void printPostorder(TreeNode node) {
		if (node != null) {
			printPostorder(node.left);
			printPostorder(node.right);
			System.out.print(node.val+" ");
		}
	}
	
	public void bfs() {
		if(root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		
		while(!q.isEmpty()) {
			TreeNode node = q.poll();
			System.out.print(node.val+" ");
			if(node.left != null) {
				q.add(node.left);
			}
			if(node.right != null) {
				q.add(node.right);
			}
		}
		
	}

	public void dfs() {
		// TODO Auto-generated method stub
		printInorder();
	}
	
	public void bfsIterative() {
		
	}
}
