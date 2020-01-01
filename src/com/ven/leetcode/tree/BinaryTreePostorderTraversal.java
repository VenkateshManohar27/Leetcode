package com.ven.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> li = new ArrayList<Integer>();
		if (root == null) {
			return li;
		}
		Stack<TreeNode> st = new Stack<TreeNode>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode node = st.pop();
			li.add(0, node.val);

			if (node.left != null) {
				st.push(node.left);
			}
			if (node.right != null) {
				st.push(node.right);
			}
		}
		return li;
	}
}
