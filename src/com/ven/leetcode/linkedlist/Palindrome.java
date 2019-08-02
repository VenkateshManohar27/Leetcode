package com.ven.leetcode.linkedlist;

public class Palindrome {
	public boolean isPalindrome(ListNode head) {
		if (head == null || head.next == null) {
			return true;
		}
		
		ListNode slow = head, fast = head, prev = null;
		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = null;
		ListNode newHead = reverse(slow);
		while (head != null && newHead != null) {
			if (head.val != newHead.val)
				return false;
			head = head.next;
			newHead = newHead.next;
		}
		return true;
	}

	private ListNode reverse(ListNode node) {
		if (node.next == null) {
			return node;
		}
		ListNode newHead = node;
		node = node.next;
		newHead.next = null;

		while (node != null) {
			ListNode temp = node;
			node = node.next;
			temp.next = newHead;
			newHead = temp;
		}
		return newHead;
	}
}
