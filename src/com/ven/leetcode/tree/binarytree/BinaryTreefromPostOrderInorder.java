package com.ven.leetcode.tree.binarytree;

import java.util.HashMap;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * 
 * Note: You may assume that duplicates do not exist in the tree.
 * 
 * For example, given
 * 
 * preorder = [3,9,20,15,7] inorder = [9,3,15,20,7] Return the following binary
 * tree:
 * 
 * 3 / \ 9 20 / \ 15 7
 * 
 * @author Venkatesh Manohar
 *
 */
public class BinaryTreefromPostOrderInorder {
	HashMap<Integer, Integer> map = new HashMap<>();
	int postStart = 0;

	public TreeNode buildTree(int[] inorder, int[] postorder) {
		if (postorder == null || inorder == null || postorder.length == 0 || inorder.length == 0)
			return null;

		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		postStart = postorder.length-1;
		TreeNode root = helper(postorder, inorder, 0, postorder.length-1);
		return root;
	}

	private TreeNode helper(int[] postorder, int[] inorder, int inStart, int inEnd) {
		if (postStart < 0 || inStart > inEnd) {
			return null;
		}

		TreeNode node = new TreeNode(postorder[postStart--]);

		int index = map.get(node.val);
		node.right = helper(postorder, inorder, index + 1, inEnd);
		node.left = helper(postorder, inorder, inStart, index - 1);
		return node;
	}

	private void printInorder(TreeNode node) {
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.val + ",");
			printInorder(node.right);
		}
	}

	private void printPostorder(TreeNode node) {
		if (node != null) {
			printPostorder(node.left);
			printPostorder(node.right);
			System.out.print(node.val + ",");
		}
	}

	public static void main(String[] args) {
		BinaryTreefromPostOrderInorder b = new BinaryTreefromPostOrderInorder();
		TreeNode n = b.buildTree(new int[] { 9, 3, 15, 20, 7 }, new int[] { 9, 15, 7, 20, 3 });
		b.printPostorder(n);
		System.out.println();
		b.printInorder(n);
	}
}
