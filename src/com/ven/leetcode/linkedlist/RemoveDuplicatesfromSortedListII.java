package com.ven.leetcode.linkedlist;

public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		head = dummy;
		ListNode first = dummy.next;
		ListNode second = (dummy.next != null) ? dummy.next.next : null;
		while (first != null && second != null) {
			if (first.val != second.val) {
				second = second.next;
				first = first.next;
				dummy = dummy.next;
			} else {
				while (second != null && first.val == second.val) {
					second = second.next;
				}
				first = second;
				second = (second != null) ? second.next : null;
				dummy.next = first;
			}
		}
		return head.next;
	}
}
