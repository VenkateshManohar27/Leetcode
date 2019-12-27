package com.ven.leetcode.medium;

public class RemoveNthNodeFromEndofList {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null)
			return null;

		ListNode fast = head, slow = head;
		while (n > 0 && fast != null) {
			fast = fast.next;
			n--;
		}

		while (fast != null && fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		
		if (fast == null) {
			head = head.next;
		} else {
			slow.next = slow.next.next;
		}

		return head;
	}
}
