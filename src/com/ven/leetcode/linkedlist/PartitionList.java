package com.ven.leetcode.linkedlist;

/**
 * Given a linked list and a value x, partition it such that all nodes less than
 * x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example:
 * 
 * Input: head = 1->4->3->2->5->2, x = 3 Output: 1->2->2->4->3->5
 * 
 * @author Venkatesh Manohar
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode head1, p1 = new ListNode(0), head2, p2 = new ListNode(0);
		head1 = p1;
		head2 = p2;
		ListNode curr = null;
		while (head != null) {
			curr = head;
			head = head.next;
			curr.next = null;
			if (curr.val < x) {
				p1.next = curr;
				p1 = p1.next;

			} else {
				p2.next = curr;
				p2 = p2.next;
			}

		}
		p2.next = null;
		p1.next = head2.next;
		return head1.next;
	}
}
