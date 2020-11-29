package com.ven.leetcode.biweek40;

import com.ven.leetcode.linkedlist.ListNode;

public class MergeBetweenLinkedLists {
	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode dummy = new ListNode();
		dummy.next = list1;
		ListNode prev = dummy;
		ListNode curr = list1;

		ListNode list2end = list2;
		while (list2end.next != null) {
			list2end = list2end.next;
		}
		boolean start = false;
		while (curr != null) {
			// System.out.println(curr.val);
			if (curr.val == a) {
				prev.next = list2;
				if (curr.val == b) {
					list2end.next = curr.next;
					break;
				}
				curr = curr.next;
				start = true;
			} else if (curr.val == b) {
				list2end.next = curr.next;
				break;
			} else {
				curr = curr.next;
				if (!start)
					prev = prev.next;
			}

		}

		return dummy.next;

	}
}
