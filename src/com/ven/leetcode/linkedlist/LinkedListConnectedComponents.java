package com.ven.leetcode.linkedlist;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * We are given head, the head node of a linked list containing unique integer
 * values.
 * 
 * We are also given the list G, a subset of the values in the linked list.
 * 
 * Return the number of connected components in G, where two values are
 * connected if they appear consecutively in the linked list.
 * 
 * Example 1:
 * 
 * Input: head: 0->1->2->3 G = [0, 1, 3] Output: 2 Explanation: 0 and 1 are
 * connected, so [0, 1] and [3] are the two connected components. Example 2:
 * 
 * Input: head: 0->1->2->3->4 G = [0, 3, 1, 4] Output: 2 Explanation: 0 and 1
 * are connected, 3 and 4 are connected, so [0, 1] and [3, 4] are the two
 * connected components. Note:
 * 
 * If N is the length of the linked list given by head, 1 <= N <= 10000. The
 * value of each node in the linked list will be in the range [0, N - 1]. 1 <=
 * G.length <= 10000. G is a subset of all values in the linked list.
 * 
 * @author Venkatesh Manohar
 *
 */
public class LinkedListConnectedComponents {
	// Runtime: 13 ms, faster than 13.30% of Java online submissions for Linked List
	// Components.
	// Memory Usage: 40.6 MB, less than 76.92% of Java online submissions for Linked
	// List Components.
	public int numComponents(ListNode head, int[] G) {
		Set<Integer> set = new HashSet<>();

		for (int i = 0; i < G.length; i++) {
			set.add(G[i]);
		}
		int components = 0;
		boolean connected = false;
		System.out.println(set);
		while (head != null) {
			System.out.println(head.val);
			System.out.println("connected:" + connected);
			if (set.contains(head.val)) {
				if (!connected)
					components++;
				connected = true;
			} else {
				connected = false;
			}
			System.out.println("connected:" + connected);
			head = head.next;
		}
		return components;
	}

	public static void main(String[] args) throws IOException {
		ListNode node = new ListNode(0);
		node.next = new ListNode(1);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(3);

		LinkedListConnectedComponents lc = new LinkedListConnectedComponents();
		// System.out.println("No of Components: "+lc.numComponents(node, new int[] { 0,
		// 1, 3 }));
		node = new ListNode(0);
		node.next = new ListNode(1);
		node.next.next = new ListNode(2);
		node.next.next.next = new ListNode(3);
		node.next.next.next.next = new ListNode(4);
		System.out.println("No of Components: " + lc.numComponents(node, new int[] { 0, 3, 1, 4 }));

		node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(0);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(3);
		System.out.println("No of Components: " + lc.numComponents(node, new int[] { 3, 4, 0, 2, 1 }));

	}
}
