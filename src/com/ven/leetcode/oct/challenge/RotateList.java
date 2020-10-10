package com.ven.leetcode.oct.challenge;

import com.ven.leetcode.linkedlist.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is
 * non-negative.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL, k = 2 Output: 4->5->1->2->3->NULL Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL rotate 2 steps to the right:
 * 4->5->1->2->3->NULL Example 2:
 * 
 * Input: 0->1->2->NULL, k = 4 Output: 2->0->1->NULL Explanation: rotate 1 steps
 * to the right: 2->0->1->NULL rotate 2 steps to the right: 1->2->0->NULL rotate
 * 3 steps to the right: 0->1->2->NULL rotate 4 steps to the right:
 * 2->0->1->NULL
 * 
 * @author Venkatesh Manohar
 *
 */
public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return head;

		int count = 0;
		ListNode curr = head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}

		k = k % count;
		if (k == 0)
			return head;

		ListNode slow = head;
		ListNode fast = head;
		for (int i = 0; i < k; i++) {
			fast = fast.next;
		}
		// newHead = fast.next;
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}

		fast.next = head;
		head = slow.next;
		slow.next = null;
		return head;

	}

	public ListNode rotateRight2(ListNode head, int k) {
		int count = 0;
		ListNode curr = head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		if (head == null)
			return head;

		k = k % count;
		System.out.println("count:" + count);
		System.out.println("k % count:" + k);
		if (k == 0)
			return head;
		count--;
		curr = head;
		ListNode newHead = null;
		while (curr.next != null && count - k > 0) {
			curr = curr.next;
			count--;
		}
		if (curr != null && curr.next != null) {
			newHead = curr.next;
			curr.next = null;
			ListNode temp = newHead;
			while (newHead.next != null) {
				newHead = newHead.next;
			}

			newHead.next = head;
			head = temp;
		}
		return head;
	}

}
