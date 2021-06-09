package com.ven.leetcode.june2021.challenge;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given two integer arrays preorder and inorder where preorder is the preorder
 * traversal of a binary tree and inorder is the inorder traversal of the same
 * tree, construct and return the binary tree.
 * 
 * Example 1:
 * 
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7] Output:
 * [3,9,20,null,null,15,7] Example 2:
 * 
 * Input: preorder = [-1], inorder = [-1] Output: [-1]
 * 
 * Constraints:
 * 
 * 1 <= preorder.length <= 3000 inorder.length == preorder.length -3000 <=
 * preorder[i], inorder[i] <= 3000 preorder and inorder consist of unique
 * values. Each value of inorder also appears in preorder. preorder is
 * guaranteed to be the preorder traversal of the tree. inorder is guaranteed to
 * be the inorder traversal of the tree.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	private int index = 0;

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		index = 0;
		return helper(0, inorder.length - 1, preorder, inorder);
	}

	private TreeNode helper(int s, int e, int[] preorder, int[] inorder) {
		if (index >= preorder.length)
			return null;
		int val = preorder[index];
		// System.out.println("val:"+val);
		int fin = -1;
		for (int i = s; i <= e; i++) {
			if (inorder[i] == val) {
				fin = i;
				break;
			}
		}
		// System.out.println("fin:"+fin);

		if (fin == -1)
			return null;
		TreeNode node = new TreeNode(val);
		index++;
		node.left = helper(s, fin - 1, preorder, inorder);

		node.right = helper(fin + 1, e, preorder, inorder);

		return node;

	}
}
