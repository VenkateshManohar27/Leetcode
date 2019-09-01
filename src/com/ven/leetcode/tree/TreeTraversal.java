package com.ven.leetcode.tree;

public class TreeTraversal {

	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();

		System.out.println("\nBFS traversal of binary tree is ");
		tree.bfs();
		
		System.out.println("\nDFS traversal of binary tree is ");
		tree.dfs();
	}
}
