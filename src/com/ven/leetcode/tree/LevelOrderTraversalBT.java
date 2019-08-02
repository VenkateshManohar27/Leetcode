package com.ven.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversalBT {
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> li = new ArrayList<List<Integer>>();
		if (root == null)
			return li;

		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);

		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> levelorder = new ArrayList<>();
			while (!q.isEmpty() && size > 0) {
				TreeNode node = q.poll();
				levelorder.add(node.val);
				size--;
				if (node.left != null) {
					q.add(node.left);
				}
				if (node.right != null) {
					q.add(node.right);
				}

			}
			li.add(levelorder);
		}

		return li;
	}
}
