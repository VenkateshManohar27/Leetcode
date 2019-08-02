package com.ven.leetcode.easy;

public class MergeTwoLists {

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode merged = null, mergedTail = null, node;
		/* When both the lists are not null*/
		while (l1 != null && l2 != null) {
			node = null;
			if (l1.val <= l2.val) {
				node = new ListNode(l1.val);
				l1 = l1.next;
			} else {
				node = new ListNode(l2.val);
				l2 = l2.next;
			}
			if (merged == null) {
				merged = node;
				mergedTail = node;
			} else {
				mergedTail.next = node;
				mergedTail = mergedTail.next;
			}
		}
		if (l1 == null) {
			if (merged == null) {
				return l2;
			}
			mergedTail.next = l2;
			return merged;
		}

		if (l2 == null) {
			if (merged == null) {
				return l1;
			}
			mergedTail.next = l1;
			return merged;
		}
		return null;
	}

	public ListNode mergeTwoListsMemoryOptimized(ListNode l1, ListNode l2) {
		ListNode merged = null, mergedTail = null, node;
		/* When both the lists are not null*/
		while (l1 != null && l2 != null) {
			node = null;
			if (l1.val <= l2.val) {
				node = l1;
				l1 = l1.next;
				node.next = null;
			} else {
				node = l2;
				l2 = l2.next;
				node.next = null;
			}
			if (merged == null) {
				merged = node;
				mergedTail = node;
			} else {
				mergedTail.next = node;
				mergedTail = mergedTail.next;
			}
		}
		if (l1 == null) {
			if (merged == null) {
				return l2;
			}
			mergedTail.next = l2;
			return merged;
		}

		if (l2 == null) {
			if (merged == null) {
				return l1;
			}
			mergedTail.next = l1;
			return merged;
		}
		return null;
	}
	public static void main(String[] args) {
		MergeTwoLists mt = new MergeTwoLists();
		ListNode l1 = new ListNode(1);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		ListNode l2 = new ListNode(1);
		l2.next = new ListNode(3);
		l2.next.next = new ListNode(4);
		ListNode merged = mt.mergeTwoLists(l1, l2);
		
		while(merged !=null) {
		System.out.println(merged.val);
		merged = merged.next;
		}
	}
}

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}
