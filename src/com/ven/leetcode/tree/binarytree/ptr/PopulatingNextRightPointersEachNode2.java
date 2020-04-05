package com.ven.leetcode.tree.binarytree.ptr;

import java.util.LinkedList;
import java.util.Queue;

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
public class PopulatingNextRightPointersEachNode2 {
	public Node connect(Node root) {
		if (root == null) {
			return root;
		}
		Queue<LevelNode> q = new LinkedList<LevelNode>();
		q.add(new LevelNode(root, 0));
		while (!q.isEmpty()) {
			LevelNode n = q.remove();
			if (!q.isEmpty()) {
				LevelNode next = q.peek();
				if (next != null) {
					if (n.level == next.level) {
						n.node.next = next.node;
					}
				}
			}

			if (n.node.left != null) {
				q.add(new LevelNode(n.node.left, n.level + 1));
			}

			if (n.node.right != null) {
				q.add(new LevelNode(n.node.right, n.level + 1));
			}
		}

		return root;
	}

	class LevelNode {
		Node node;
		int level;

		public LevelNode(Node node, int level) {
			super();
			this.node = node;
			this.level = level;
		}

	}
}
