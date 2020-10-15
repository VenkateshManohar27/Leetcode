package com.ven.leetcode.oct.challenge;

/**
 * Given the head of a linked list, return the list after sorting it in
 * ascending order.
 * 
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory
 * (i.e. constant space)?
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [4,2,1,3] Output: [1,2,3,4] Example 2:
 * 
 * 
 * Input: head = [-1,5,3,4,0] Output: [-1,0,3,4,5] Example 3:
 * 
 * Input: head = [] Output: []
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 5 * 104]. -105 <=
 * Node.val <= 105
 * 
 * @author Venkatesh Manohar
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		return mergeSort(head);
	}

	private ListNode mergeSort(ListNode node) {
		if (node != null && node.next == null) {
			// System.out.println("return node val:"+node.val);
			return node;
		}
		ListNode prev = null, slow = node, fast = node;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = prev.next;
		prev.next = null;
		// System.out.println("node val:"+node.val);
		// System.out.println("mid val:"+mid.val);
		ListNode left = mergeSort(node);

		ListNode right = mergeSort(mid);
		return merge(left, right);
	}

	private ListNode merge(ListNode left, ListNode right) {
		ListNode head = new ListNode();
		ListNode curr = head;

		while (left != null && right != null) {
			if (left.val < right.val) {
				curr.next = left;
				left = left.next;
				curr = curr.next;
			} else {
				curr.next = right;
				right = right.next;
				curr = curr.next;
			}

		}

		while (left != null) {
			curr.next = left;
			left = left.next;
			curr = curr.next;
		}

		while (right != null) {
			curr.next = right;
			right = right.next;
			curr = curr.next;
		}

		return head.next;
	}
}
