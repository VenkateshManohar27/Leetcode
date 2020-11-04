package com.ven.leetcode.nov.challenge;

/**
 * Sort a linked list using insertion sort.
 * 
 * 
 * A graphical example of insertion sort. The partial sorted list (black)
 * initially contains only the first element in the list. With each iteration
 * one element (red) is removed from the input data and inserted in-place into
 * the sorted list
 * 
 * 
 * Algorithm of Insertion Sort:
 * 
 * Insertion sort iterates, consuming one input element each repetition, and
 * growing a sorted output list. At each iteration, insertion sort removes one
 * element from the input data, finds the location it belongs within the sorted
 * list, and inserts it there. It repeats until no input elements remain.
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
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}

		ListNode dummy = new ListNode();
		dummy.next = head;
		// ListNode next = head.next;
		// ListNode prev = head;
		head = head.next;
		dummy.next.next = null;

		while (head != null) {
			ListNode temp = head;
			head = head.next;
			temp.next = null;
			// System.out.println((head!= null)?head.val:"HEADNULL");
			ListNode curr = dummy.next;
			ListNode prevCurr = dummy;
			// System.out.println("Temp:"+temp.val);
			while (curr != null && temp.val > curr.val) {
				// System.out.println("Curr:"+curr.val);
				curr = curr.next;
				prevCurr = prevCurr.next;
			}
			temp.next = prevCurr.next;
			prevCurr.next = temp;

		}
		return dummy.next;
	}
}
