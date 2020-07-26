package com.ven.leetcode.tree.binarytree.ptr;

/**
 * You are given a perfect binary tree where all leaves are on the same level,
 * and every parent has two children. The binary tree has the following
 * definition:
 * 
 * struct Node { int val; Node *left; Node *right; Node *next; } Populate each
 * next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 * 
 * 
 * 
 * Follow up:
 * 
 * You may only use constant extra space. Recursive approach is fine, you may
 * assume implicit stack space does not count as extra space for this problem.
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * Input: root = [1,2,3,4,5,6,7] Output: [1,#,2,3,#,4,5,6,7,#] Explanation:
 * Given the above perfect binary tree (Figure A), your function should populate
 * each next pointer to point to its next right node, just like in Figure B. The
 * serialized output is in level order as connected by the next pointers, with
 * '#' signifying the end of each level.
 * 
 * @author Venkatesh Manohar
 *
 */
public class PopulatingNextRightPointersEachNode {
	public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		helper(root, null);
		return root;
	}

	private void helper(Node curr, Node next) {
		if (curr == null) {
			return;
		}
		curr.next = next;
		helper(curr.left, curr.right);
		helper(curr.right, (next != null) ? next.left : null);
	}
}