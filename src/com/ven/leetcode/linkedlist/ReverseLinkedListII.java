package com.ven.leetcode.linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 <= m <= n <= length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int count = m;
		ListNode node = dummy;
		while (count > 1) {
			node = node.next;
			count--;
		}
		ListNode reverseStart = node;
		ListNode reverse = null;
		ListNode reverseEnd = node.next;
		head = node.next;
		reverseStart.next = null;
		while (m <= n) {
			ListNode temp = head;
			head = head.next;
			temp.next = reverse;
			reverse = temp;
			m++;
		}
		reverseStart.next = reverse;
		reverseEnd.next = head;

		return dummy.next;
	}
}
