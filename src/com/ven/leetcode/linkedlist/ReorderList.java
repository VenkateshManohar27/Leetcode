package com.ven.leetcode.linkedlist;

import java.util.Stack;

/**
 * Given a singly linked list L: L0->L1->…->Ln-1->Ln, reorder it to:
 * L0->Ln->L1->Ln-1->L2->Ln-2->…
 * 
 * You may not modify the values in the list's nodes, only nodes itself may be
 * changed.
 * 
 * Example 1:
 * 
 * Given 1->2->3->4, reorder it to 1->4->2->3. Example 2:
 * 
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 * 
 * @author Venkatesh Manohar
 *
 */
public class ReorderList {
	public void reorderList(ListNode head) {
		if(head == null || head.next == null) {
			return;
		}
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode slow = dummy, fast = head;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode temp = slow;
		slow = slow.next;
		temp.next = null;
		Stack<ListNode> s = new Stack<>();
		while(slow != null) {
			ListNode curr = slow;
			slow = slow.next;
			curr.next = null;
			s.push(curr);
		}
		slow = head;
		while(!s.isEmpty() && slow != null) {
			ListNode top = s.pop();
			ListNode next = slow.next;
			slow.next = top;
			if(next == null && !s.isEmpty()) {
				top.next = s.pop();
			}else {
				top.next = next;
			}
			slow = next;
		}
		
		dummy.next = null;
	}
	
	public static void main(String[] args) {
		ReorderList rl = new ReorderList();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		rl.reorderList(head);
		while(head != null) {
			System.out.print(head.val+"->");
			head= head.next;
		}
		System.out.println();
		head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		rl.reorderList(head);
		while(head != null) {
			System.out.print(head.val+"->");
			head= head.next;
		}
		System.out.println();
		head = new ListNode(1);
		rl.reorderList(head);
		while(head != null) {
			System.out.print(head.val+"->");
			head= head.next;
		}
		System.out.println();
		head = null;
		rl.reorderList(head);
		while(head != null) {
			System.out.print(head.val+"->");
			head= head.next;
		}
	}
}
