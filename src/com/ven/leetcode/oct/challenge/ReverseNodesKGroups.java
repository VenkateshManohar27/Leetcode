package com.ven.leetcode.oct.challenge;

import java.util.Stack;

import com.ven.leetcode.linkedlist.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes in
 * the end should remain as it is.
 * 
 * Example:
 * 
 * Given this linked list: 1->2->3->4->5
 * 
 * For k = 2, you should return: 2->1->4->3->5
 * 
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * Note:
 * 
 * Only constant extra memory is allowed. You may not alter the values in the
 * list's nodes, only nodes itself may be changed.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseNodesKGroups {
	public ListNode reverseKGroup(ListNode head, int k) {
		Stack<ListNode> s = new Stack<ListNode>();
		if (head == null || head.next == null) {
			return head;
		}
		int count = 0;
		ListNode curr = head;
		while (curr != null) {
			curr = curr.next;
			count++;
		}
		if (k > count) {
			return head;
		}

		ListNode dummy = new ListNode();
		ListNode prevEnd = null;
		curr = head;

		while (curr != null) {
			int c = k;
			while (curr != null && c > 0) {
				s.push(curr);
				ListNode next = curr.next;
				curr.next = null;
				curr = next;
				c--;
			}
			count -= k;
			ListNode temp = process(s, k);
			if (dummy.next == null) {
				dummy.next = temp;
				prevEnd = dummy;
				while (prevEnd.next != null) {
					prevEnd = prevEnd.next;
				}
			} else {
				prevEnd.next = temp;
				while (prevEnd.next != null) {
					prevEnd = prevEnd.next;
				}
			}
		}

		return dummy.next;
	}

	private ListNode process(Stack<ListNode> s, int count) {
		ListNode newHead = null;
		if (s.size() == count) {
			ListNode prev = null;
			while (!s.isEmpty()) {
				ListNode curr = s.pop();
				if (newHead == null) {
					newHead = curr;
					prev = curr;
				} else {
					prev.next = curr;
					prev = curr;
				}
			}
		} else {
			while (!s.isEmpty()) {
				ListNode curr = s.pop();
				if (newHead == null) {
					newHead = curr;
				} else {
					curr.next = newHead;
					newHead = curr;
				}
			}
		}

		return newHead;
	}

}
