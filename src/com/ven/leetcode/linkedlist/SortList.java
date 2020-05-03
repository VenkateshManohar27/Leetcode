package com.ven.leetcode.linkedlist;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * 
 * Input: 4->2->1->3 Output: 1->2->3->4 Example 2:
 * 
 * Input: -1->5->3->4->0 Output: -1->0->3->4->5
 * 
 * @author Venkatesh Manohar
 *
 */
public class SortList {
	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
			@Override
			public int compare(ListNode o1, ListNode o2) {
				return o1.val - o2.val;
			}
		});

		ListNode curr = head;
		ListNode dummy = new ListNode(0);
		while (curr != null) {
			pq.add(curr);
			ListNode next = curr.next;
			curr.next = null;
			curr = next;
		}
		curr = dummy;
		while (!pq.isEmpty()) {
			curr.next = pq.poll();
			curr = curr.next;
		}
		return dummy.next;
	}
}
