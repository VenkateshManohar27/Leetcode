package com.ven.leetcode.may2021.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.ven.leetcode.tree.TreeNode;

/**
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7] Output: [[3],[9,20],[15,7]] Example 2:
 * 
 * Input: root = [1] Output: [[1]] Example 3:
 * 
 * Input: root = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the tree is in the range [0, 2000]. -1000 <= Node.val
 * <= 1000
 * 
 * @author Venkatesh Manohar
 *
 */
public class BinaryTreeLevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> l = new ArrayList<>();
		if (root == null) {
			return l;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);

		while (!q.isEmpty()) {
			int size = q.size();
			List<Integer> level = new ArrayList<>();
			while (size > 0) {
				TreeNode node = q.poll();
				level.add(node.val);
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}
				size--;
			}
			l.add(level);
		}

		return l;
	}
}
