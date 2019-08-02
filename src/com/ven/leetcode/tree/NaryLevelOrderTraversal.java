package com.ven.leetcode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Node {
	public int val;
	public List<Node> children;

	public Node() {
	}

	public Node(int _val, List<Node> _children) {
		val = _val;
		children = _children;
	}
}

/**
 * Given an n-ary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 * 
 * For example, given a 3-ary tree:
 * 
 * We should return its level order traversal:
 * 
 * [ [1], [3,2,4], [5,6] ]
 * 
 * @author Venkatesh Manohar
 *
 */
public class NaryLevelOrderTraversal {
	/*
	 * Runtime: 4 ms, faster than 14.78% of Java online submissions for N-ary Tree
	 * Level Order Traversal. Memory Usage: 49.9 MB, less than 21.03% of Java online
	 * submissions for N-ary Tree Level Order Traversal.
	 */
	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> levelOrder = new ArrayList<>();
		if (root == null)
			return levelOrder;
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			List<Integer> levelNodes = new ArrayList<>();
			Queue<Node> temp = new LinkedList<>();
			while (!q.isEmpty()) {
				Node node = q.poll();
				levelNodes.add(node.val);
				if (node.children != null) {
					for (Node children : node.children) {
						temp.add(children);
					}
				}
			}

			q.addAll(temp);
			levelOrder.add(levelNodes);
		}

		return levelOrder;
	}

	/*
	 * Runtime: 1 ms, faster than 100.00% of Java online submissions for N-ary Tree
	 * Level Order Traversal. Memory Usage: 49.4 MB, less than 24.97% of Java online
	 * submissions for N-ary Tree Level Order Traversal.
	 */
	public List<List<Integer>> levelOrder2(Node root) {
		List<List<Integer>> levelOrder = new ArrayList<>();
		if (root == null)
			return levelOrder;
		levelOrder(0, root, levelOrder);
		return levelOrder;
	}

	public void levelOrder(int level, Node node, List<List<Integer>> levelOrder) {
		if (node == null)
			return;
		if (level == levelOrder.size()) {
			levelOrder.add(new ArrayList<Integer>());
		}
		levelOrder.get(level).add(node.val);
		if (node.children != null) {
			for (Node child : node.children) {
				levelOrder(level + 1, child, levelOrder);
			}
		}
	}

}
