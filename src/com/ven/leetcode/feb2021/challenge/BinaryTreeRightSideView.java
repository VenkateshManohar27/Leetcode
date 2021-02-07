package com.ven.leetcode.feb2021.challenge;

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
		List<Integer> l = new ArrayList<>();
		if (root == null) {
			return l;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		int level = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			TreeNode last = null;
			while (size > 0) {
				last = q.poll();
				if (last.left != null) {
					q.add(last.left);
				}
				if (last.right != null) {
					q.add(last.right);
				}
				size--;
			}
			l.add(level, last.val);
			level++;
		}

		return l;
	}
}
