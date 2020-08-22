package com.ven.leetcode.augchallenge;

/**
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3. Example 2:
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * @author Venkatesh Manohar
 *
 */
class ListNode {
	int val;
	ListNode next;

	ListNode() {
	}

	ListNode(int val) {
		this.val = val;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}
}

public class ReorderList {
	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) {
			return;
		}
		ListNode fast = head;
		ListNode slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		ListNode reverseTemp = slow.next;
		slow.next = null;

		// Reverse the second half
		ListNode reverse = null;
		while (reverseTemp != null) {
			ListNode temp = reverseTemp;
			reverseTemp = reverseTemp.next;
			temp.next = reverse;
			reverse = temp;
		}
		// Merge first half and second half node by node
		ListNode curr = head;
		while (curr != null && reverse != null) {
			ListNode next = curr.next;
			ListNode tail = reverse;
			reverse = reverse.next;
			tail.next = null;
			curr.next = tail;
			tail.next = next;
			curr = next;
		}
	}
	
	public static void main(String[] args) {
		ReorderList r = new ReorderList();
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next.next = new ListNode(3);
		l.next.next.next = new ListNode(4);
		l.next.next.next.next = new ListNode(5);
		
		r.reorderList(l);
		while(l != null) {
			System.out.print(l.val+"->");
			l = l.next;
		}
		
	}
}
