package com.ven.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalReversal {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		while (!q.isEmpty()) {
			ArrayList<Integer> levelList = new ArrayList<>();
			int s = q.size();
			for (int i = 0; i < s; i++) {
				TreeNode node = q.poll();
				levelList.add(node.val);
				if (node.left != null) {
					q.offer(node.left);
				}
				if (node.right != null) {
					q.offer(node.right);
				}

			}
			list.add(0, levelList);
		}
		return list;
	}
}
