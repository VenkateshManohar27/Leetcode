package com.ven.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BTInorderIterativeTraversal {

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> tr = new ArrayList<Integer>();
		if (root == null) {
			return tr;
		}

		Stack<TreeNode> st = new Stack<TreeNode>();
		while (true) {
			if (root != null) {
				st.push(root);
				root = root.left;

			} else {
				if (st.isEmpty()) {
					break;
				}
				root = st.pop();
				tr.add(root.val);
				if (root != null)
					root = root.right;
			}
		}
		return tr;
	}

}
