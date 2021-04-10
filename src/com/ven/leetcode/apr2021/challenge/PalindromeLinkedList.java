package com.ven.leetcode.apr2021.challenge;

import com.ven.leetcode.linkedlist.ListNode;

/**
 * Given the head of a singly linked list, return true if it is a palindrome.
 * 
 * Example 1:
 * 
 * Input: head = [1,2,2,1] Output: true Example 2:
 * 
 * Input: head = [1,2] Output: false
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range [1, 105]. 0 <= Node.val <= 9
 * 
 * Follow up: Could you do it in O(n) time and O(1) space?
 * 
 * @author Venkatesh Manohar
 *
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		if (head.next == null) {
			return true;
		}
		int length = 0;
		ListNode curr = head;
		while (curr != null) {
			length++;
			curr = curr.next;
		}
		int mid = (length / 2) - 1;

		ListNode tempHead = head;
		while (mid > 0) {
			tempHead = tempHead.next;
			mid--;
		}

		ListNode head2 = tempHead.next;
		tempHead.next = null;

		ListNode rev = null;

		while (head != null) {
			ListNode node = head;
			head = head.next;
			node.next = null;
			node.next = rev;
			rev = node;
		}
		head = rev;
		if (length % 2 == 1) {
			head2 = head2.next;
		}
		while (head != null && head2 != null) {
			if (head.val != head2.val) {
				return false;
			}
			head = head.next;
			head2 = head2.next;

		}
		return true;

	}
}
