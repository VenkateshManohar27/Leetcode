package com.ven.leetcode.linkedlist;

public class SwapNodesPairs {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode first = head;
		ListNode second = head.next;
		ListNode previousTail = dummy;
		while (first != null && second != null) {
			first.next = second.next;
			second.next = first;
			previousTail.next = second;
			previousTail = first;
			first = first.next;
			second = (first != null) ? first.next : null;
		}
		return dummy.next;
	}
}
