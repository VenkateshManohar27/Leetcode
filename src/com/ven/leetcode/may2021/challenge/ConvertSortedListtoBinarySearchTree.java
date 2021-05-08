package com.ven.leetcode.may2021.challenge;


import com.ven.leetcode.linkedlist.ListNode;
import com.ven.leetcode.tree.TreeNode;

/**
 * Given the head of a singly linked list where elements are sorted in ascending
 * order, convert it to a height balanced BST.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more
 * than 1.
 * 
 * Example 1:
 * 
 * Input: head = [-10,-3,0,5,9] Output: [0,-3,9,-10,null,5] Explanation: One
 * possible answer is [0,-3,9,-10,null,5], which represents the shown height
 * balanced BST. Example 2:
 * 
 * Input: head = [] Output: [] Example 3:
 * 
 * Input: head = [0] Output: [0] Example 4:
 * 
 * Input: head = [1,3] Output: [3,1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in head is in the range [0, 2 * 104]. -10^5 <= Node.val
 * <= 10^5
 * 
 * @author Venkatesh Manohar
 *
 */
public class ConvertSortedListtoBinarySearchTree {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode fast = head;
		ListNode slow = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			prev = slow;
			slow = slow.next;
		}

		if (fast == slow)
			return new TreeNode(slow.val);

		TreeNode node = new TreeNode(slow.val);
		prev.next = null;
		node.left = sortedListToBST(head);
		node.right = sortedListToBST(slow.next);

		return node;
	}
}
