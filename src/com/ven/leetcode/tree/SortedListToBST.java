package com.ven.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

import com.ven.leetcode.linkedlist.ListNode;

/**
 * Given a singly linked list where elements are sorted in ascending order,
 * convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * @author Venkatesh Manohar
 *
 */
public class SortedListToBST {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		List<ListNode> li = new ArrayList<ListNode>();
		ListNode curr = head;
		while (curr != null) {
			li.add(curr);
			curr = curr.next;
		}

		TreeNode node = generateBST(li, 0, li.size() - 1);
		return node;
	}

	private TreeNode generateBST(List<ListNode> li, int start, int end) {

		if (start > end) {
			return null;
		}
		int mid = start+ (end - start) / 2;
		ListNode currNode = li.get(mid);

		TreeNode node = new TreeNode(currNode.getVal());
		node.left = generateBST(li, start, mid - 1);
		node.right = generateBST(li, mid + 1, end);

		return node;
	}

}
