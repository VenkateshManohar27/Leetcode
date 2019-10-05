package com.ven.amazon;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * Example:
 * 
 * Input: [1,2,3,null,5,null,4] Output: [1, 3, 4] Explanation:
 * 
 * 1 <--- / \ 2 3 <--- \ \ 5 4 <---
 * 
 * @author Venkatesh Manohar
 *
 */

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode current = q.remove();
				if (i == size - 1) {
					list.add(current.val);
				}
				if (current.left != null) {
					q.add(current.left);
				}
				if (current.right != null) {
					q.add(current.right);
				}
			}

		}
		return list;
	}
}
