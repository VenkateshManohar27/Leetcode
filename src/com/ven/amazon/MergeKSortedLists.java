package com.ven.amazon;

import java.util.PriorityQueue;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and
 * describe its complexity.
 * 
 * Example:
 * 
 * Input: [ 1->4->5, 1->3->4, 2->6 ] Output: 1->1->2->3->4->4->5->6
 * 
 * @author Venkatesh Manohar
 *
 */
public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		ListNode head = new ListNode(0);

		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);

		for (ListNode node : lists) {
			while (node != null) {
				ListNode temp = node;
				node = node.next;
				temp.next = null;
				pq.add(temp);

			}
		}
		ListNode curr = head;
		while (!pq.isEmpty()) {
			curr.next = pq.poll();
			curr = curr.next;
		}

		return head.next;
	}

	/**
	 * Runtime: 5 ms, faster than 75.70% of Java online submissions for Merge k
	 * Sorted Lists. Memory Usage: 40.7 MB, less than 49.18% of Java online
	 * submissions for Merge k Sorted Lists.
	 * 
	 * @param lists
	 * @return
	 */
	public ListNode mergeKListsOptimized(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
			return null;
		}

		ListNode head = new ListNode(0);

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

		for (ListNode node : lists) {
			while (node != null) {
				pq.add(node.val);
			}
		}
		ListNode curr = head;
		while (!pq.isEmpty()) {
			curr.next = new ListNode(pq.poll());
			curr = curr.next;
		}

		return head.next;
	}
}
