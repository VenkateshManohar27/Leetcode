package com.ven.leetcode.dec.challenge;

import com.ven.leetcode.linkedlist.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * You may not modify the values in the list's nodes. Only nodes itself may be
 * changed.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4] Output: [2,1,4,3] Example 2:
 * 
 * Input: head = [] Output: [] Example 3:
 * 
 * Input: head = [1] Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 100]. 0 <= Node.val <=
 * 100
 * 
 * @author Venkatesh Manohar
 *
 */
public class SwapNodesPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode();
		dummy.next = head;
		ListNode prev = dummy;
		ListNode curr = head;
		ListNode next = head.next;

		while (curr != null && next != null) {
			prev.next = next;
			curr.next = next.next;
			next.next = curr;
			prev = curr;
			curr = curr.next;

			next = (curr != null) ? curr.next : null;
		}

		return dummy.next;

	}
}
