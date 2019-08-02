package com.ven.leetcode.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Find the sum of all left leaves in a given binary tree.
 * 
 * Example: 3 / \ 9 20 / \ 15 7
 * 
 * 
 * There are two left leaves in the binary tree, with values 9 and 15
 * respectively. Return 24.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SumofLeftLeaves {
	public int sumOfLeftLeaves(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		sumOfLeftLeaves(root, list, false);
		return list.stream().mapToInt(Integer::intValue).sum();
	}

	private void sumOfLeftLeaves(TreeNode node, List<Integer> list, boolean isLeft) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			list.add((isLeft) ? node.val : 0);
		}
		sumOfLeftLeaves(node.left, list, true);
		sumOfLeftLeaves(node.right, list, false);

	}

	public int sumOfLeftLeavesWithoutExtraSpace(TreeNode root) {
		return sumOfLeftLeavesWithoutExtraSpace(root, false);
	}

	private int sumOfLeftLeavesWithoutExtraSpace(TreeNode node, boolean isLeft) {
		if (node == null) {
			return 0;
		}
		if (node.left == null && node.right == null) {
			return (isLeft) ? node.val : 0;
		}
		return sumOfLeftLeavesWithoutExtraSpace(node.left, true) + sumOfLeftLeavesWithoutExtraSpace(node.right, false);

	}

	public static TreeNode stringToTreeNode(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return null;
		}

		String[] parts = input.split(",");
		String item = parts[0];
		TreeNode root = new TreeNode(Integer.parseInt(item));
		Queue<TreeNode> nodeQueue = new LinkedList<>();
		nodeQueue.add(root);

		int index = 1;
		while (!nodeQueue.isEmpty()) {
			TreeNode node = nodeQueue.remove();

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int leftNumber = Integer.parseInt(item);
				node.left = new TreeNode(leftNumber);
				nodeQueue.add(node.left);
			}

			if (index == parts.length) {
				break;
			}

			item = parts[index++];
			item = item.trim();
			if (!item.equals("null")) {
				int rightNumber = Integer.parseInt(item);
				node.right = new TreeNode(rightNumber);
				nodeQueue.add(node.right);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			TreeNode root = stringToTreeNode(line);

			int ret = new SumofLeftLeaves().sumOfLeftLeaves(root);

			String out = String.valueOf(ret);

			System.out.print(out);
		}
	}
}
