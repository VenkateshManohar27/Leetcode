package com.ven.leetcode.jul2021.challenge;

import com.ven.leetcode.linkedlist.ListNode;
import com.ven.utility.ListUtility;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and
 * return its modified list.
 * 
 * k is a positive integer and is less than or equal to the length of the linked
 * list. If the number of nodes is not a multiple of k then left-out nodes, in
 * the end, should remain as it is.
 * 
 * You may not alter the values in the list's nodes, only nodes themselves may
 * be changed.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 2 Output: [2,1,4,3,5] Example 2:
 * 
 * 
 * Input: head = [1,2,3,4,5], k = 3 Output: [3,2,1,4,5] Example 3:
 * 
 * Input: head = [1,2,3,4,5], k = 1 Output: [1,2,3,4,5] Example 4:
 * 
 * Input: head = [1], k = 1 Output: [1]
 * 
 * 
 * Constraints:
 * 
 * The number of nodes in the list is in the range sz. 1 <= sz <= 5000 0 <=
 * Node.val <= 1000 1 <= k <= sz
 * 
 * 
 * Follow-up: Can you solve the problem in O(1) extra memory space?
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReverseNodeskGroup {
	public ListNode reverseKGroup(ListNode head, int k) {
		int c = k;
		ListNode newHead = null;
		ListNode curr = head;
		ListNode tail = null;
		while (curr != null) {
			c = k;
			//tail = curr;
			while (curr != null && c > 1) {
				curr = curr.next;
				//tail = curr;
				c--;
			}

			if (c == 1 && curr != null) {
				ListNode temp = curr;
				curr = curr.next;
				temp.next = null;
				
				if (newHead == null) {
					newHead = reverse(head);
				} else {
					tail.next = reverse(head);
				}
				tail = head;
				head = curr;
			}else {
				if(tail != null) {
					tail.next = head;
				}
			}
		}

		return (newHead != null)? newHead: head;
	}

	private ListNode reverse(ListNode node) {
		ListNode head = null;
		while (node != null) {
			ListNode temp = node.next;
			node.next = head;
			head = node;
			node = temp;
			
		}
		return head;
	}
	
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ReverseNodeskGroup r = new ReverseNodeskGroup();
		ListNode l = r.reverseKGroup(head, 2);
		ListUtility.print(l);
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListUtility.print(r.reverseKGroup(head, 2));
		head = new ListNode(1);
		ListUtility.print(r.reverseKGroup(head, 2));
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListUtility.print(r.reverseKGroup(head, 3));
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListUtility.print(r.reverseKGroup(head, 4));
		
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListUtility.print(r.reverseKGroup(head, 6));
	}
	
	
	
}
