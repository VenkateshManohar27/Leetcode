package com.ven.leetcode.linkedlist;

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
		if (head == null) {
			return head;
		}
		int length = 0;
		ListNode node = head;
		while (node != null) {
			length++;
			node = node.next;
		}

		k = k % length;
		if (k == 0) {
			return head;
		}
		
		//To find the last node of new list
		int index = length - k;

		node = head;
		while (index > 1) {
			node = node.next;
			index--;
		}

		ListNode start = node.next;
		ListNode end = node.next;
		node.next = null;
		while (end.next != null) {
			end = end.next;
		}

		end.next = head;
		head = start;
		return head;
	}
}
