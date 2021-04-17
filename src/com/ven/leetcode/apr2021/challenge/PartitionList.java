package com.ven.leetcode.apr2021.challenge;

import com.ven.leetcode.linkedlist.ListNode;

/**
 * Given the head of a linked list and a value x, partition it such that all
 * nodes less than x come before nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the
 * two partitions.
 * 
 * Example 1:
 * 
 * Input: head = [1,4,3,2,5,2], x = 3 Output: [1,2,2,4,3,5] Example 2:
 * 
 * Input: head = [2,1], x = 2 Output: [1,2]
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [0, 200]. -100 <= Node.val <=
 * 100 -200 <= x <= 200
 * 
 * @author Venkatesh Manohar
 *
 */
public class PartitionList {
	public ListNode partition(ListNode head, int x) {
		ListNode lt = new ListNode();
		ListNode gt = new ListNode();
		ListNode currlt = lt;
		ListNode currgt = gt;

		while (head != null) {

			if (head.val < x) {
				currlt.next = head;
				head = head.next;
				currlt = currlt.next;
				currlt.next = null;
			} else {
				currgt.next = head;
				head = head.next;
				currgt = currgt.next;
				currgt.next = null;
			}
		}

		head = lt.next;
		if (head == null) {
			head = gt.next;
		} else {
			currlt.next = gt.next;
		}
		return head;
	}
}