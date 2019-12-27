package com.ven.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversalBT {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> lo = new ArrayList<List<Integer>>();
		if (root == null) {
			return lo;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(root);
		boolean asc = true;
		while (!q.isEmpty()) {
			int size = q.size();
			ArrayList<Integer> orders = new ArrayList<>();
			while (size > 0) {
				TreeNode node = q.poll();
				if(node.left != null) {
					q.add(node.left);
				}
				if(node.right != null) {
					q.add(node.right);
				}
				if (asc) {
					orders.add(node.val);
				} else {
					orders.add(0, node.val);
				}
				size--;
			}
			lo.add(orders);
			asc = !asc;
		}

		return lo;
	}
}
