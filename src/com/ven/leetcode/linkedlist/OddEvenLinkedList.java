package com.ven.leetcode.linkedlist;

/**
 * Given a singly linked list, group all odd nodes together followed by the even
 * nodes. Please note here we are talking about the node number and not the
 * value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space
 * complexity and O(nodes) time complexity.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL Output: 1->3->5->2->4->NULL Example 2:
 * 
 * Input: 2->1->3->5->6->4->7->NULL Output: 2->3->6->7->1->5->4->NULL Note:
 * 
 * The relative order inside both the even and odd groups should remain as it
 * was in the input. The first node is considered odd, the second node even and
 * so on ...
 * 
 * @author Venkatesh Manohar
 *
 */
public class OddEvenLinkedList {
	
	//Java Soln Runtime: 43 ms, Memory Usage: 41.5 MB
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
			return head;
		}
		ListNode oddHead = null;
		ListNode evenHead = null;
		ListNode odd = null;
		ListNode even = null;
		int count = 1;
		while (head != null) {

			if (count % 2 == 0) {
				if (even == null) {
					evenHead = head;
					even = head;
					head = head.next;
					even.next = null;
				} else {
					even.next = head;
					head = head.next;
					even = even.next;
					even.next = null;
				}
			} else {
				if (odd == null) {
					oddHead = head;
					odd = head;
					head = head.next;
					odd.next = null;
				} else {
					odd.next = head;
					head = head.next;
					odd = odd.next;
					odd.next = null;
				}
			}
			count++;
		}
		odd.next = evenHead;
		return oddHead;
	}
//Java Soln Runtime: 0 ms, faster than 100.00%, Memory Usage: 36.2 MB, less than 100.00%
	
	public ListNode oddEvenList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		
		ListNode oddHead = head;
		ListNode evenHead = head.next;
		ListNode oddTail = head;
		ListNode evenTail = head.next;
		head = head.next.next;
		oddHead.next = null;
		evenHead.next = null;
		while(head != null && head.next != null) {
			oddTail.next = head;
			oddTail = oddTail.next;
			evenTail.next = head.next;
			evenTail = evenTail.next;
			head = head.next.next;
			oddTail.next = null;
			evenTail.next = null;
		}
		if(head != null) {
			oddTail.next = head;
			oddTail = oddTail.next;
		}
		oddTail.next = evenHead;
		return oddHead;
	}
}
