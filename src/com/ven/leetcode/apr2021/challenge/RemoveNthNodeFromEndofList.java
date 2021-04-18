package com.ven.leetcode.apr2021.challenge;

import com.ven.leetcode.linkedlist.ListNode;

/**
 * Given the head of a linked list, remove the nth node from the end of the list
 * and return its head.
 * 
 * Follow up: Could you do this in one pass?
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], n = 2 Output: [1,2,3,5] Example 2:
 * 
 * Input: head = [1], n = 1 Output: [] Example 3:
 * 
 * Input: head = [1,2], n = 1 Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is sz. 1 <= sz <= 30 0 <= Node.val <= 100 1
 * <= n <= sz
 * 
 * @author Venkatesh Manohar
 *
 */
public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode tail = head;
		ListNode curr = new ListNode();
		curr.next = head;
		head = curr;
		int steps = 1;
		while (tail != null) {
			if (steps > n)
				curr = curr.next;
			tail = tail.next;
			steps++;
		}

		curr.next = curr.next.next;

		return head.next;
	}
}
