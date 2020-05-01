package com.ven.sorting;

import com.ven.leetcode.linkedlist.ListNode;
import com.ven.leetcode.tree.binarytree.ptr.Node;

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
		if(head == null || head.next == null) {
			return head;
		}
		
		int length = 0;
		ListNode n = head;
		while(n != null) {
			length++;
			n = n.next;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		int index = 1;
		
		for (int i = 1; i < length; i++) {
			index = 1;
			ListNode prev = head;
			ListNode curr = head.next;
			while(index != i) {
				prev = prev.next; 
				curr = curr.next;
				index++;
			}
			prev.next = curr.next;
			curr.next = null;
			ListNode previous = dummy;
			ListNode current = head;
			int currIndex = 0;
			while(currIndex <= i) {
				if(current == null || currIndex == i || current.val > curr.val ) {
					previous.next = curr;
					curr.next = current;
					break;
				}
				current = current.next;
				previous = previous.next;
				currIndex++;
			}
			
			
			head = dummy.next;
		}
		return dummy.next;
	}
	
	public ListNode insertionSortList2(ListNode head) {
		if(head == null || head.next == null) {
			return head;
		}
		ListNode dummy = new ListNode(0);
		ListNode curr = head, next = null;
		dummy.next = head;
		
		while(curr != null) {
			next = curr.next;
			ListNode p = dummy;
			
			while(p.next != null && p.next.val <= curr.val)
				p = p.next;
			
			curr.next = p.next;
			p.next = curr;
			curr = next;
		
		}
		
		return dummy.next;
	}
	
	public static void main(String[] args) {
		ListNode n = new ListNode(4);
		n.next = new ListNode(3);
		n.next = new ListNode(2);
		n.next = new ListNode(1);
		
		InsertionSortList isl = new InsertionSortList();
		
		ListNode li = isl.insertionSortList(n);
		
	}
}
