package com.ven.leetcode.linkedlist;

/**
 * Reverse a linked list from position m to n. Do it in one-pass.
 * 
 * Note: 1 <= m <= n <= length of list.
 * 
 * Example:
 * 
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4 Output: 1->4->3->2->5->NULL
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseLinkedListII {
	public ListNode reverseBetween(ListNode head, int m, int n) {
		if (head == null) {
			return head;
		}

		ListNode result = head;
		ListNode resultTail = null;
		/*head = head.next;
		resultTail.next = null;*/
		ListNode reverse = null;
		ListNode reverseEnd = null;
		int count = 1;
		ListNode node = head;
		while (node != null) {
			
			while(count < m && node != null) {
				node = node.next;
				resultTail = node;
				count++;
			}
			
			
			if (m == count) {
				reverse = node;
				node = node.next;
				reverseEnd = reverse;
				reverse.next = null;
				count++;
				continue;
			}
			if (count > m && count <= n) {
				ListNode temp = node;
				node = node.next;
				temp.next = reverse;
				reverse = temp;
				count++;
				continue;
			}
			resultTail.next = head;
			head = head.next;
			resultTail = resultTail.next;
			resultTail.next = null;
			count++;

		}
		resultTail.next = reverse;
		if(reverseEnd != null)
		reverseEnd.next = head;

		return result;
	}
}
