package com.ven.utility;

import com.ven.leetcode.tree.TreeNode;

public class TreeUtility {
	public static TreeNode generateTree(Integer[] arr, int i) {
		if (arr == null || arr.length == 0)
			return null;
		if (i >= arr.length)
			return null;
		TreeNode t = (arr[i] != null) ? new TreeNode(arr[i]) : null;
		if (t != null) {
			t.left = generateTree(arr, 2 * i + 1);
			t.right = generateTree(arr, 2 * i + 2);
		}
		return t;
	}

}
