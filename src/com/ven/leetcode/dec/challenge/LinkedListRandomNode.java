package com.ven.leetcode.dec.challenge;

import com.ven.leetcode.linkedlist.ListNode;

/**
 * Given a singly linked list, return a random node's value from the linked
 * list. Each node must have the same probability of being chosen.
 * 
 * Follow up: What if the linked list is extremely large and its length is
 * unknown to you? Could you solve this efficiently without using extra space?
 * 
 * Example:
 * 
 * // Init a singly linked list [1,2,3]. ListNode head = new ListNode(1);
 * head.next = new ListNode(2); head.next.next = new ListNode(3); Solution
 * solution = new Solution(head);
 * 
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should
 * have equal probability of returning. solution.getRandom();
 * 
 * @author Venkatesh Manohar
 *
 */
public class LinkedListRandomNode {
	private ListNode head;

	/**
	 * @param head
	 *            The linked list's head. Note that the head is guaranteed to be not
	 *            null, so it contains at least one node.
	 */
	public LinkedListRandomNode(ListNode head) {
		this.head = head;
	}

	/** Returns a random node's value. */
	public int getRandom() {
		int scope = 1, chosenValue = 0;
		ListNode curr = this.head;
		while (curr != null) {
			// decide whether to include the element in reservoir
			if (Math.random() < 1.0 / scope)
				chosenValue = curr.val;
			// move on to the next node
			scope += 1;
			curr = curr.next;
		}
		return chosenValue;
	}
}
