package com.ven.leetcode.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class NaryPostOrderTraversal {
	public List<Integer> postorder(Node root) {
		List<Integer> list = new ArrayList<>();
		Stack<Node> stack = new Stack<>();
		Stack<Node> auxStack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			Node current = stack.pop();
			if (current != null) {
				auxStack.push(current);
				if (current.children != null) {
					List<Node> temp = current.children;
					for (int i = 0; i < temp.size(); i++) {
						stack.push(temp.get(i));
					}
				}
			}
		}
		while (!auxStack.isEmpty()) {
			list.add(auxStack.pop().val);
		}
		return list;
	}
}
