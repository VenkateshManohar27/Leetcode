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
public class BinaryTreefromPreorderandInorder {
	
	HashMap<Integer, Integer> inorderIndexMap = new HashMap<>();
	int prestart = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		for (int i = 0; i < inorder.length; i++) {
			inorderIndexMap.put(inorder[i], i);
		}
		return helper(preorder, inorder, 0, preorder.length);
	}

	private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
		
		if(prestart > preorder.length-1 || start > end) {
			return null;
		}
		
		TreeNode node = new TreeNode(preorder[prestart++]);
		
		int index = inorderIndexMap.get(node.val);
		node.left = helper(preorder, inorder, start, index -1);
		node.right = helper(preorder, inorder, index+1, end);
		return node;
	}

	private void printInorder(TreeNode node) {
		if (node != null) {
			printInorder(node.left);
			System.out.print(node.val + ",");
			printInorder(node.right);
		}
	}

	private void printPreorder(TreeNode node) {
		if (node != null) {
			System.out.print(node.val + ",");
			printPreorder(node.left);
			printPreorder(node.right);
		}
	}

	public static void main(String[] args) {
		BinaryTreefromPreorderandInorder b = new BinaryTreefromPreorderandInorder();
		TreeNode n = b.buildTree(new int[] { 3, 9, 20, 15, 7 }, new int[] { 9, 3, 15, 20, 7 });
		b.printPreorder(n);
		System.out.println();
		b.printInorder(n);
	}
}
